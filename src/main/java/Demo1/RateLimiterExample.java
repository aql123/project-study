package Demo1;
/**
 * @description: 内容：
 * 1、限流原理 -- 令牌桶算法
 * 令牌桶算法的原理是系统会以一个恒定的速度（每秒生成一个令牌）往桶里放入令牌。当有访问者（针对于 IP）要访问接口时，
 * 则需要先从桶里获取一个令牌，当桶里没有令牌可取时，则拒绝服务。 当桶满时，新添加的令牌被丢弃或拒绝。
 * 高并发下，api接口面临压力过大的情况。针对此类情况，一般有一下几种处理方案。
 *
 * 缓存 缓存的目的是提升系统访问速度和增大系统处理容量
 *
 * 降级 降级是当服务出现问题或者影响到核心流程时，需要暂时屏蔽掉，待高峰或者问题解决后再打开
 *
 * 限流 限流的目的是通过对并发访问/请求进行限速，或者对一个时间窗口内的请求进行限速来保护系统，一旦达到限制速率则可以拒绝服务、排队或等待、降级等处理
 *
 *   一般开发高并发系统常见的限流模式有控制并发和控制速率，一个是限制并发的总数量（比如数据库连接池、线程池），一个是限制并发访问的速率（如nginx的limit_conn模块，用来限制瞬时并发连接数），另外还可以限制单位时间窗口内的请求数量（如Guava的RateLimiter、nginx的limit_req模块，限制每秒的平均速率）。其他还有如限制远程接口调用速率、限制MQ的消费速率。另外还可以根据网络连接数、网络流量、CPU或内存负载等来限流。
 * 相关概念
 * PV:page view 页面总访问量，每刷新一次记录一次。
 *
 * UV:unique view 客户端主机访问，指一天内相同IP的访问记为1次。
 *
 * QPS:query per second,即每秒访问量。qps很大程度上代表了系统的繁忙度，没次请求可能存在多次的磁盘io，网络请求，多个cpu时间片，一旦qps超过了预先设置的阀值，可以考量扩容增加服务器，避免访问量过大导致的宕机。
 *
 * RT:response time,每次请求的响应时间,直接决定用户体验性。
 * java api 接口限流 控制并发和控制速率两种方法的使用。
 * @author: aiqiulin
 * @Date: 2022/05/10 18:01
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.currentThread;

/**
 * 关于限流 目前存在两大类，从线程个数（jdk1.5 Semaphore）和RateLimiter速率(guava)
 * Semaphore：从线程个数限流
 * RateLimiter：从速率限流  目前常见的算法是漏桶算法和令牌算法，下面会具体介绍
 *
 * @author lwc
 * @version 1.0
 **/
public class RateLimiterExample {

    /**
     * Guava  0.5的意思是 1秒中0.5次的操作，2秒1次的操作  从速度来限流，从每秒中能够执行的次数来
     */
//    private final static RateLimiter limiter = RateLimiter.create(0.5d);

    /**
     * 同时只能有三个线程工作 Java1.5  从同时处理的线程个数来限流
     */
    private final static Semaphore sem = new Semaphore(3);

    private static void testSemaphore() {
        try {
            sem.acquire();
            System.out.println(currentThread().getName() + " is doing work...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
            System.out.println(currentThread().getName() + " release the semephore..other thread can get and do job");
        }
    }

    public static void runTestSemaphore() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(RateLimiterExample::testSemaphore);
        }
    }

    /**
     * Guava的RateLimiter
     */
    private static void testLimiter() {
//        System.out.println(currentThread().getName() + " waiting  " + limiter.acquire());
    }

    /**
     * Guava的RateLimiter
     */
    public static void runTestLimiter() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(RateLimiterExample::testLimiter);
        }
    }


    public static void main(String[] args) {
//        runTestSemaphore();
        runTestLimiter();
    }
}

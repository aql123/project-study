package Demo1;

/**
 * @description: 内容：
 * 1、限流原理 -- 令牌桶算法
 * 令牌桶算法的原理是系统会以一个恒定的速度（每秒生成一个令牌）往桶里放入令牌。当有访问者（针对于 IP）要访问接口时，
 * 则需要先从桶里获取一个令牌，当桶里没有令牌可取时，则拒绝服务。 当桶满时，新添加的令牌被丢弃或拒绝。
 * @author: aiqiulin
 * @Date: 2022/05/10 18:01
 */
public class LoadingCacheService {
}

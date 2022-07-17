package ThreaPoolExecutor;

/**
 * @Describe 创建线程方式：继承Thread类、重写run方法，调用start线程
 * @Author aiqiulin
 * @Date 2022/7/17 14:02
 */

// 线程开启 不一定立即执行 由CPU调度执行
public class TestThread1 extends Thread {
    @Override
    public void run() {

       // run方法线程体  可入工会  了任务钛合金 个可燃物太烦了
        for (int i = 0; i <20 ; i++) {
            System.out.println("bbbbbb"+i);
        }
    }

    public static void main(String[] args) {

        TestThread1 testThread1 = new TestThread1();
            // testThread1.start();
            // 调用start开启线程
        testThread1.run();
        //main主线程
        for (int i = 0; i <20 ; i++) {
            System.out.println("aaaaaaa"+i);
        }
    }



}

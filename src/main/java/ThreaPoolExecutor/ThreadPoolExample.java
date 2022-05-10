package ThreaPoolExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 给定的程序创建5个任务并提交到executor队列。Executor使用两个线程执行所有任务。
 * @author: aiqiulin
 * @Date: 2022/03/30 15:04
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        for (int i=1;i<=5;i++){
            Task task = new Task("ThreaPoolExecutor.Task"+i);
            System.out.println("Created:"+task.getName());
            executor.execute(task);
        }
        executor.shutdown();
    }
}

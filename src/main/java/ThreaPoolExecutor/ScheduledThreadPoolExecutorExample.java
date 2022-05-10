package ThreaPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: ScheduledThreadPoolExecutor示例
 * @author: aiqiulin
 * @Date: 2022/03/30 15:22
 */
//5. ScheduledThreadPoolExecutor
//当您必须只执行一次惟一任务时，固定线程池或缓存线程池是很好的选择。当您需要执行一个任务，重复N次，或者N次固定次数，或者在固定延迟之后无限次，您应该使用ScheduledThreadPoolExecutor。
//ScheduledThreadPoolExecutor提供了4种方法，它们提供不同的功能以重复的方式执行任务。
//ScheduledFuture schedule(Runnable command, long delay, TimeUnit unit)——创建并执行在给定延迟之后启用的任务。
//ScheduledFuture schedule(Callable callable, long delay, TimeUnit unit)——创建并执行在给定延迟之后启用的ScheduledFuture。
//ScheduledFuture scheduleAtFixedRate(Runnable command, long initialDelay, long delay, TimeUnit unit)——创建并执行一个周期性动作，该动作在给定的初始延迟之后首先启用，然后在给定的延迟期间启用。如果此任务的任何执行花费的时间超过其周期，则后续执行可能会延迟开始，但不会并发执行。
//ScheduledFuture scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)——创建并执行一个周期性动作，该动作在给定的初始延迟之后首先启用，然后在给定的延迟期间启用。无论一个长时间运行的任务花费多少时间，两次执行之间都会有一个固定的延迟时间间隔。

public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);

        Task task = new Task("Repeat Task");
        System.out.println("Created : " + task.getName());

        executor.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
    }
}

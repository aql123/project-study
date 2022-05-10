package ThreaPoolExecutor;

/**
 * @description:
 * @author: aiqiulin
 * @Date: 2022/03/30 15:54
 */
public class CustomThreadPoolExample {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());
            customThreadPool.execute(task);
        }
    }
}

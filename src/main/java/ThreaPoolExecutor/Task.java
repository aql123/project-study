package ThreaPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:  Java线程池 - ThreadPoolExecutor示例
 * @author: aiqiulin
 * @Date: 2022/03/30 14:57
 */
public class Task implements Runnable {

    private  String name;
    public Task(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    @Override
    public void run() {
            try {
                Long duration = (long) (Math.random() * 10);
                System.out.println("Executing : " + name);
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}



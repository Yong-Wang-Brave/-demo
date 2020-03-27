import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 运行结果：
 * 线程一
 * 线程二
 */
public class Timer2之问题解决 {
    public static void main(String[] args){
        ScheduledExecutorService ss =new ScheduledThreadPoolExecutor(10);
        ss.schedule(()->{
       System.out.println("线程一");
       throw new RuntimeException("报错");
        },10, TimeUnit.MICROSECONDS);
        ss.schedule(()->{
      System.out.println("线程二");
        },10, TimeUnit.MICROSECONDS);
    }
}














import java.util.TimerTask;

/**只要其中之一没有捕获
 抛出的异常，其它任务便会自动终止运行
 * 运行结果：
 * 任务一
 * Exception in thread "Timer-0" java.lang.RuntimeException: 生性多疑
 * 	at Timer$1.run(Timer.java:12)
 * 	at java.util.TimerThread.mainLoop(Timer.java:555)
 * 	at java.util.TimerThread.run(Timer.java:505)
 */
public class Timer {

    public static void main(String[] args){
        java.util.Timer  time =new java.util.Timer();

        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务一");
                throw new RuntimeException("生性多疑");
            }
        }, 11);

        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务二");
            }
        }, 11);
    } 
}

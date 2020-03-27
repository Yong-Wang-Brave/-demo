import java.util.concurrent.*;

/**
 * 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
 * 的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明：Executors 返回的线程池对象的弊端如下：
 * 1）FixedThreadPool 和 SingleThreadPool:
 * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
 * 2）CachedThreadPool 和 ScheduledThreadPool:
 * 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM
 */
public class 线程池的创建 {
    public static void main(String[] args){
   //底层源码都是无界的队列
        ExecutorService executorService = Executors.newFixedThreadPool(10);
            /* public LinkedBlockingQueue() {
            this(Integer.MAX_VALUE);
        }*/
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
          /* public LinkedBlockingQueue() {
            this(Integer.MAX_VALUE);
        }*/
//底层源码是创建无界的核心线程池
        ExecutorService executorService2 = Executors.newCachedThreadPool();
     /*   return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }*/

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
          /*      public ScheduledThreadPoolExecutor(int corePoolSize) {
            super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
                    new DelayedWorkQueue());
        }*/
    } 
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 结果：
Tue Dec 31 00:59:39 CST 2019
Tue Dec 31 00:59:39 CST 2019
Tue Dec 31 00:59:39 CST 2019
 */
public class simpleDateFormat线程安全 {
public static void main(String[] args){
    for (int i = 0; i <100 ; i++) {
   new Thread(new 线程安全()).start();
    }
}
}
class 线程安全  implements Runnable{
    public static ThreadLocal<SimpleDateFormat>  ss=     new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };
    SimpleDateFormat simpleDateFormat;
    @Override
    public void run() {
        try {
            System.out.println(ss.get().parse("2019-12-31 12:59:39"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
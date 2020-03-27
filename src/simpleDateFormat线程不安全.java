import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 【强制】SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为
 * static，必须加锁，或者使用 DateUtils 工具类。
 * 正例：注意线程安全，使用 DateUtils。亦推荐如下处理：
 * private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
 * @Override
 * protected DateFormat initialValue() {
 * return new SimpleDateFormat("yyyy-MM-dd");
 * }
 * };
 * 说明：如果是 JDK8 的应用，可以使用 Instant 代替 Date，LocalDateTime 代替 Calendar，
 * DateTimeFormatter 代替 SimpleDateFormat，官方给出的解释：simple beautiful strong
 * immutable thread-safe。
 *报错：
 * java.lang.NumberFormatException: For input string: ""
 */
public class simpleDateFormat线程不安全 {
    public static SimpleDateFormat  ss=     new SimpleDateFormat("yyyy-mm-dd");
public static void main(String[] args){
    for (int i = 0; i <100 ; i++) {
   new Thread(new 线程(ss)).start();
    }
}
}
class 线程  implements Runnable{
    public 线程(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }
    SimpleDateFormat simpleDateFormat;
    @Override
    public void run() {
        try {
            simpleDateFormat.parse("2019-12-31 12:59:39");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
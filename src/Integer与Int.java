public class Integer与Int {
public static void main(String[] args){
    Integer a=10;
    int  b =10;
    /*Integer与int比较   Integer会自动拆箱成int类型,比较的是int
   public int intValue() {
    return value;
                         }
    * */
    System.out.println(a==b);//true
    Integer aaa=128;
    Integer  bbb =128;
/*    Integer与integer比较会自动装箱（Interger  in  =integer.valueOf(128)）
*
1)-128   127 之间是直接从缓存中拿的
//2)否则就是new对象
*/
    System.out.println(aaa==bbb);//flase
}

}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Iterator删除数组 {
 public static void main(String[] args){
 List<String> list = new ArrayList<>();
 list.add("x");
 list.add("x");
 list.add("y");
 list.add("y");
 list.add("z");
 list.add("z");
 /* for (int i = 0; i <list.size() ; i++) {
 if("y".equals(list.get(i))){
 list.remove(i);
 }
 }*/

 Iterator<String> iterator = list.iterator();
 while (iterator.hasNext()){

 if("y".equals(iterator.next())){

 iterator.remove();
 }



 }


 System.out.println(list);//[x, x, z, z]
 }
 }
import java.util.HashMap;
import java.util.Objects;
public class hashmap实现重写equals与hashcode {
public static void main(String[] args){
    HashMap<Object,String>  hs=new HashMap<Object,String>();
    hs.put(new Item1("AA","BB"),"CC");
    hs.put(new Item1("AA","BB"),"CC");
    System.out.println(hs.size());//重写后结果是1
}
}
class  Item1{
    public String getAa() {
        return aa;
    }
    public void setAa(String aa) {
        this.aa = aa;
    }
    public String getBb() {
        return bb;
    }
    public void setBb(String bb) {
        this.bb = bb;
    }
    public Item1(String aa, String bb) {
        this.aa = aa;
        this.bb = bb;
    }
    private  String aa;
private   String bb;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item1 item1 = (Item1) o;
        return Objects.equals(aa, item1.aa) &&
                Objects.equals(bb, item1.bb);
    }
    @Override
    public int hashCode() {
        return Objects.hash(aa, bb);
    }
}
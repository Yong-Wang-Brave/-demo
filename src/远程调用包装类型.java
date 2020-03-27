import com.sun.org.apache.bcel.internal.generic.RETURN;
public class 远程调用包装类型 {
    public static void main(String[] args){
        yeuw yeuw = new yeuw();
        //int类型赋值null报错
        yeuw.setAa(new rpc().fangfa());
    }
    static class rpc{
        public Integer fangfa(){
            return null;
        }
    }
    static class yeuw{
        private  int aa;
        public int getAa() {
            return aa;
        }
        public void setAa(int aa) {
            this.aa = aa;
        }
    }
}
public class Deprecated {
    public static void main(String[] args){
        A a = new A();
        a.aa();
    }
    static class A{
        @java.lang.Deprecated
/**
 * 快捷键 ：再方法开头1） /** 2)按enter
 */
        public void aa(){ }
    }
}
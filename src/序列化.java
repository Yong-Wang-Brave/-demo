import java.io.*;
public class 序列化 {
public static void main(String[] args) throws IOException, ClassNotFoundException {
    //序列化
  /*  xuliehua xx=new xuliehua();
    ObjectOutputStream  oos =new ObjectOutputStream(new FileOutputStream("text"));
    oos.writeObject(xx);*/
//反序列化
  ObjectInputStream ii =new ObjectInputStream(new FileInputStream("text"));
  Object ss =ii.readObject();

}
};


    class xuliehua implements Serializable{
        private static   final long serialVersionUID=43L;
        private  String  name;
    }
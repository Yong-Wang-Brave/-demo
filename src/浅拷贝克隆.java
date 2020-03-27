/**
 * 【推荐】慎用 Object 的 clone 方法来拷贝对象。
 * 说明：对象的 clone 方法默认是浅拷贝，若想实现深拷贝需要重写 clone 方法实现属性对象
 * 的拷贝
 *
 * 解决的场景是改变实体对象不影响克隆的对象
 */
public class 浅拷贝克隆 {
    public static void main(String[] args) throws CloneNotSupportedException {
        baseInfo baseInfo = new baseInfo("xxx");

        Product product =new Product("ProductName","code",baseInfo);
        System.out.println("原始"+product);
        Product pd=product.clone();

        System.out.println("克隆"+pd);
        //浅拷贝导致的问题 克隆后的也被修改掉了
        //深拷贝，原考据改变不影响被拷贝的数据。
        baseInfo.setCompanyName("yyy");
        System.out.println("原始"+product);
        System.out.println("克隆"+pd);


/*浅拷贝
        原始356573597 Product{productName='ProductName', productCode='code', bs=xxx}
        克隆1735600054 Product{productName='ProductName', productCode='code', bs=xxx}
        原始356573597 Product{productName='ProductName', productCode='code', bs=yyy}
        克隆21685669 Product{productName='ProductName', productCode='code', bs=yyy}*/
/*   深拷贝     原始356573597 Product{productName='ProductName', productCode='code', bs=xxx}
        克隆1735600054 Product{productName='ProductName', productCode='code', bs=xxx}
        原始356573597 Product{productName='ProductName', productCode='code', bs=yyy}
        克隆1735600054 Product{productName='ProductName', productCode='code', bs=xxx}*/


    }
}
//深克隆实现第一步 实现接口，并重写方法
class baseInfo  implements Cloneable{

    @Override
    protected baseInfo clone() throws CloneNotSupportedException {
        return (baseInfo)super.clone();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public baseInfo(String companyName) {
        this.companyName = companyName;
    }

    private String companyName;


}

class Product implements Cloneable{
//String  bigint  8大基本类型都可以实现浅拷贝
    private String productName;
    private String productCode;
    private baseInfo bs;

    public baseInfo getBs() {
        return bs;
    }

    public void setBs(baseInfo bs) {
        this.bs = bs;
    }


    public Product(String productName, String productCode,baseInfo bs) {
        this.productName = productName;
        this.productCode = productCode;
        this.bs=bs;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return hashCode()+" Product{" +
                "productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", bs=" + bs.getCompanyName() +
                '}';
    }
//深克隆实现第二步  将pojo类型也实现重写
    @Override
    protected  Product clone() throws CloneNotSupportedException {
        Product product =(Product) super.clone();
     product.setBs(this.bs.clone());

        return product;
    }

}
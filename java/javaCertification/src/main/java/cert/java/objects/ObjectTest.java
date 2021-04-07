
package cert.java.objects;
import java.math.BigDecimal;

public class ObjectTest {
    public static void main (String... args) {
        Product prod =  new Product("");
        Object obj  = new Product("");
        Double testD = (Double) obj;

        prod.setName("testProd");
        System.out.println(prod.getName());

        BigDecimal bigDecimal = BigDecimal.valueOf(122121212121.01234567890123456789);
        BigDecimal bigDecimalA = new BigDecimal("122121212121.01234567890123456789");
        BigDecimal bigDecimalB = BigDecimal.valueOf(121.01234567890123456789);
        String doubleStr = Double.toString(122121212121.01234567890123456789);
        String doubleStrA = Double.toString(122.01234567890123456789);

        System.out.println(bigDecimal.toPlainString());
        System.out.println(bigDecimalA.toPlainString());
        System.out.println(bigDecimalB.toPlainString());
        System.out.println(doubleStr);
        System.out.println(doubleStrA);

    }
}

class Product {
    private final static String productFactory;
    private final String lastname;
    private String name;
    static {
        productFactory = "01";
    }
    {
        lastname = "" ;
    }

    Product(String name) {
        //super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name + this.lastname;
    }

    public void methodOverloaded(int x){
        return;
    }

    public String methodOverloaded(int x, double y){
        final int test = 0;
        return"";
    }

    public Double methodOverloaded(double y, int x){
        return 101.1;
    }

    public void methodOverloaded(double y, int x, int d){
        return ;
    }

    public void varArgsMeth(int y, String z, double... x) {

    }

    public final void finalTestMethod(final int x) {
        final var y = x;
        final int z = y;
        // error:  var final w = y;
        // error: int final w = y;
    }

    final public static void  finalTestMethod(){

    }
}

enum Condition {
    HOT("hot"),
    COLD("cold"),
    WARM("warm");

    Condition(String addInfo) {

    }

    class Food extends Product{

        Food(String name) {
            super(name);
        }
    }
}



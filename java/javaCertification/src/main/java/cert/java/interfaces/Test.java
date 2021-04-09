package cert.java.interfaces;

public class Test implements Product, Drink{
    public static void main (String ... args) {
        Product test = new Test();
        test.serve();
        Product.staticMethod();
        Drink.staticMethod();
        System.out.println(test.toString());
        System.out.println(Integer.toHexString(test.hashCode()));
        test.defaultMethod();
        test.defaultMethod1();
        test.defaultMethod2();

    }

    @Override
    public void serve() {
        System.out.println("Serving max of " + Drink.MAX_WIGHT);
    }


}

package cert.java.interfaces;

public interface Product {
    int MAX_WIGHT = 30;
    void serve();
    static void staticMethod(){
        System.out.println("I am Product's static method");
    }

    default void defaultMethod(){
        System.out.println("defaultMethod");
    }

    default void defaultMethod1(){
        System.out.println("defaultMethod");
    }

    default void defaultMethod2(){
        System.out.println("defaultMethod");
    }
}

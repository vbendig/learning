package cert.java.interfaces;

public interface Drink {
    int MAX_WIGHT = 20;
    void serve();

    static void staticMethod(){
        System.out.println("I am Drink's static method");
    }

    @Override
    String toString();
}

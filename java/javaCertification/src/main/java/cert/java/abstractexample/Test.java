package cert.java.abstractexample;

abstract class AbstractExample {
    //static int shadowedVariable = 0;
    int shadowedVariable = 0;

}
public class Test extends AbstractExample{
    static int shadowedVariable = 1;

    public static void main(String[] args) {

    }

}

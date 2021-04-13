package cert.java.collections;

import java.util.Arrays;

public class ListTest {
    public static void main(String[] args) {
        var lst = Arrays.asList(1, 2, 3, 4);
        lst.replaceAll(x -> x + 100);
        System.out.println("completed");
    }
}

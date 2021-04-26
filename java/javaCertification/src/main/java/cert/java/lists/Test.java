package cert.java.lists;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("C");
        list.add("Z");
        list.add("A");
        list.add("R");
        list.subList(1, 2).clear();
        System.out.println(String.join("", list));
    }
}

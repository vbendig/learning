package cert.java.lambda;

import cert.java.interfaces.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<MyProd> products = new ArrayList<>();
        products.add(new MyProd("Coke", 100));
        products.sort((MyProd p1, MyProd p2) -> p1.getName().compareTo(p2.getName()));

        products.sort(Comparator.comparing(MyProd::getName));

        List<String> strList = new ArrayList<>();
        strList.add("hola");
        strList.add("mundo");
        strList.sort((s1,s2) -> s1.compareTo(s2));
        strList.sort(String::compareTo);
    }
}

class MyProd implements Product{
    String name;
    Integer price;

    MyProd(String name, Integer price){
        this.name = name;
        this.price = price;
    }
    @Override
    public void serve() {

    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}

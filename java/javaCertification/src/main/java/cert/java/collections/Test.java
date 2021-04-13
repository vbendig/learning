package cert.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        String[] strArray = {"hola", "mundo"};
        List<String> strList= new ArrayList<>();
        Collection col = (Collection)strList;

        col = Arrays.asList(strArray);
        //UnsupportedOperationException   col.add("test");
        strList = Arrays.asList("hola", "mundo"); //Fixed size List!
        //UnsupportedOperationException  strList.add("test");

        System.out.println(strList.getClass());

        Set<String> strHashSet = new HashSet<>();
        SortedSet<String> sortedSet = new TreeSet();

        arrayListLoop();
        String[] arr = {"Tea", "Cake"};
        List<String> texts = Arrays.asList(arr);
        System.out.println(texts.getClass());
        texts.set(0, "Coffee");
        System.out.println(texts.get(0));

    }

    public static void arrayListLoop(){
        List<Product> products = new ArrayList<>();
        products.add(new Tea(5));
        products.add(new Coffee(3));
        products.add(new Cake(4));
        products.size();

//        ConcurrentModificationException:
//        for (Product prod: products) {
//            products.remove(prod);
//        }

        Iterator<Product> iterator = products.iterator();
        while( iterator.hasNext() ){
            Product product = iterator.next();
            iterator.remove();
        }

        for (Product prod: products) {
            System.out.println(prod.getName() + " " + prod.getQuantity());
        }
    }
}

class Tea extends Product{
    Tea(int quantity){
        this.name = "Tea";
        this.quantity = quantity;
    }
}

class Coffee extends Product{
    Coffee(int quantity){
        this.name = "Coffee";
        this.quantity = quantity;
    }
}

class Cake extends Product{
    Cake(int quantity){
        this.name = "Cake";
        this.quantity = quantity;
    }
}

abstract class Product{
    String name;
    int quantity;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}


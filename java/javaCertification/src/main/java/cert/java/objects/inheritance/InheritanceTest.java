package cert.java.objects.inheritance;


public class InheritanceTest{
    public  static void main (String ... args){
        Food food = new Food();
        Product product = new Product("name");
        Item item = new Item();
    }
}

class Item{
    public Item(){
        System.out.println("Item 1 constructor Called");
    }
}

class Product extends Item{
    public Product(String name){
        System.out.println("Product constructor Called");
    }
}

class Food extends Product{
    public Food(){
        super("Name");
        System.out.println("Food constructor Called");
    }

    public Food(String name){
        super("Name");
        System.out.println("Food constructor Called");
    }
}
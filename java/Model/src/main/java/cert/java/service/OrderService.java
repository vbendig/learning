package cert.java.service;

import cert.java.model.Order;
import cert.java.model.Product;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderService {
    static List<String> productNames = new ArrayList<String>(List.of("Rice", "Bread", "Coffee", "Tea", "Toilet Paper",
            "Grapes", "Apples", "Oranges", "Detergent", "Tooth Paste",
            "Beans", "Cherry", "Chocolate", "Potatoes", "Sugar",
            "Milk", "Eggs", "Butter", "Tomatoes", "Lemon"));

    public static List<String> getProductNames() {
        return productNames;
    }

    private static double getRndm(int min, int max){
        return Math.random() * max + min;
    }

    public static List<Product> createProductList(){
        List<Product> products = new ArrayList<>();
        int daysBestBy = (int) getRndm(0, 365);
        int quantityOfProds = (int) getRndm(1, 20);
        for(int i = 0 ; i < quantityOfProds; i++){
            double price =  ((int) (getRndm(1, 1000) * 100)) / 100.0;
            int prodNameRndm = (int) getRndm(0, productNames.size());
            products.add(new Product(productNames.get(prodNameRndm), price, LocalDateTime.now().plus(daysBestBy, ChronoUnit.DAYS)));
        }
        return products;
    }

    public static Order createRndmOrder(){
        List<Product> productList = createProductList();
        int itemQuantityRndm = (int) getRndm(1, 10);
        int productQuantityRndm = (int) getRndm(1, 10);
        Order newOrder = new Order();
        //System.out.println("new Order Hash: " + newOrder.generateHash());
        for(int i = 0 ; i < itemQuantityRndm; i++){
            int prodRndm = (int) getRndm(0, productList.size());
            newOrder.addItem(productList.get(prodRndm),productQuantityRndm);
        }
        //System.out.println("Order with products Hash: " + newOrder.generateHash());
        newOrder.generateHash();
        return newOrder;
    }

    public static List<Order> createRndmOrders(){
        int orderQuantity = (int) getRndm(20, 40);
        return createRndmOrders(orderQuantity);
    }

    public static List<Order> createRndmOrders(int orderQuantity){
        int counter = 0;
        return IntStream.range(0, orderQuantity)
                .mapToObj(n -> createRndmOrder())
                .collect(Collectors.toList());
    }
}

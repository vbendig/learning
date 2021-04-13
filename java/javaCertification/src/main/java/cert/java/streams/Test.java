package cert.java.streams;

import cert.java.model.Order;
import cert.java.model.Product;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Product("Coffee", 100.0, LocalDateTime.now().plus(365, ChronoUnit.DAYS)), 2 );
        order.addItem(new Product("Rice", 80.0, LocalDateTime.now().plus(150, ChronoUnit.DAYS)), 2 );
        order.addItem(new Product("Tea", 90.0, LocalDateTime.now().plus(365, ChronoUnit.DAYS)), 2 );
        order.addItem(new Product("Bread", 110.0, LocalDateTime.now().plus(50, ChronoUnit.DAYS)), 2 );

        order.addItem(new Product("Rice", 80.0, LocalDateTime.now().plus(150, ChronoUnit.DAYS)), 2 );

        System.out.println(order.toString());

        order
                .getItems()
                .stream()
                .map(item -> item.getProduct())
                .filter(product -> product.getPrice() > 90)
                .forEach(product -> product.setBestBy(product.getBestBy().plusDays(100)));

        System.out.println(order.toString());

    }
}

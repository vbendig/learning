package cert.java.serialization;

import cert.java.model.Order;
import cert.java.service.OrderService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Test {
    static List<Order> orderList = null;
    public static void main(String[] args) {
        orderList = OrderService.createRndmOrders(1);
        System.out.println(orderList);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("swap"))) {
            out.writeObject(orderList);
            orderList = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n=======================================\n");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("swap"))) {
            orderList = (List<Order>) in.readObject();
            orderList.forEach(Order::generateHash);
            System.out.println(orderList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

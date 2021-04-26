package cert.java.modules;

import cert.java.model.Order;
import cert.java.model.Product;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args) {
        tryToAccessOrderItemByReflection();

    }


    public static void tryToAccessOrderItemByReflection() {
        try {
            Order order = new Order();
            //Class c = Class.forName("cert.java.cert.java.cert.java.model.Order");
            Field[] fields = order.getClass().getFields();
            Method[] methods = order.getClass().getMethods();
            Method first = methods[0];

            Class[] classes = order.getClass().getClasses();
            Class[] declaredClasses = order.getClass().getDeclaredClasses();
            System.out.println(first.toString());

            Method toStringMethod = order.getClass().getMethod("toString");
            //Object obj = c.newInstance();
            System.out.println(toStringMethod.invoke(order,null));

            Product product = new Product("new Prod", 1.0, LocalDateTime.now());
            Method addItemMethod = order.getClass().getMethod("addItem", Product.class, Integer.class);
            addItemMethod.invoke(order, product,2);

            System.out.println(toStringMethod.invoke(order,null));

            Class<?> itemClass = Class.forName("cert.java.model.Order$Item");
//            Class itemClass = declaredClasses[0];
            Constructor itemConstructor = itemClass.getConstructor(Order.class, Product.class, Double.class, Integer.class);
            itemConstructor.setAccessible(true);
            Object itemInstance = itemConstructor.newInstance(order, product, 1.1, 34);

            Method[] itemClassMethods = itemInstance.getClass().getMethods();

            for (Method method: itemClassMethods  ) {
                System.out.println(method.toString());
            }
            Method itemToString = itemInstance.getClass().getMethod("toString");
            System.out.println(itemToString.invoke(itemInstance, null));

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException | ClassNotFoundException cnfe) {
            System.out.println("error " + cnfe.toString());
            cnfe.printStackTrace();
        }
    }
}

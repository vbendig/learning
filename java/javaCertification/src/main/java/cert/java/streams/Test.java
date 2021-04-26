package cert.java.streams;

import cert.java.model.Order;
import cert.java.model.Product;
import cert.java.service.OrderService;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
//        manuallyCreateOrder();
//        lamdasWithOrders();
//        doubleUnaryOperatorExample();
//        integerExamples();
//        testIdentity();
        groupingStreams();

        List listOfObjects = new ArrayList();
        listOfObjects.add("Hola");
        listOfObjects.add(8);
        listOfObjects.add('c');

        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product("sfds", 1.0, LocalDateTime.now()));
        List<?> listOfUnknownType = listOfProducts;
        listOfUnknownType.add(null);
        listOfProducts.add(null);


    }

    private static void groupingStreams(){
        Test test = new Test();
        test.orders = OrderService.createRndmOrders();
        //System.out.println(test.orders);
        Map<Boolean, List<Order>> ordersByProducts = test.orders.stream().collect(Collectors.partitioningBy(order -> order.getProductsStream().count() > 5));
        Map<Long, List<Order>> orderByProdCount = test.orders.stream().collect(Collectors.groupingBy(order -> order.getProductsStream().count()));

        Supplier<Order> supplier =  () -> test.orders.stream().iterator().next();

        // Vamos a hacer una agrupación de ordenes por producto, es decir, una lista de productos con las ordenes que contengan dicho producto
        Map<String, List<Order>> orderMapManual = new HashMap<>();
        for (String productName : OrderService.getProductNames()) {
            List<Order> orderList = test.orders
                    .stream()
                    .filter(order -> order.getProductsStream().filter(product -> product.getName() == productName).count() != 0)
                    .collect(Collectors.toList());
            orderMapManual.put(productName, orderList);
        }

        Map<Object, Object> orderMapAuto = new HashMap<>();
        orderMapAuto = OrderService.getProductNames().stream()
                .collect(Collectors.toMap(productName -> productName , productName -> test.orders.stream()
                        .filter(order -> order.getProductsStream().filter(product -> product.getName() == productName).count() != 0).collect(Collectors.toList())));

        //Map<String, List<Order>> orderMap = test.orders.stream().collect(supplier, ()->,);

        System.out.println(test.orders.stream().collect(Collectors.summarizingDouble(order -> order.getTotal())));


        Locale locale = new Locale("en", "CR");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        System.out.println(fmt.format(123));

        String s1 = test.orders.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingDouble(
                                order -> order.getTotal()
                        ),
                                n -> fmt.format(n)));

        System.out.println(s1);

        String s2 = OrderService.getProductNames().stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingDouble(
                                p -> (double) p.length()
                        ),
                        n -> fmt.format(n)
                ));

        System.out.println(s2);
    }

    private static void integerExamples() {
        System.out.println(Stream.of("one", "Two", "three", "four", "five", "six")
                .mapToInt(s -> s.length())
                .peek(System.out::println)
                .filter(i -> i > 3)
                .sum());

        System.out.println(IntStream
                .generate(() -> (int)(Math.random() * 10))
                .filter(n -> n == 3)
                .peek(System.out::println)
                .limit(5)
                .sum());
    }

    private static void lamdasWithOrders() {
        Test test = new Test();
        Order order1 = OrderService.createRndmOrder();
        System.out.println(order1);
        order1.getItemStream().forEach(i -> i.setDiscount(0.1));
        System.out.println(order1);
        order1.getItemStream().peek(i -> i.applyDiscount(0.5)); //.collect(Collectors.toList()); // peeks only works if it has a terminal operator like collect!
        System.out.println(order1);
        System.out.println(order1.getProductsStream().collect(Collectors.toList()));
        order1.getProductsStream().forEach(product -> product.setName(product.getName() + " !! "));
        System.out.println(order1.getProductsStream().mapToDouble(p -> p.getPrice()).sum());
        System.out.println(order1.getProductsStream().mapToDouble(p -> p.getPrice()).average());
        OptionalDouble avg = order1.getProductsStream().mapToDouble(p -> p.getPrice()).average();
        System.out.println(order1.getProductsStream().filter(product -> product.getPrice() >= avg.getAsDouble()).collect(Collectors.toList()));
    }

    private static void manuallyCreateOrder() {
        Order order = new Order();
        order.addItem(new Product("Coffee", 100.0, LocalDateTime.now().plus(365, ChronoUnit.DAYS)), 2 );
        order.addItem(new Product("Rice", 80.0, LocalDateTime.now().plus(150, ChronoUnit.DAYS)), 2 );
        order.addItem(new Product("Tea", 90.0, LocalDateTime.now().plus(365, ChronoUnit.DAYS)), 2 );
        order.addItem(new Product("Bread", 110.0, LocalDateTime.now().plus(50, ChronoUnit.DAYS)), 2 );
        order.addItem(new Product("Rice", 80.0, LocalDateTime.now().plus(150, ChronoUnit.DAYS)), 2 );

        //System.out.println(order.toString());

        order.getItems()
                .stream()
                .map(item -> item.getProduct())
                .filter(product -> product.getPrice() > 90)
                .forEach(product -> product.setBestBy(product.getBestBy().plusDays(100)));

        //System.out.println(order.toString());
    }

    private static void doubleUnaryOperatorExample() {
        System.out.println("Double Unary Operator Example: ");
        StringBuilder result = new StringBuilder();
        DoubleConsumer print = n -> result.append( n ) ;
        DoubleUnaryOperator firstOperator = n -> {
            System.out.println(" first operator");
            return n * 0.75;
        };

        DoubleUnaryOperator secondOperator = n -> {
            System.out.println(" second operator " );
            return ((int) (n * 100)) / 100.0;
        };
        DoubleStream
                .generate(() -> (Math.random() * 10))
                .takeWhile(n -> n > 0  )
                .limit(10)
                .map(secondOperator.compose(firstOperator))
                .peek(print.andThen(n -> result.append("   +   ")))
                .peek(((DoubleConsumer) (n -> result.append( n ))).andThen(n -> result.append("   -   ")))
                .mapToInt(n -> (int) n)
                .reduce((i1, i2) -> i1 + i2 )
                //.reduce(0, (i1, i2) -> i1 + i2 ) gives default value
                .ifPresent(System.out::println);
        result.deleteCharAt(result.lastIndexOf("-"));
        System.out.println(result.toString());

        System.out.println(DoubleStream
                .generate(() -> (Math.random() * 10))
                .takeWhile(n -> n > 0  )
                .limit(10)
                .map(secondOperator.compose(firstOperator))
                .mapToObj(n -> ((Double)n).toString())
                .collect(Collectors.mapping(n -> n.toString(), Collectors.joining("  -  "))));


    }

    public static void testIdentity(){
        List<String> names = Arrays.asList(
                "Peter",
                "Martin",
                "John",
                "Peter",
                "Vijay",
                "Martin",
                "Peter",
                "Arthur"
        );

        Set<String> namesSet = new HashSet(names);
        // names.size() != namesSet.size(); // => true if duplicates

        names.stream()
                .map(getFunction(names, names.size() != namesSet.size()))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

    }

    static Function<String, String> getFunction(List<String> names, boolean hasDuplicates){
        //Collections.frequency(names, name) => to get duplicate count

        return hasDuplicates ?
                name -> name+" ("+ Collections.frequency(names, name)+")"
                : Function.identity();
    }
}

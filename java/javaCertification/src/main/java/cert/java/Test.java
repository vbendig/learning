package cert.java;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class Test {
    FuncInterface lambda = x -> x*2;
    public static Function<String,String> swap = s -> {
        if(s.equals("Australia"))
            return "New Zealand";
        else
            return s;
    };
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> divide = (x, y) -> x/y;
        DoubleFunction<Double> area = r -> Math.PI*r*r;
        IntPredicate test = x -> x == 10;
        BiPredicate<Integer, Integer> test1 = (x, y) -> x == y;
        Function




        System.out.println(0%3);
        // var x, y = "Test";
        var w = "Test";

        String xz, ys = "test";

        //Consumer<String> con3 = final x -> System.out.println(x);
        Consumer<String> con3 = (final String x) -> System.out.println(x);

        //Consumer<String> con2 = final var x -> System.out.println(x);
        Consumer<String> con2 = (final var x) -> System.out.println(x);

        //BiConsumer<String, String> biCon2 = (final var x, y) -> System.out.println(x+y);
        BiConsumer<String, String> biCon2 = (final var x, var y) -> System.out.println(x+y);

        BiConsumer<String, String> biCon3 = (final var x, final var y) -> System.out.println(x+y);




    }

    public Optional pickName(){
        List<String> names = List.of("Barclay", "Barry", "Bert", "Bort");

        return names.stream()
                .filter(n -> n.contains("Bart"))
                .findAny()
                ;

    }


    public int multip (int x, int y){
        return x * y;
    }
}


class Circle {
    public static double findCircumference(int radius) {
        return 2 * Math.PI * radius;
    }
}

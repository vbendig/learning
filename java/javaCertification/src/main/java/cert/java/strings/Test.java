package cert.java.strings;

public class Test {
    public static void main(String[] args) {
        String text = null;
        String text1 = null;
        //System.out.println(text.repeat(3)); // Nullpointer exception
        //System.out.println(null + null + null);

        System.out.println(null + "null" + null);

        //System.out.println(text *= 3);

        System.out.println(text);
        System.out.println(text += "null".repeat(2));

        System.out.println(text1 + text1 + text1);

        text += null;
        //System.out.println((text.concat(null))); Null pointer

        boolean test = false;
        System.out.println(true);
        System.out.println(test = true);

        int x = 1;
        System.out.println(x = 32);
        //System.out.println(sum(x));
    }

    private static void sum(int x) {
        x++;
    }
}

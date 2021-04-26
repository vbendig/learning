package cert.java.main;


import java.util.Arrays;

class Message {
    static String msg; //Line 2
    public static void main(String[] args) {
        String msg2; //Line 4 shadows line2 ( changed to msg2 to be able to compiles)
        if(args.length > 0) {
            msg = args[0]; //Line 6
        }
        System.out.println(msg); //Line 8

        //test();

//        //System.out.println("Welcome " + args[1] + "!");
//        char [] arr1 = {'A'};
//        char [] arr2 = {'A'};
//        int i = '3';
//        "".replace("d","d");
//        "".replace('a','e');
//        byte b = 10; //Line n4
//        new Message().speed(b);
//        byte var = 12;
//        var test = 10;
    }

    void speed(Byte val) { //Line n1
        System.out.println("DARK"); //Line n2
    } //Line n3

    void speed(byte... vals) {
        System.out.println("LIGHT");
    }
}

public class Guest {
    public static void main(String[] args) {
        Message.main(args);
        StringBuilder sb = new StringBuilder("Dream BIG");
        String s1 = sb.toString();
        String s2 = sb.toString();

        System.out.println(s1 == s2);

        int[] a1 = { 10, 15, 30 };
        int[] a2 = { 10, 20, 30 };
        System.out.println(Arrays.mismatch(a1, a2) + Arrays.compare(a1, a2));
    }
}


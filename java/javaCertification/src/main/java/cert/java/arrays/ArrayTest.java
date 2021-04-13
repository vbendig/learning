package cert.java.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayTest {
    public static String[] myStringArray = { "Jane", "Elizabeth","Marys", "Jo"};
    public static void main (String ... args) {
        int [] myArray = { 1 , 2, 3 };
        int myArray2 [] = new int[] {1,2,3};
        int myArray3 [] = new int[3];
        myArray3[0] = 1;
        myArray3[1] = 2;
        myArray3[2] = 3;

        int [] myArray4;
        myArray4 = new int[] {1,2,3};
        int y = myArray3.length;

        int [] [] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0, j = 2;
              !(i > 2 || j <= -1);
             System.out.println("Calling increment"), ++i , --j){
            System.out.println("i = " + i + " -- j = " + j);
            System.out.println(matrix[i][j]);
        }

        Arrays.sort(myStringArray, new Compare());
        for (String name: myStringArray) {
            System.out.println(name);
        }
    }
}

class Compare implements Comparator<String>{
    public int compare(String s1, String s2){
        for(String name: ArrayTest.myStringArray){
            System.out.print(name + ", ");
        }
        System.out.println();
        System.out.println(s1 + " length: " + s1.length() +
                "    " + s2 + " length: " + s2.length() +
                "    s2.length() - s1.length() = "  + (s2.length() - s1.length())
                );

        System.out.println();
        System.out.println();
        return s2.length() - s1.length();
    }
}



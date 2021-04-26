package cert.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int i  = 0;
        System.out.println(++i);
        System.out.println(i++);
        System.out.println(i);

        List<Character> characterList = new ArrayList<>();
        characterList.add(0,'E');
        for(char ch : characterList) {
            System.out.print(ch);
        }
        System.out.println();
        characterList.add('X');
        for(char ch : characterList) {
            System.out.print(ch);
        }
        System.out.println();
        characterList.add(1, 'P');
        characterList.add(3, 'O');

        if(characterList.contains('O')) {
            characterList.remove(Character.valueOf('O'));
        }

        for(char ch : characterList) {
            System.out.print(ch);
        }

    }
}

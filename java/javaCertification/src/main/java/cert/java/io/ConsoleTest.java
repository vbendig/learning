package cert.java.io;

import java.io.Console;
import java.io.PrintWriter;

public class ConsoleTest {
    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.out.println("Console is not supported");
            return;
        }
        PrintWriter out = c.writer();
        String txt = null;
        out.println("To quit type: exit ");
        do{
            if(txt != null)
                out.println("Echo: " + txt);
            System.out.print("Type value and press enter: ");
        } while (!(txt = c.readLine()).equals("exit")) ;

        System.out.println("Bye");

    }
}

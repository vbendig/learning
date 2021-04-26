package cert.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class Test {
    public static void main(String[] args) {
        try{
            File fileIn = new File("ioInExample.txt");
            File fileOut = new File("ioOutExample.txt");
            if(!fileIn.exists())
                fileIn.createNewFile();
            if(!fileOut.exists())
                fileOut.createNewFile();
            System.out.println(fileIn.getPath());
            System.out.println(fileIn.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(InputStream in = new FileInputStream("ioInExample.txt");
            OutputStream out = new FileOutputStream("ioOutExample.txt")){
            byte[] buffer = new byte[1024];
            var length = 0;
            while((length = in.read(buffer)) != -1) {
                System.out.println("Buffer length: " + buffer.length);
                System.out.println("Reading lenght: " + length);
                System.out.println(new String(buffer));
                out.write(buffer, 0, length);
                out.flush();
            }
            System.out.println("Finito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===================================================");
        System.out.println("FileReader and File Writer");
        System.out.println("===================================================");



        // Charset utf8 = Charset.forName("UTF-16"); //Funny Characters
        Charset utf8 = Charset.forName("UTF-8");
        try(Reader in = new FileReader("ioInExample.txt", utf8);
            Writer out = new FileWriter("ioOutExample.txt", utf8)){
            char[] buffer = new char[1024];
            var length = 0;
            while((length = in.read(buffer)) != -1) {
                System.out.println("Buffer length: " + buffer.length);
                System.out.println("Reading lenght: " + length);
                System.out.println(new String(buffer));
                out.write(buffer, 0, length);
                out.flush();
            }
            System.out.println("Finito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===================================================");
        System.out.println("FileReader and File Writer");
        System.out.println("===================================================");

        // Charset utf8 = Charset.forName("UTF-16"); //Funny Characters
        utf8 = Charset.forName("UTF-8");
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("ioInExample.txt"), utf8));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("ioOutExample.txt"), utf8))){
            String line = null;
            var length = 0;
            while((line = in.readLine()) != null) {
                System.out.println("Reading line lenght: " + line.length());
                System.out.println(line);
                out.println(line);
                out.flush();
            }
            System.out.println("Finito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

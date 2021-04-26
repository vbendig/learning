package cert.java.nio;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;

public class Test {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        System.out.println("File system stores : ==== ");
        fs.getFileStores().forEach(s-> System.out.println(s.type() + " " + s.name()));

        System.out.println("root dirs : ==== ");
        fs.getRootDirectories().forEach(p-> System.out.println(p));


        System.out.println("separator : ==== ");
        String separator = fs.getSeparator();
        System.out.println(separator);

        System.out.println("Path : ==== ");
        Path curr = Path.of(".").toAbsolutePath();
        System.out.println(curr.toString());

        try {
            Files.list(curr).forEach(p -> System.out.println(p.normalize()));
            System.out.println("---------");
            Files.walk(curr)
                    .map(path -> path.normalize().toString())
                    .filter(s -> s.endsWith("txt"))
                    .forEach(p -> System.out.println(p));

            //Files.find()

            Path txtFile = Path.of("/Users/victor.bendig/dev/learning/java/javaCertification/ioOutExample.txt");
            PosixFileAttributes fa = Files.readAttributes(txtFile, PosixFileAttributes.class);
            System.out.println(fa.size());
            System.out.println(fa.creationTime());
            FileTime ft = fa.lastModifiedTime();
            System.out.println(ft);
            fa.permissions().stream().forEach(p -> System.out.println(p.name()));
            System.out.println("is regular file : " + fa.isRegularFile());

            Files.writeString(txtFile, "Sample text", StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package cert.java.jdbc;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    String url = "jdbc:derby:memory:myDB;create=true";
    final String sql = "Select * from cars";

    public Test(){

    }

    public static void main(String[] args) {
        Test thisTest = new Test();
        thisTest.connect();
    }

    public void connect(){
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();)
        {

            String fileContent = getFileFromResources("cars.sql");
            System.out.println(fileContent);
            fileContent = fileContent.replaceAll("\n", "");
            String[] statementArray = fileContent.split( ";", 0);
            for (String singleStatement: statementArray) {
                System.out.println(singleStatement);
                statement.executeUpdate(singleStatement);
            }

            boolean result = statement.execute(sql);
            if(result){
                ResultSet resultSet = statement.getResultSet();
                ResultSetMetaData meta = resultSet.getMetaData();
                int columnCount = meta.getColumnCount();
                List<String> columNames = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    columNames.add(meta.getColumnName(i));
                }
                while (resultSet.next()){
                    for(String name : columNames){
                        System.out.print(resultSet.getString(name) + "  ");
                    }
                    System.out.println();
                };
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
    }

    //USE THIS FUNCTION TO READ CONTENT OF A FILE, IT MUST EXIST IN "RESOURCES" FOLDER
    public static String getFileFromResources(String fileName) throws Exception {
        ClassLoader classLoader = Test.class.getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(fileName);
        String text = null;
        try (Scanner scanner = new Scanner(stream, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        }
        return text;
    }

}

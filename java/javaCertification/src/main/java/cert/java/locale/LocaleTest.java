package cert.java.locale;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {

    public static void main(String [] args){
        Locale locale = new Locale("en", "CR");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
        String pattern = resourceBundle.getString("hello");
        String hello = MessageFormat.format(pattern, "World");
        System.out.println(hello);
        testProduct();
    }

    public static void testProduct(){
        Locale locale = new Locale("es", "CR");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
        String pattern = resourceBundle.getString("product");


        String name = "Cookie";
        BigDecimal price = BigDecimal.valueOf(12.99);
        LocalDate bestBy = LocalDate.of(2021, Month.APRIL, 5);
        int quantity = 4;

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", locale);

        String fPrice = currencyFormat.format(price);
        String fQuantity = numberFormat.format(quantity);
        String fBestBy = dateTimeFormatter.format(bestBy);

        String product = MessageFormat.format(pattern, name, fPrice, fQuantity, fBestBy);
        System.out.println(product);
    }
}

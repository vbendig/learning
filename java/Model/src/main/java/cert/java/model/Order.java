package cert.java.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID uuid = UUID.randomUUID();
    private Set<ItemInterface> items = new HashSet<>();
    private String creditCardNumber = UUID.randomUUID().toString();
    private String key;
    public transient String hash;

    public Order(){
        System.out.println("Constructor Was Called! ");
    }

    public String generateHash(){
        this.hash = null;
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream)){
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            out.writeObject(this.getProductList());
            this.hash = new BigInteger(1, md.digest(byteArrayOutputStream.toByteArray())).toString(16);
            //System.out.println("Generated Hash: " + this.hash);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return this.hash;
    }

    public String getCreditCardNumber(){
        return "";
    }

    public Set<ItemInterface> getItems() {
        return items;
    }

    public Order(UUID uuid, Set<ItemInterface> items) {
        this.uuid = uuid;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{ \n ID = " + uuid + "\n" +
                "total = " + this.getTotal() + "\n" +
                "items = \n" + items +
                "hash = " + this.hash + "\n" +
                "Credit Card Number = " + this.creditCardNumber + "\n" +
                "}\n";
    }

    @Override
    public int hashCode(){
        return Objects.hash(getProductList());
    }

    public void addItem(Product product, Integer quantity){
        addItem(product, quantity, 0.0);
    }

    public void addItem(Product product, Integer quantity, Double discount){
        Item item = new Item(product, 0.0, quantity);
        if( !items.add(item) ){
            items.stream()
                    .filter(item::equalsIgnoreQuantity)
                    .forEach(item1 -> item1.increaseBy(item.getQuantity()));
        }

    }

    public Double getTotal(){
        return this.getItemStream().mapToDouble(i -> i.getProduct().getPrice() - i.getProduct().getPrice() * i.getDiscount()).sum();
    }

    public Stream<ItemInterface> getItemStream(){
        return items.stream();
    }

    public Stream<Product> getProductsStream(){
        //System.out.println(items.stream().map(i -> i.getProduct()).collect(Collectors.toList()));
        return items.stream().map(i -> i.getProduct());
    }

    public List<Product> getProductList(){
        //System.out.println(items.stream().map(i -> i.getProduct()).collect(Collectors.toList()));
        return items.stream().map(i -> i.getProduct()).sorted((p1, p2)-> p1.getName().compareTo(p1.getName())).collect(Collectors.toList());
    }

    private class Item implements ItemInterface, Serializable{
        private static final long serialVersionUID = 1L;
        Product product;
        Double discount = 0.0;
        Integer quantity = 0;

        public Item(Product product, Double discount, Integer quantity) {
            this.product = product;
            this.discount = discount;
            this.quantity = quantity;
        }

        @Override
        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        @Override
        public Double getDiscount() {
            return discount;
        }

        @Override
        public void setDiscount(Double discount) {
            this.discount = discount;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getTotalPrice(){
            return product.getPrice() - product.getPrice() * discount;
        }

        public void increaseBy(Integer itemQuantity){
            this.quantity += itemQuantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return product.equals(item.product) && discount.equals(item.discount) && quantity.equals(quantity);
        }

        public boolean equalsIgnoreQuantity(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return product.equals(item.product) && discount.equals(item.discount);
        }

        public void applyDiscount(Double discount){
            this.discount = discount;
//            System.out.println("New discount = " + discount);
//            System.out.println(" This product is " + this.product.getName()
//                    + " current price is : " + this.product.getPrice() + " and new price is : "
//                    + this.product.getPrice() * discount);
        }

        @Override
        public int hashCode() {
            int hash = Objects.hash(product.getName(), product.getPrice(), product.getBestBy(), discount, quantity);
            //System.out.println("Item HashCode called  for prod " + product.getName() + " and quantity : " + quantity + "  with hash  " + hash);
            return hash;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "product=" + product +
                    ", discount=" + discount +
                    ", quantity=" + quantity +
                    "}\n";
        }
    }
}

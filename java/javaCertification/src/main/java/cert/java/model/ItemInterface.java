package cert.java.model;

public interface ItemInterface {
    Product getProduct();
    Double getDiscount();
    void increaseBy(Integer quantity);
    void setDiscount(Double discount);
    void applyDiscount(Double discount);
}

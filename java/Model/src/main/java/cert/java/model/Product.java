package cert.java.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Product{
    public Product(String name, Double price, LocalDateTime bestBy) {
        this.name = name;
        this.price = price;
        this.bestBy = bestBy;
    }

    private String name;
    private Double price;
    private LocalDateTime bestBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name)
                && price.equals(product.price)
                && bestBy.toLocalDate().equals(product.bestBy.toLocalDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", bestBy=" + bestBy.toString() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getBestBy() {
        return bestBy;
    }

    public void setBestBy(LocalDateTime bestBy) {
        this.bestBy = bestBy;
    }
}

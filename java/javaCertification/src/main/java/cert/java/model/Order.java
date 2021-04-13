package cert.java.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Set<ItemInterface> items = new HashSet<>();

    public void addItem(Product product, Integer quantity){
        Item item = new Item(product, 0.0, quantity);
        if( !items.add(item) ){
            items.stream()
                    .filter(item::equals)
                    .forEach(item1 -> item1.increaseBy(item.getQuantity()));
        }
    }

    @Override
    public String toString() {
        return "Order{\n" +
                "items=\n" + items +
                "}\n";
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private class Item implements ItemInterface{
        Product product;
        Double discount = 0.0;
        Integer quantity = 0;

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
            return product.equals(item.product) && discount.equals(item.discount);
        }

        @Override
        public int hashCode() {
            return Objects.hash(product, discount);
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

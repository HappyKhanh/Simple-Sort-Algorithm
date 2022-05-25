package AS2;

import java.util.Objects;

public class Product {
    private String bcode;
    private String title;
    private int quantity;
    private double price;

    public Product(String bcode, String title, int quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBcode() {
        return bcode;
    }

    public String getTitle() {
        return title;
    }
    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  bcode +" | " + title +" | " + quantity +" | " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity && Double.compare(product.price, price) == 0 && Objects.equals(bcode, product.bcode) && Objects.equals(title, product.title);
    }

}

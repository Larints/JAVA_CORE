package store;

import java.util.Objects;

public class Product {

    private String description;


    public Product(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }


}

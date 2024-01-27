package store;

import java.time.LocalDate;

public class Order {

    private LocalDate date;

    private Customer buyer;

    private Product product;

    int productCount;


    public Order(LocalDate date, Customer buyer, Product product, int productCount) {
        this.date = date;
        this.buyer = buyer;
        this.product = product;
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return String.format("Order date - %s, customer - %s, product - %s, product count - %d",
                date.toString(), buyer.getName(), product.getDescription(), productCount);
    }
}

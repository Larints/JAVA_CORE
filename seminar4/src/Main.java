import store.Customer;
import store.Gender;
import store.MarketPlace;
import store.Product;

public class Main {
    public static void main(String[] args) {
        MarketPlace.store.addCustomer(new Customer("John", "New York", "43325", Gender.MALE));
        MarketPlace.store.addProduct(new Product("Orange"));
        Customer customer = new Customer("John", "New York", "43325", Gender.MALE);
        Product product = new Product("Orange");
        MarketPlace.store.buyProduct(customer, product, 3);
    }
}

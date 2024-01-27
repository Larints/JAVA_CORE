package store;

import exceptions.CustomerNotFoundException;
import exceptions.NegativeProductCountException;
import exceptions.ProductNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    List<Customer> customers;

    List<Order> orders;
    List<Product> products;

    public Store() {
        customers = new ArrayList<>();
        orders = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void buyProduct(Customer customer, Product product, int count) {
        try {
            if (!customers.contains(customer)) throw new CustomerNotFoundException("Customer not found");
            if (!products.contains(product)) throw new ProductNotFoundException("Product not found");
            if (count < 0) throw new NegativeProductCountException("Count of products must be positive");
            Order order = new Order(LocalDate.now(), customer, product, count);
            orders.add(order);
            try (FileWriter fw = new FileWriter("C:\\Users\\lagos\\OneDrive\\Рабочий стол\\" +
                    "GB\\JAVA_CORE\\seminar4\\src\\store\\Orders")) {
                fw.write(order.toString());
                fw.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (CustomerNotFoundException | ProductNotFoundException | NegativeProductCountException e) {
            System.out.println(e.getMessage());
        }

    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}

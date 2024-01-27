package store;

import java.util.Objects;

public class Customer {

    private String name;

    private String address;

    private String phoneNumber;

    private Gender gender;

    public Customer(String name, String address, String phoneNumber, Gender gender) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(name, customer.name) && Objects.equals(address, customer.address) && Objects.equals(phoneNumber, customer.phoneNumber) && gender == customer.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, gender);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Address: %s, Phone: %s, Gender: %s", name, address, phoneNumber, gender);
    }
}

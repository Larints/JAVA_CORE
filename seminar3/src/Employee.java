public class Employee implements Comparable<Employee> {

    private String name;

    private String lastName;

    private String post;

    private String phoneNumber;

    private double salary;

    public Employee(String name, String lastName, String post, String phoneNumber, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.post = post;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return o.name.compareTo(name);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", post='" + post + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}

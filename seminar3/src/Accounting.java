import java.util.ArrayList;
import java.util.List;

public class Accounting {

    private List<Employee> employees;


    public Accounting() {
        this.employees = new ArrayList<>();
    }


    public void bonusPay() {
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                continue;
            } else employee.setSalary(employee.getSalary() + 5000);
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

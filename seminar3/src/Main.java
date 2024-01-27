public class Main {

    public static void main(String[] args) {
        Department.accounting.addEmployee(new Employee("Max", "Pay",
                "developer", "12432154", 40000
        ));
        Department.accounting.addEmployee(new Employee("Ann", "Dow", "sales",
                "12432154", 25000));
        Department.accounting.addEmployee(new Manager("Liss", "Trow", "manager",
                "12432", 80000));

        Department.accounting.bonusPay();
        Department.accounting.printEmployees();
    }
}

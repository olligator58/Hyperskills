class Employee {

    String name;
    int salary;
    String address;

    public Employee() {
        this.name = "unknown";
        this.salary = 0;
        this.address = "unknown";
    }

    public Employee(String name, int salary) {
        this();
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, int salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
}

class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println("name: " + employee.name + ", salary: " + employee.salary + ", address: " + employee.address);
        employee = new Employee("Gleb", 78000);
        System.out.println("name: " + employee.name + ", salary: " + employee.salary + ", address: " + employee.address);
        employee = new Employee("Alena", 120000, "Moscow, Patriki");
        System.out.println("name: " + employee.name + ", salary: " + employee.salary + ", address: " + employee.address);
    }
}
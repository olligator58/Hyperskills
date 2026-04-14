import java.util.*;
import java.util.stream.Collectors;

class EmployeesCounter {

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold   is lower edge of salary
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(department -> department.code.startsWith("111-"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }

    // Don't change the code below
    static class Employee {
        private final String name;
        private final Long salary;

        Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Long getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class Department {
        private final String name;
        private final String code;
        private final List<Employee> employees;

        Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", employees=" + employees +
                    '}';
        }
    }
}

class Testus {
    public static void main(String[] args) {
        List<EmployeesCounter.Department> departments = new ArrayList<>();
        departments.add(new EmployeesCounter.Department("dep-1", "111-1",
                List.of(new EmployeesCounter.Employee("William", 20000L),
                        new EmployeesCounter.Employee("Sophia", 10000L))));
        departments.add(new EmployeesCounter.Department("dep-2", "222-1",
                List.of(new EmployeesCounter.Employee("John", 50000L))));
        departments.add(new EmployeesCounter.Department("dep-13", "111-2",
                List.of(new EmployeesCounter.Employee("Jack", 19999L),
                        new EmployeesCounter.Employee("Sylvia", 22222L))));
        System.out.println(EmployeesCounter.calcNumberOfEmployees(departments, 20000L));
    }
}
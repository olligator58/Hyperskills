import java.util.function.Supplier;

public class Task {
    public static void main(String[] args) {
        Customer customer = new Customer("Paul", "Morris");
        Supplier<String> getName = customer::getFirstName;
        System.out.println(getName.get());
    }
}

class Customer {

    String firstName;
    String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

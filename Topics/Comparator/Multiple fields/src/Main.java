import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Utils {

    public static void sortUsers(List<User> users) {
        users.sort(Comparator.comparing(User::getName)
                .thenComparing(Comparator.comparingInt(User::getAge).reversed()));
    }
}

class Testus {
    public static void main(String[] args) {
        List<User> users1 = new ArrayList<>();
        users1.add(new User("John", 25));
        users1.add(new User("Jane", 25));
        users1.add(new User("Jim", 18));
        users1.add(new User("Jack", 18));
        users1.add(new User("John", 30));
        Utils.sortUsers(users1);
        System.out.println(users1);
        List<User> users2 = new ArrayList<>();
        users2.add(new User("Abby", 19));
        users2.add(new User("Alice", 19));
        users2.add(new User("Abby", 21));
        users2.add(new User("Alice", 21));
        users2.add(new User("Ashley", 19));
        Utils.sortUsers(users2);
        System.out.println(users2);
    }
}
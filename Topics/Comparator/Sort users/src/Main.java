import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }
}

class Testus {
    public static void main(String[] args) {
        List<User> users1 = new ArrayList<>(List.of(new User("Mike"), new User("Ginger"),
                new User("Alice"), new User("Bob")));
        Comparator<User> comparator = new UserComparator();
        users1.sort(comparator);
        System.out.println(users1);
        List<User> users2 = new ArrayList<>(List.of(new User("microprogrammer"), new User("Moses"),
                new User("Chloe"), new User("user")));
        users2.sort(comparator);
        System.out.println(users2);
    }
}
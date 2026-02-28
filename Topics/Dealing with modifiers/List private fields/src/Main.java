import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Get sorted list of private fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public List<String> getPrivateFields(Object object) {
        List<String> privateFields = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field.getName());
            }
        }
        privateFields.sort(String::compareTo);
        return privateFields;
    }

}

class Testus {
    public int age;
    private String value;
    protected int weight;
    private double back;
    int change;

    public static void main(String[] args) {
        for (String name : new FieldGetter().getPrivateFields(new Testus())) {
            System.out.println(name);
        }
    }
}
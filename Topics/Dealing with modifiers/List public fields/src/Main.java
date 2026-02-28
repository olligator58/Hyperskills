import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Get list of public fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public String[] getPublicFields(Object object) {
        List<String> publicFields = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                publicFields.add(field.getName());
            }
        }
        return publicFields.toArray(new String[0]);
    }

}

class Testus {
    public int age;
    public String name;
    private int weight;
    protected int height;
    public double eggs;

    public static void main(String[] args) {
        for (String publicField : new FieldGetter().getPublicFields(new Testus())) {
            System.out.println(publicField);
        }
    }
}
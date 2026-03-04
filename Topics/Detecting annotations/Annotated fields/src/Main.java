import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        List<String> fields = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.getDeclaredAnnotations().length > 0) {
                fields.add(field.getName());
            }
        }
        return fields.toArray(new String[0]);
    }

}

class Testus {
    private int age;
    @Deprecated
    private String name;
    protected double weight;
    @Deprecated
    double height;

    public static void main(String[] args) {
        for (String field : AnnotationsUtil.getFieldsContainingAnnotations(new Testus())) {
            System.out.println(field);
        }
    }

}
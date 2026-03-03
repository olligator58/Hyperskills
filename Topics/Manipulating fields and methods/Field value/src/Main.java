import java.lang.reflect.Field;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        try {
            return object.getClass().getField(fieldName).get(object);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

}

class Testus {
    private int age;
    protected String name;
    public String gender;

    public Testus(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Testus t = new Testus(23, "John", "male");
        FieldGetter fieldGetter = new FieldGetter();
        System.out.println(fieldGetter.getFieldValue(t, "age"));
        System.out.println(fieldGetter.getFieldValue(t, "name"));
        System.out.println(fieldGetter.getFieldValue(t, "gender"));
        System.out.println(fieldGetter.getFieldValue(t, "surname"));
    }
}
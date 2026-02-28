import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class ReflectionUtils {

    public static int countPublicMethods(Class targetClass) {
        int counter = 0;
        for (Method method : targetClass.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                counter++;
            }
        }
        return counter;
    }
}

class Testus {
    public static void main(String[] args) {
        System.out.println(ReflectionUtils.countPublicMethods(Testus.class));
        System.out.println(ReflectionUtils.countPublicMethods(String.class));
        System.out.println(ReflectionUtils.countPublicMethods(Class.class));

    }

    public void example() {

    }
}
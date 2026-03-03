import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MethodsDemo {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        for (Method method : someClass.getClass().getDeclaredMethods()) {
            try {
                method.setAccessible(true);
                System.out.println(method.invoke(new SomeClass()));
                break;
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/*class SomeClass {

    private int print() {
        return 42;
    }

}*/

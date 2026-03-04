import javax.management.MXBean;
import java.beans.JavaBean;
import java.lang.annotation.Annotation;

class AnnotationUtils {

    public static void printClassAnnotations(Class classObject) {
        for (Annotation annotation : classObject.getDeclaredAnnotations()) {
            String name = annotation.annotationType().toString();
            System.out.println(name.substring(name.lastIndexOf('.') + 1));
        }
    }
}

@Deprecated
@MXBean
@JavaBean
class Testus {

    public static void main(String[] args) {
        AnnotationUtils.printClassAnnotations(Testus.class);
    }
}
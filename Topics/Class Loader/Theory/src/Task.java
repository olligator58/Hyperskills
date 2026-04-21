// You can experiment here, it won’t be checked

public class Task {
    public static void main(String[] args) {
        ClassLoader classLoader = A.class.getClassLoader();
        System.out.println(classLoader.getName());
    }
}

class A {
}

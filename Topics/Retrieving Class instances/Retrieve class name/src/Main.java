/**
 Get name of the class for the object provided.
 */
class ClassGetter {

    public String getObjectClassName(Object object) {
        return object.getClass().getName();
    }

}

class Testus {
    public static void main(String[] args) {
        ClassGetter classGetter = new ClassGetter();
        System.out.println(classGetter.getObjectClassName(classGetter));
        System.out.println(classGetter.getObjectClassName("1"));
        System.out.println(classGetter.getObjectClassName(Integer.parseInt("5")));
    }
}
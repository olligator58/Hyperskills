class SuperClassGetter {

    public Class getSuperClassByName(String name) throws ClassNotFoundException {
        return Class.forName(name).getSuperclass();
    }

    public Class getSuperClassByInstance(Object object) {
        return object.getClass().getSuperclass();
    }
}

class Testus {
    public static void main(String[] args) throws ClassNotFoundException {
        SuperClassGetter superClassGetter = new SuperClassGetter();
        System.out.println(superClassGetter.getSuperClassByName("java.lang.String"));
        System.out.println(superClassGetter.getSuperClassByInstance("1"));
        System.out.println(superClassGetter.getSuperClassByName("java.lang.Integer"));
        Long l = 98989899L;
        System.out.println(superClassGetter.getSuperClassByInstance(l));
        System.out.println(superClassGetter.getSuperClassByInstance(new NullPointerException()));
    }
}
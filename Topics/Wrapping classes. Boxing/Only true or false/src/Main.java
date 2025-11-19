class Primitive {
    public static boolean toPrimitive(Boolean b) {
        return (b != null) ? b : false;
    }
}

class Testus {
    public static void main(String[] args) {
        System.out.println(Primitive.toPrimitive(null));
        System.out.println(Primitive.toPrimitive(Boolean.FALSE));
        System.out.println(Primitive.toPrimitive(Boolean.TRUE));
    }
}
// You can experiment here, it won’t be checked

public class Task {
    public static void main(String[] args) {
        int intValue = 128;
        char charValue = (char) intValue;
        short shortValue = (short) charValue;
        byte byteValue = (byte) shortValue;

        System.out.println("Type conversion: " + intValue + "," + charValue + "," + shortValue + "," + byteValue);
    }
}

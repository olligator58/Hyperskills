import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.Arrays;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        char[] result = null;
        try (CharArrayWriter writer = new CharArrayWriter()) {
            for (String word : words) {
                writer.write(word);
            }
            result = writer.toCharArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

class Testus {
    public static void main(String[] args) throws IOException {
        String[] words = {"This", " ", "is", " ", "a", " ", "test"};
        System.out.println(Arrays.toString(Converter.convert(words)));
    }
}
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            for (byte b : reader.readLine().getBytes()) {
                System.out.print(b);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
// You can experiment here, it won’t be checked

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Task {
    public static void main(String[] args) throws IOException {
        File sampleFile = new File("sample.txt");
        byte[] content = new byte[]{'J', 'a', 'v', 'a'};

        try {
            OutputStream outputStream = new FileOutputStream(sampleFile, true);
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}

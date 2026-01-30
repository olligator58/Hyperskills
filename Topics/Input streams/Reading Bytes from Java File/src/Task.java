// You can experiment here, it won’t be checked

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream(new File("input.txt"));
        byte[] byteArray = new byte[100];
        int bytesRead = fileStream.read(byteArray);
    }
}

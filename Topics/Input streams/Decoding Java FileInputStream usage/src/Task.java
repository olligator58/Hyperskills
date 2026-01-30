// You can experiment here, it won’t be checked

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        byte[] bytesArray = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytesArray);
        fis.close();
    }
}

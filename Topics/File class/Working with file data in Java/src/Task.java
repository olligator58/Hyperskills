// You can experiment here, it won’t be checked

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        String fileName = "C:\\Temp\\flud\\dataset_91007.txt";
        int max = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                int number = scanner.nextInt();
                if (number > max) {
                    max = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла не существует !!!");
        }
        System.out.println(max);
    }
}

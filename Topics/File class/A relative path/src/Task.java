// You can experiment here, it won’t be checked

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        String fileName = "C:\\Temp\\flud\\dataset_91065.txt";
        int counter = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                int number = scanner.nextInt();
                if (number == 0) {
                    break;
                }
                if (number % 2 == 0) {
                    counter++;
                }
            }
            System.out.println("counter: " + counter);
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла не существует");
        }
    }
}

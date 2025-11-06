// You can experiment here, it won’t be checked

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        String fileName = "C:\\Temp\\flud\\dataset_91022.txt";
        int counter = 0;
        int total = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                int number = scanner.nextInt();
                total++;
                if (number >= 9999) {
                    counter++;
                }
            }
            System.out.println("counter: " + counter);
            System.out.println("total: " + total);
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла не существует !!!");
        }
    }
}

// You can experiment here, it won’t be checked

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        String fileName = "C:\\Temp\\flud\\dataset_91069.txt";
        long previousPopulation = 0;
        long maxIncrease = 0;
        int yearOfMaxIncrease = 0;
        boolean isFirstLine = true;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            // заголовок пропускаем
            scanner.nextLine();
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split("\\t");
                int year = Integer.parseInt(data[0]);
                long population = Long.parseLong(data[1].replace(",", ""));
                if (isFirstLine) {
                    previousPopulation = population;
                    isFirstLine = false;
                    continue;
                }
                long increase = population - previousPopulation;
                System.out.println(year + "|" + population + "|" + increase);
                if (increase > maxIncrease) {
                    maxIncrease = increase;
                    yearOfMaxIncrease = year;
                }
                previousPopulation = population;
            }
            System.out.println("yearOfMaxIncrease: " + yearOfMaxIncrease);
            System.out.println("maxIncrease: " + maxIncrease);
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла не существует !!!");
        }
    }
}

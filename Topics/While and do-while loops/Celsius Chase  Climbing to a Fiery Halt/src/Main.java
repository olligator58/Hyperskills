import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxTemperature = 0; // Initialize maximum temperature observed
        int temperature;

        while ((temperature = scanner.nextInt()) < 100) {
            if (temperature > maxTemperature) {
                maxTemperature = temperature;
            }
        }
        // After exiting the loop, print the highest temperature
        System.out.println(maxTemperature);
        scanner.close(); // Close the scanner
    }
}
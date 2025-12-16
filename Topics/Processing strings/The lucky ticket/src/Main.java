import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] ticket = scanner.nextLine().toCharArray();
        int firstThreeSum = 0;
        for (int i = 0; i < 3; i++) {
            firstThreeSum += Character.getNumericValue(ticket[i]);
        }
        int lastThreeSum = 0;
        for (int i = 3; i < 6; i++) {
            lastThreeSum += Character.getNumericValue(ticket[i]);
        }
        String result = (firstThreeSum == lastThreeSum) ? "Lucky" : "Regular";
        System.out.println(result);
        scanner.close();
    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            char grade = scanner.next().charAt(0);
            if (grade == 'A') {
                countA++;
            } else if (grade == 'B') {
                countB++;
            } else if (grade == 'C') {
                countC++;
            } else if (grade == 'D') {
                countD++;
            }
        }
        System.out.println(countD + " " + countC + " " + countB + " " + countA);
        scanner.close();
    }
}
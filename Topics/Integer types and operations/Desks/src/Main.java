import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount1 = scanner.nextInt();
        int studentsCount2 = scanner.nextInt();
        int studentsCount3 = scanner.nextInt();

        int desksCount1 = studentsCount1 / 2 + studentsCount1 % 2;
        int desksCount2 = studentsCount2 / 2 + studentsCount2 % 2;
        int desksCount3 = studentsCount3 / 2 + studentsCount3 % 2;


        System.out.println(desksCount1 + desksCount2 + desksCount3);
    }
}
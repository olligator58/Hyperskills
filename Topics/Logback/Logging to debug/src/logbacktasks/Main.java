package logbacktasks;

public class Main {
    public static void main(String[] args) {
        int result = new Solution().add(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1])
        );
        System.out.println(result);
    }
}

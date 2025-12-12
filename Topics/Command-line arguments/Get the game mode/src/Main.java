class Problem {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            if ("mode".equals(args[i])) {
                System.out.println(args[i + 1]);
                break;
            }
            if (i == args.length - 2) {
                System.out.println("default");
            }
        }
    }
}
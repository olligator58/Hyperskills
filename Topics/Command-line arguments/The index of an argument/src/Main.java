class Problem {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if ("test".equals(args[i])) {
                System.out.println(i);
                break;
            }
            if (i == args.length - 1) {
                System.out.println("-1");
            }
        }
    }
}
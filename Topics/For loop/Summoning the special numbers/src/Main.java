class LandOfNumbers {

    public int summonSpecialNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n * 2; i += 2) {
            sum += i;
        }
        return sum;
    }
}

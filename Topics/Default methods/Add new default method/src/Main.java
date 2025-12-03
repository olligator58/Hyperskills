interface Flying {
    int getHeight();

    default int getHeightInKm() {
        return getHeight() / 1000;
    }
}

class Testus {
    public static void main(String[] args) {
        Flying flying = new Flying() {
            @Override
            public int getHeight() {
                return 6347;
            }
        };
        System.out.println(flying.getHeightInKm());
    }
}
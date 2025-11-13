enum SI {

    M("length"),
    KG("mass"),
    S("time");

    public final String quantityName;

    SI(String quantityName) {
        this.quantityName = quantityName;
    }

    public String getQuantityName() {
        return quantityName;
    }
}

class Testus {
    public static void main(String[] args) {
        System.out.println(SI.M.getQuantityName());
        System.out.println(SI.KG.getQuantityName());
        System.out.println(SI.S.getQuantityName());
    }
}
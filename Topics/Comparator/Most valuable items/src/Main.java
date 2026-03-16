import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StockItem {
    private String name;
    private double pricePerUnit;
    private int quantity;

    public StockItem(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + pricePerUnit + ", " + quantity + ";";
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Utils {
    public static List<StockItem> sort(List<StockItem> stockItems) {
        stockItems.sort(Comparator.comparing(s -> s.getPricePerUnit() * s.getQuantity(), Comparator.reverseOrder()));
        return stockItems;
    }
}

class Testus {
    public static void main(String[] args) {
        List<StockItem> items1 = new ArrayList<>();
        items1.add(new StockItem("nails", 0.01, 512));
        items1.add(new StockItem("hammers", 7.5, 24));
        items1.add(new StockItem("screws", 0.02, 318));
        Utils.sort(items1);
        System.out.println(items1);
        List<StockItem> items2 = new ArrayList<>();
        items2.add(new StockItem("pens", 3.72, 40));
        items2.add(new StockItem("pencils", 1.45, 75));
        items2.add(new StockItem("notebooks", 0.84, 130));
        Utils.sort(items2);
        System.out.println(items2);
    }
}
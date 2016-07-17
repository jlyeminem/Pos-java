package goods;

/**
 * Created by jly on 16-7-17.
 */
public class Goods {
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private String category;


    public Goods(String barcode, String name, String unit, double price,String category) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.category = category;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }
}

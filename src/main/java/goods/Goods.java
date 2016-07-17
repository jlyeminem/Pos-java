package goods;

/**
 * Created by jly on 16-7-17.
 */
public class Goods {
    private String barcode;
    private String name;
    private double price;

    public String getBarcode() {
        return barcode;
    }

    public Goods(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

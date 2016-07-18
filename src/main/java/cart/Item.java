package cart;

public class Item {
    private String type;
    private String barcode;
    private int num;
    private double price;
    private double promotedPrice;

    public Item(String type, String barcode, int num, double price, double promotedPrice) {
        this.type = type;
        this.barcode = barcode;
        this.num = num;
        this.price = price;
        this.promotedPrice = promotedPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPromotedPrice() {
        return promotedPrice;
    }

    public void setPromotedPrice(double promotedPrice) {
        this.promotedPrice = promotedPrice;
    }
}

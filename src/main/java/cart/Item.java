package cart;

public class Item {
    private String type;    //打折类型
    private String barcode; //
    private int num;        //数量
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

    public String getBarcode() {
        return barcode;
    }

    public int getNum() {
        return num;
    }

    public double getPrice() {
        return price;
    }

    public double getPromotedPrice() {
        return promotedPrice;
    }
}

package cart;

public class Item {
    private String type;    //打折类型
    private String barcode; //商品条形码
    private int num;        //商品数量
    private double price;   //商品不享受促销时,应付的价格
    private double promotedPrice;  //商品享受促销时,应付的价格

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

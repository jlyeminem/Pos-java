package goods;

//商品类,其属性为商品信息:名称，数量单位，单价，类别和条形码（伪）。
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

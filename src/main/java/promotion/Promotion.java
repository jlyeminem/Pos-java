package promotion;

import goods.Goods;

import java.util.ArrayList;
import java.util.List;

//促销方式,父类;除了getPrice外,其他函数都会被子类调用
public abstract class Promotion {

    protected List<String> promotionList = new ArrayList<>();
    protected String type;

    public String getType() {
        return type;
    }

    public void addPromotionItem(String barcode) {
        promotionList.add(barcode);
    }

    public abstract double getPrice(Goods goods, int num);

    public double getCouldPayPrice(double price) {
        return Double.parseDouble(String.format("%.2f",price));  //得到两位小数的价格
    }

    public boolean isContain(String barcode) {
        return promotionList.contains(barcode);
    }

    public void deletePromotionItem(String barcode) {
        if (!promotionList.contains(barcode)) {
            return;
        }
        promotionList.remove(barcode);
    }
}

package promotion;

import goods.Goods;

import java.util.List;

//95折促销方式
public class NinetyFiveDiscountPromotion extends Promotion {

    public NinetyFiveDiscountPromotion() {
        type = "FIVE_PERCENT_DISCOUNT";
    }

    @Override
    public  double getPrice( Goods goods,int num) {
        double price = num * goods.getPrice();
        if (promotionList.contains(goods.getBarcode())) {
            price = num * 0.95 * goods.getPrice();
        }

        return getCouldPayPrice(price);
    }
}

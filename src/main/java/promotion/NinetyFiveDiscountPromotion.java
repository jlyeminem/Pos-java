package promotion;

import goods.Goods;

import java.util.List;

//95折促销方式
public class NinetyFiveDiscountPromotion extends Promotion {

    public NinetyFiveDiscountPromotion() {
        type = "FIVE_PERCENT_DISCOUNT";
    }

    @Override
    public double getPrice( Goods goods,int num) {
        double price = num * goods.getPrice();
        if (promotionList.contains(goods.getBarcode())) {
            price = num * 0.95 * goods.getPrice();
        }

        return getCouldPayPrice(price);  //95折相当于在原价的基础上打5折,返回的是优惠的价格,当不享受该优惠时,则返回原价
    }
}

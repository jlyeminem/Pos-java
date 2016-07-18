package promotion;

import goods.Goods;
import onsale.NinetyFiveDiscountGoodsList;

import java.util.List;

//95折促销方式
public class NinetyFiveDiscountPromotion extends Promotion {
    NinetyFiveDiscountGoodsList promotionList = new NinetyFiveDiscountGoodsList();
    List<String> promotionBarcodes = promotionList.getPromotionBarcodes();

    @Override
    double getPrice( Goods goods,int num) {
        double price = num * goods.getPrice();
        if (promotionBarcodes.contains(goods.getBarcode())) {
            price = num * 0.95 * goods.getPrice();
        }

        return getCouldPayPrice(price);
    }
}

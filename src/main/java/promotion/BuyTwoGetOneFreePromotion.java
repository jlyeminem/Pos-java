package promotion;

import goods.Goods;
import onsale.BuyTwoGetOneFreeGoodsList;

import java.util.List;

//买二赠一促销方式
public class BuyTwoGetOneFreePromotion extends Promotion {
    List<String> promotionBarcodes = BuyTwoGetOneFreeGoodsList.getPromotionBarcodes();

    @Override
    double getPrice(Goods goods, int num) {
        double price = num * goods.getPrice();
        if ( promotionBarcodes.contains(goods.getBarcode())) {
            int freeNum = num / 3;
            num -= freeNum;
            price = num * goods.getPrice();
        }
        return getCouldPayPrice(price);    //买二赠一相当于买三个花二个的钱
    }
}

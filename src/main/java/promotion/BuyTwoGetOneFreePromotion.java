package promotion;

import goods.Goods;

import java.util.ArrayList;
import java.util.List;

//买二赠一促销方式
public class BuyTwoGetOneFreePromotion extends Promotion {

    public BuyTwoGetOneFreePromotion() {
        type = "BUY_TWO_GET_ONE_FREE";
    }

    @Override
    public  double getPrice(Goods goods, int num) {
        double price = num * goods.getPrice();
        if ( promotionList.contains(goods.getBarcode())) {
            int freeNum = num / 3;
            num -= freeNum;
            price = num * goods.getPrice();
        }

        return getCouldPayPrice(price);    //买二赠一相当于买三个花二个的钱,返回的是优惠的价格,当不享受该优惠时,则返回-1
    }
}

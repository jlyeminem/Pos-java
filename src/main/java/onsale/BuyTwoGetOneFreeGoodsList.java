package onsale;

import java.util.ArrayList;
import java.util.List;

//享受买二赠一促销的商品信息
public class BuyTwoGetOneFreeGoodsList {
    public static String type = "BUY_TWO_GET_ONE_FREE";
    private static List<String> promotionBarcodes = new ArrayList<>();

    static {
        promotionBarcodes.add("ITEM000001");  //羽毛球
        promotionBarcodes.add("ITEM000005");  //可口可乐
    }

    public static List<String> getPromotionBarcodes() {
        return promotionBarcodes;
    }
}

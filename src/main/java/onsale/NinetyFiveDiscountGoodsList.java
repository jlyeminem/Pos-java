package onsale;

import java.util.ArrayList;
import java.util.List;

//享受95折促销的商品信息
public class NinetyFiveDiscountGoodsList {
    public static String type = "FIVE_PERCENT_DISCOUNT";
    private static List<String> promotionBarcodes = new ArrayList<>();

    static {
        promotionBarcodes.add("ITEM000003-");  //苹果
    }

    public static List<String> getPromotionBarcodes() {
        return promotionBarcodes;
    }
}

package onsale;

import java.util.ArrayList;
import java.util.List;

//享受95折促销的商品信息
public class NinetyFiveDiscountGoodsList {
    public static String type = "FIVE_PERCENT_DISCOUNT";
    private static List<String> promotionBarcodes = new ArrayList<>();

    public static List<String> getPromotionBarcodes() {
        addPromotionItem("ITEM000003-");
        return promotionBarcodes;    //苹果
    }

    public static void addPromotionItem(String barcode) {
        promotionBarcodes.add(barcode);
    }

    public static void deleteItemFromPromotion(String barcode) {
        promotionBarcodes.remove(barcode);
    }
}

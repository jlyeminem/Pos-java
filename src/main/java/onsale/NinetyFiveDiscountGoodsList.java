package onsale;

import java.util.ArrayList;
import java.util.List;

//享受95折促销的商品信息
public class NinetyFiveDiscountGoodsList {
    public static String type = "FIVE_PERCENT_DISCOUNT";
    private List<String> promotionBarcodes = new ArrayList<>();

    public List<String> getPromotionBarcodes() {
        addPromotionItem("ITEM000003-");
        return promotionBarcodes;    //苹果
    }

    public void addPromotionItem(String barcode) {
        promotionBarcodes.add(barcode);
    }

    public void deleteItemFromPromotion(String barcode) {
        promotionBarcodes.remove(barcode);
    }
}

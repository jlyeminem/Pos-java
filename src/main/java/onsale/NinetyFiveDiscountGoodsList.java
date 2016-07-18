package onsale;

import java.util.ArrayList;
import java.util.List;

//享受95折促销的商品信息
public class NinetyFiveDiscountGoodsList {
    private static List<String> promotionBarcodes = new ArrayList<>();

    static {
        promotionBarcodes.add("ITEM000003");  //苹果
    }

    public void addPromotionBarcode(String barcode) {
        promotionBarcodes.add(barcode);
    }

    public void removePromotionBarcode(String barcode) {
        if (promotionBarcodes.contains(barcode)) {
            promotionBarcodes.remove(barcode);
        } else {
            throw new RuntimeException();
        }
    }

    public void addAllPromotionBarcodes(List<String> barcodes) {
        promotionBarcodes.addAll(barcodes);
    }

    public List<String> getPromotionBarcodes() {
        return promotionBarcodes;
    }
}

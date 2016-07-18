package onsale;

import java.util.ArrayList;
import java.util.List;

//享受买二赠一促销的商品信息
public class BuyTwoGetOneFreeGoodsList {
    public static String type = "BUY_TWO_GET_ONE_FREE";
    private List<String> promotionBarcodes = new ArrayList<>();

    public List<String> getPromotionBarcodes() {
        addPromotionItem("ITEM000001");    //羽毛球
        addPromotionItem("ITEM000005");    //可口可乐
        return promotionBarcodes;
    }

    public void addPromotionItem(String barcode) {
        promotionBarcodes.add(barcode);
    }

    public void deleteItemFromPromotion(String barcode) {
        promotionBarcodes.remove(barcode);
    }
}

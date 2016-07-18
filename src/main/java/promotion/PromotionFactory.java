package promotion;

import cart.CartItems;
import cart.Item;
import goods.Goods;
import goods.GoodsMap;
import onsale.BuyTwoGetOneFreeGoodsList;
import onsale.NinetyFiveDiscountGoodsList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromotionFactory {
    public static List<Item> solveItems(List<String> barcodes) {
        Map<String, Integer> cartItems = new CartItems(barcodes).getCartItems();
        List<Item> items = new ArrayList<>();
        for (Map.Entry entry:cartItems.entrySet()) {
            String barcode = (String) entry.getKey();
            Goods goods = GoodsMap.getMap().get(barcode);
            int num = (int) entry.getValue();
            double price = num * goods.getPrice();
            double promotedPrice = price;
            String type;
            if (BuyTwoGetOneFreeGoodsList.getPromotionBarcodes().contains(barcode)
                    && NinetyFiveDiscountGoodsList.getPromotionBarcodes().contains(barcode)) {
                Promotion promotion = new BuyTwoGetOneFreePromotion();
                promotedPrice = promotion.getPrice(goods,num);
                if (promotedPrice != price) {
                    type = BuyTwoGetOneFreeGoodsList.type;
                } else {
                    promotion = new NinetyFiveDiscountPromotion();
                    promotedPrice = promotion.getPrice(goods,num);
                    type = NinetyFiveDiscountGoodsList.type;
                }
            } else if (NinetyFiveDiscountGoodsList.getPromotionBarcodes().contains(barcode)) {
                Promotion promotion = new NinetyFiveDiscountPromotion();
                promotedPrice = promotion.getPrice(goods,num);
                type = NinetyFiveDiscountGoodsList.type;
            } else if (BuyTwoGetOneFreeGoodsList.getPromotionBarcodes().contains(barcode)) {
                Promotion promotion = new BuyTwoGetOneFreePromotion();
                promotedPrice = promotion.getPrice(goods,num);
                if (promotedPrice != price) {
                    type = BuyTwoGetOneFreeGoodsList.type;
                } else {
                    type = "NO_PROMOTION";
                }
            } else {
                type = "NO_PROMOTION";
            }
            Item item = new Item(type,barcode,num,price,promotedPrice);
            items.add(item);
        }
        return items;
    }
}

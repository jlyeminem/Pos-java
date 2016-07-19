package cart;

import promotion.BuyTwoGetOneFreePromotion;
import promotion.NinetyFiveDiscountPromotion;
import promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

//各类促销商品的信息
public class OnSaleInf {
    private  List<Promotion> promotionList = new ArrayList<>();

    OnSaleInf() {

        BuyTwoGetOneFreePromotion buyTwoGetOneFreePromotion = new BuyTwoGetOneFreePromotion();
        NinetyFiveDiscountPromotion ninetyFiveDiscountPromotion = new NinetyFiveDiscountPromotion();

        promotionList.add(buyTwoGetOneFreePromotion);
        promotionList.add(ninetyFiveDiscountPromotion);
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public void addPromotion(String barcode, String type) {
        for (Promotion promotion: promotionList) {
            if (promotion.getType().equals(type)) {
                promotion.addPromotionItem(barcode);
                break;
            }
        }
    }

    public void deletePromotion(String barcode, String type) {
        for (Promotion promotion: promotionList) {
            if (promotion.getType().equals(type)) {
                promotion.deletePromotionItem(barcode);
                break;
            }
        }
    }
}

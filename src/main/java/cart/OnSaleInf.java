package cart;

import promotion.BuyTwoGetOneFreePromotion;
import promotion.NinetyFiveDiscountPromotion;
import promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

//各类促销商品的信息,汇总在promotionList中
public class OnSaleInf {
    private List<Promotion> promotionList = new ArrayList<>();

    public OnSaleInf() {

        BuyTwoGetOneFreePromotion buyTwoGetOneFreePromotion = new BuyTwoGetOneFreePromotion();
        NinetyFiveDiscountPromotion ninetyFiveDiscountPromotion = new NinetyFiveDiscountPromotion();

        promotionList.add(buyTwoGetOneFreePromotion);
        promotionList.add(ninetyFiveDiscountPromotion);
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    //添加促销商品,添加的时候需要说明商品条形码和促销方式
    public void addPromotion(String barcode, String type) {
        for (Promotion promotion: promotionList) {
            if (promotion.getType().equals(type)) {
                promotion.addPromotionItem(barcode);
                break;
            }
        }
    }

    //删除促销商品,删除商品条形码为barcode、促销方式为type的促销信息
    public void deletePromotion(String barcode, String type) {
        for (Promotion promotion: promotionList) {
            if (promotion.getType().equals(type)) {
                promotion.deletePromotionItem(barcode);
                break;
            }
        }
    }
}

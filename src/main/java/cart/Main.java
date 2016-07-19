package cart;

import cart.Cart;
import cart.OnSaleInf;
import promotion.Promotion;

import java.util.ArrayList;
import java.util.List;


//相当于收银台的日常工作
public class Main {
    public static void main(String[] args) {
        //初始化: 促销商品信息
        OnSaleInf onSaleInf = new OnSaleInf();
        onSaleInf.addPromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");
        List<Promotion> promotionList = onSaleInf.getPromotionList();

        List<String> wantsToBuyList = new ArrayList<>();
        for (int i = 0;i < 5;i++) {
            wantsToBuyList.add("ITEM000001");
        }
        for (int i = 0;i < 3;i++) {
            wantsToBuyList.add("ITEM000005");
        }
        for (int i = 0;i < 1;i++) {
            wantsToBuyList.add("ITEM000003-2");
        }

        Cart cart = new Cart(wantsToBuyList);
        cart.formatItem(promotionList);
        String str = cart.printShoppingList();
        str += cart.printPromotionList("BUY_TWO_GET_ONE_FREE");
        str += cart.printPayInf();
        System.out.println(str);

        onSaleInf.deletePromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.deletePromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");
        promotionList = onSaleInf.getPromotionList();
        cart = new Cart(wantsToBuyList);
        cart.formatItem(promotionList);
        String str1 = cart.printShoppingList();
        str1 += cart.printPromotionList("BUY_TWO_GET_ONE_FREE");
        str1 += cart.printPayInf();
        System.out.println(str1);

        onSaleInf.addPromotion("ITEM000003-","FIVE_PERCENT_DISCOUNT");
        promotionList = onSaleInf.getPromotionList();
        cart = new Cart(wantsToBuyList);
        cart.formatItem(promotionList);
        String str2 = cart.printShoppingList();
        str2 += cart.printPromotionList("BUY_TWO_GET_ONE_FREE");
        str2 += cart.printPromotionList("FIVE_PERCENT_DISCOUNT");
        str2 += cart.printPayInf();
        System.out.println(str2);
    }

}

package cart;

import cart.Cart;
import cart.OnSaleInf;

import java.util.ArrayList;
import java.util.List;


//相当于收银台的日常工作
public class Main {
    public static void main() {
        //初始化: 促销商品信息
        OnSaleInf onSaleInf = new OnSaleInf();
        onSaleInf.addPromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");

        List<String> wantsToBuyList = new ArrayList<>();
        for (int i = 0;i < 3;i++) {
            wantsToBuyList.add("ITEM000001");
        }
        for (int i = 0;i < 5;i++) {
            wantsToBuyList.add("ITEM000005");
        }
        for (int i = 0;i < 1;i++) {
            wantsToBuyList.add("ITEM000003-2");
        }

        Cart cart = new Cart(wantsToBuyList);
        String str = cart.printShoppingList();
        str += cart.printPromotionList("BUY_TWO_GET_ONE_FREE");
        str += cart.printPayInf();
        System.out.println(str);
    }

}

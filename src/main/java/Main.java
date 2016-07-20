import cart.Cart;
import cart.OnSaleInf;
import promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jly on 16-7-19.
 */
public class Main {
    public static void main(String[] args) {
        //初始化,即想买的商品加入wantsToBuyList中,wantsToBuyList只存储商品的条形码
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

        //当购买的商品中,有符合"买二赠一"优惠条件的商品时
        OnSaleInf onSaleInf = new OnSaleInf();
        onSaleInf.addPromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");
        PosApp posApp = new PosApp(wantsToBuyList,onSaleInf);
        String str = posApp.getResult();
        System.out.println(str);

        //当购买的商品中,没有符合"买二赠一"优惠条件的商品时,将上次加入的优惠商品从优惠中删除
        onSaleInf.deletePromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.deletePromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");
        PosApp posApp1 = new PosApp(wantsToBuyList,onSaleInf);
        String str1 = posApp1.getResult();
        System.out.println(str1);

        //当购买的商品中,有符合"95"折优惠条件的商品时
        onSaleInf.addPromotion("ITEM000003-","FIVE_PERCENT_DISCOUNT");
        PosApp posApp2 = new PosApp(wantsToBuyList,onSaleInf);
        String str2 = posApp2.getResult();
        System.out.println(str2);

        //当购买的商品中,有符合"95"折优惠条件的商品,又有符合"买二赠一"优惠条件的商品时
        onSaleInf.addPromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","FIVE_PERCENT_DISCOUNT");
        PosApp posApp3 = new PosApp(wantsToBuyList,onSaleInf);
        String str3 = posApp3.getResult();
        System.out.println(str3);
    }
}

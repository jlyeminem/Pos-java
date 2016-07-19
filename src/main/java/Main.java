import cart.OnSaleInf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jly on 16-7-19.
 */
public class Main {
    public static void main(String[] args) {
        OnSaleInf onSaleInf = new OnSaleInf();
        onSaleInf.addPromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");
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
        PosApp posApp = new PosApp(wantsToBuyList,onSaleInf);
        String str = posApp.getResult();
        System.out.println(str);
    }
}

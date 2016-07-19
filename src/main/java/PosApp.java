import cart.Cart;
import cart.OnSaleInf;
import promotion.Promotion;

import java.util.List;

/**
 * Created by jly on 16-7-19.
 */
public class PosApp {
    private OnSaleInf onSaleInf;
    private Cart cart;
    private List<String> barcodes;

    public PosApp(List<String> barcodes,OnSaleInf onSaleInf) {
        this.onSaleInf = onSaleInf;
        this.barcodes = barcodes;
        initData(barcodes);
    }

    private void initData(List<String> barcodes) {
        cart = new Cart(barcodes);
    }

    public String getResult() {
        final List<Promotion> promotionList = onSaleInf.getPromotionList();
        cart.formatItem(promotionList);
        String str = cart.printShoppingList();
        str += cart.printPromotionList("BUY_TWO_GET_ONE_FREE");
        str += cart.printPromotionList("FIVE_PERCENT_DISCOUNT");
        str += cart.printPayInf();
        return str;
    }
}

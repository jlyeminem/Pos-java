import cart.Cart;
import cart.OnSaleInf;
import promotion.Promotion;
import utils.JsonUtils;

import java.util.List;

//封装;购物车由用户打算购买的商品和促销信息初始化,即PosApp.
//getResult则打印商品的清单、促销信息、结账信息
public class PosApp {
    private OnSaleInf onSaleInf;
    private Cart cart;
    private List<String> barcodes;

    public PosApp(String jsonStr,OnSaleInf onSaleInf) {
        this.onSaleInf = onSaleInf;
        this.barcodes = JsonUtils.parseJsonString(jsonStr);
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

package cart;


import utils.ParseUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItems {
    private Map<String,Integer> cartItems = new HashMap<>();

    public CartItems(List<String> barcodes) {
        for (String barcode:barcodes) {
            int num = ParseUtils.parseBarcode(barcode);
            ParseUtils.parseItemNum(cartItems,num,barcode);
        }
    }

    public Map<String,Integer> getCartItems() {
        return cartItems;
    }
}

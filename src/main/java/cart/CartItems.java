package cart;


import utils.ParseUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItems {
    private Map<String,Integer> cartItems = new HashMap<>();

    public CartItems(List<String> barcodes) {
        for (String barcode:barcodes) {
            int num = ParseUtils.parse(barcode);
            putToMap(num,barcode);
        }
    }

    public Map<String,Integer> getCartItems() {
        return cartItems;
    }

    private void putToMap(int num, String barcode) {
        String str = barcode;
        if (barcode.contains("-")) {
            str = barcode.substring(0,barcode.indexOf("-"));
        }
        if (cartItems.containsKey(str)) {
            num += cartItems.get(str);
            cartItems.replace(str,num);
        } else {
            cartItems.put(str,num);
        }
    }
}

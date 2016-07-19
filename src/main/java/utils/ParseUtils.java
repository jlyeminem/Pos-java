package utils;

import goods.Goods;
import goods.GoodsMap;

import java.util.HashMap;
import java.util.Map;

//解析收银机获取到的商品条形码中包含'-'的条形码,如苹果的条形码"ITEM000003-2"
public class ParseUtils {

    public static String parseItemBarcode(String barcode) {
        String str = barcode;
        if (barcode.contains("-")) {
            str = barcode.substring(0,barcode.indexOf("-") + 1);
        }
        return str;
    }

    public static int parseBarcode(String barcode) {
        HashMap<String, Goods> map = GoodsMap.getMap();

        String parseItemBarcode = parseItemBarcode(barcode);
        if (!barcode.equals(parseItemBarcode)) {
            if (map.containsKey(parseItemBarcode)) {
                String str = barcode.substring(barcode.indexOf("-") + 1);
                return Integer.parseInt(str);
            } else {
                throw new RuntimeException();
            }
        } else if (map.containsKey(barcode)) {
            return 1;
        } else {
            throw new RuntimeException();
        }
    }
}

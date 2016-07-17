package utils;

import goods.Goods;
import goods.GoodsMap;

import java.util.HashMap;

/**
 * Created by jly on 16-7-17.
 */
public class ParseUtils {
    public static int parse(String barcode) {
        HashMap<String, Goods> map = GoodsMap.getMap();

        if (barcode.contains("-")) {
            String item = barcode.substring(0,barcode.indexOf( "-"));
            if (map.containsKey( item)) {
                String str = barcode.substring(barcode.indexOf( "-") + 1);
                return Integer.parseInt(str);
            } else {
                throw new RuntimeException();
            }
        } else if ( map.containsKey( barcode)) {
            return 1;
        } else {
            throw new RuntimeException();
        }
    }
}

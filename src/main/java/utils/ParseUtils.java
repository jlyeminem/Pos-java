package utils;

import goods.Goods;
import goods.GoodsMap;

import java.util.HashMap;

//解析收银机获取到的商品条形码中包含'-'的条形码,如苹果的条形码"ITEM000003-2"
public class ParseUtils {
    public static int parse(String barcode) {
        HashMap<String, Goods> map = GoodsMap.getMap();

        if (barcode.contains( "-" )) {
            int index = barcode.indexOf( "-" ) + 1;
            String item = barcode.substring(0,index);
            if (map.containsKey( item)) {
                String str = barcode.substring(index);
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

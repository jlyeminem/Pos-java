package goods;

import java.util.HashMap;

/**
 * Created by jly on 16-7-17.
 */
public class GoodsMap {
    private static HashMap<String, Goods> map = new HashMap<>();

    static {
        Goods goods = new Goods("ITEM000005","可口可乐","瓶",3.00);
        map.put("ITEM000005",goods);
        goods = new Goods("ITEM000003","苹果","斤",5.50);
        map.put("ITEM000003",goods);
        goods = new Goods("ITEM000001","羽毛球","个",1.00);
        map.put("ITEM000001",goods);
    }

    public static HashMap<String, Goods> getMap() {
        return map;
    }
}

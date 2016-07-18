package goods;

import java.util.HashMap;

//map中存储着商店的全部商品信息,可通过商品条形码查看商品的具体信息
public class GoodsMap {
    private static HashMap<String, Goods> map = new HashMap<>();

    static {
        Goods goods = new Goods("ITEM000001","羽毛球","个",1.00,"球类");
        map.put("ITEM000001",goods);
        goods = new Goods("ITEM000003","苹果","斤",5.50,"水果");
        map.put("ITEM000003-",goods);
        goods = new Goods("ITEM000005","可口可乐","瓶",3.00,"饮料");
        map.put("ITEM000005",goods);
    }

    public static HashMap<String, Goods> getMap() {
        return map;
    }
}

package goods;

import java.util.HashMap;

//map中存储着商店的全部商品信息,可通过商品条形码查看商品的具体信息
public class GoodsMap {
    private static HashMap<String, Goods> map = new HashMap<>();

    static {
        Goods goods = new Goods("ITEM000001","羽毛球","个",1.00,"球类");
        map.put("ITEM000001",goods);
        goods = new Goods("ITEM000003-","苹果","斤",5.50,"水果");
        map.put("ITEM000003-",goods);
        goods = new Goods("ITEM000005","可口可乐","瓶",3.00,"饮料");
        map.put("ITEM000005",goods);
        goods = new Goods("ITEM000000","篮球","个",100.00,"球类");
        map.put("ITEM000000",goods);
        goods = new Goods("ITEM000006","水杯","个",10.00,"生活用品");
        map.put("ITEM000006",goods);
        goods = new Goods("ITEM000002","雪碧","瓶",3.00,"饮料");
        map.put("ITEM000002",goods);
    }

    public static HashMap<String, Goods> getMap() {
        return map;
    }
}

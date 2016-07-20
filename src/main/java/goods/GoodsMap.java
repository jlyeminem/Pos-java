package goods;

import java.util.HashMap;
import java.util.List;

//map中存储着商店的全部商品信息,可通过商品条形码查看商品的具体信息
public class GoodsMap {
    private static HashMap<String, Goods> goodsMap = new HashMap<>();

    static {
        Goods goods = new Goods("ITEM000001","羽毛球","个",1.00,"球类");
        goodsMap.put("ITEM000001",goods);
        goods = new Goods("ITEM000003-","苹果","斤",5.50,"水果");
        goodsMap.put("ITEM000003-",goods);
        goods = new Goods("ITEM000005","可口可乐","瓶",3.00,"饮料");
        goodsMap.put("ITEM000005",goods);
        goods = new Goods("ITEM000000","篮球","个",100.00,"球类");
        goodsMap.put("ITEM000000",goods);
        goods = new Goods("ITEM000006","水杯","个",10.00,"生活用品");
        goodsMap.put("ITEM000006",goods);
        goods = new Goods("ITEM000002","雪碧","瓶",3.00,"饮料");
        goodsMap.put("ITEM000002",goods);
    }

    public static HashMap<String, Goods> getMap() {
        return goodsMap;
    }

    public static void addGoods(Goods goods) {
        goodsMap.put(goods.getBarcode(),goods);
    }

    public static void removeGoods(String barcode) {
        if (goodsMap.containsKey(barcode)) {
            goodsMap.remove(barcode);
        } else {
            throw new RuntimeException();
        }
    }

    public static void addAllGoods(List<Goods> goodsList) {
        for (Goods goods:goodsList) {
            goodsMap.put(goods.getBarcode(),goods);
        }
    }
}

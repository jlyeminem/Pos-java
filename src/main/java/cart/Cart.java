package cart;

import goods.Goods;
import goods.GoodsMap;
import promotion.Promotion;
import utils.ParseUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//购物车,存放商品条形码和对应数量
//根据购物车和促销信息得到购物车中商品对应的打折类型,条形码,购买数量,实际价格,打折价格
public class Cart {
    private Map<String,Integer> cartMap = new HashMap<>();
    List<Item> purchasedList = new ArrayList<>();

    //根据购物车中的商品,将商品条形码和对应数目存放到cartMap
    Cart(List<String> wantsToBuy) {
        ParseUtils parseUtils = new ParseUtils();
        for (int i = 0; i < wantsToBuy.size(); i++) {
            String barcode = wantsToBuy.get(i);
            barcode = parseUtils.parseItemBarcode(barcode);
            int num = parseUtils.parseBarcode(barcode);
            if (cartMap.containsKey(barcode)) {
                num += cartMap.get(barcode);
                cartMap.replace(barcode, num);
            } else {
                cartMap.put(barcode, num);
            }
        }
    }

    //根据购物车和促销信息,将购物车中商品对应的打折类型,条形码,购买数量,实际价格,打折价格存放到purchasedList
    public void formatItem(List<Promotion> promotionList) {
        for (Map.Entry entry:cartMap.entrySet()) {
            String barcode = (String) entry.getKey();
            Goods goods = GoodsMap.getMap().get(barcode);
            int num = (int) entry.getValue();
            double price = num * goods.getPrice();
            double promotedPrice = price;
            String type = "NO_PROMOTION";

            for (int i = 0;i < promotionList.size();i++) {
                Promotion promotion = promotionList.get(i);
                if (promotion.isContain(barcode)) {
                    type = promotion.getType();   //商品同时满足买二赠一和95折优惠,选择买二赠一
                    promotedPrice = promotion.getPrice(goods,num);
                    break;
                }
            }
            Item item = new Item(type,barcode,num,price,promotedPrice);
            purchasedList.add(item);
        }
    }

    public List<Item> getPurchasedList() {
        return purchasedList;
    }

    //根据cartMap中的商品信息进行打印,打印出用户的购买清单
    public String printShoppingList() {
        StringBuilder sb = new StringBuilder("***<没钱赚商店>购物清单***");
        for (int i = 0;i < purchasedList.size();i++) {
            Item item = purchasedList.get(i);
            String barcode = item.getBarcode();
            Goods goods = GoodsMap.getMap().get(barcode);
            double save = item.getPrice() - item.getPromotedPrice();
            sb.append("名称:" + goods.getName() + ",数量:" + item.getNum() + goods.getUnit()
                    + ",单价:" + goods.getPrice() + "(元),小计:" + item.getPromotedPrice() + "(元)");
            if (save > 0) {
                sb.append(",节省:" + save + "(元)");
            }
        }
        return sb.toString();

    }

}

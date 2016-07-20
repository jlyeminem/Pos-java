package cart;

import org.junit.Before;
import org.junit.Test;
import promotion.Promotion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CartTest {
    private List<String> wantsToBuyList = new ArrayList<>();
    private List<Item> purchasedList ;
    Cart cart;
    String shoppingList;

    @Before
    public void setUp() throws Exception {
        for (int i = 0;i < 5;i++) {
            wantsToBuyList.add("ITEM000001");
        }
        for (int i = 0;i < 3;i++) {
            wantsToBuyList.add("ITEM000005");
        }
        for (int i = 0;i < 1;i++) {
            wantsToBuyList.add("ITEM000003-2");
        }
        cart = new Cart(wantsToBuyList);

        OnSaleInf onSaleInf = new OnSaleInf();
        onSaleInf.addPromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","FIVE_PERCENT_DISCOUNT");
        List<Promotion> promotionList = onSaleInf.getPromotionList();
        cart.formatItem(promotionList);
        purchasedList = cart.getPurchasedList();
        shoppingList = cart.printShoppingList();
    }

    @Test
    public void formatItem() throws Exception {
        assertThat(purchasedList.size(),is(3));

        for (int i = 0;i < purchasedList.size();i++) {
            Item item = purchasedList.get(i);
            if (item.getBarcode()=="NO_PROMOTION" && item.getBarcode()=="ITEM000003-") {
                assertThat(item.getNum(),is(2));
                assertThat(item.getPrice(),is(11.00));
                assertThat(item.getPromotedPrice(),is(11.00));
            }
            if (item.getBarcode()=="BUY_TWO_GET_ONE_FREE" && item.getBarcode()=="ITEM000001") {
                assertThat(item.getNum(),is(5));
                assertThat(item.getPrice(),is(5.00));
                assertThat(item.getPromotedPrice(),is(4.00));
            }
            if (item.getBarcode()=="FIVE_PERCENT_DISCOUNT" && item.getBarcode()=="ITEM000005") {
                assertThat(item.getNum(),is(3));
                assertThat(item.getPrice(),is(9.00));
                assertThat(item.getPromotedPrice(),is(8.55));
            }
        }
    }

    @Test
    public void shouldPrintShoppingListWhenBuyItems() throws Exception {
        StringBuilder sb = new StringBuilder("***<没钱赚商店>购物清单***\n");
        sb.append("名称:可口可乐,数量:3瓶,单价:3.00(元),小计:8.55(元),节省:0.45(元)\n");
        sb.append("名称:苹果,数量:2斤,单价:5.50(元),小计:11.00(元)\n");
        sb.append("名称:羽毛球,数量:5个,单价:1.00(元),小计:4.00(元)\n");
        sb.append("----------------------\n");
        assertThat(shoppingList,is(sb.toString()));
    }

    @Test
    public void shouldPrintPromotionListWhenBuyPromotionItem() throws Exception {
        OnSaleInf onSaleInf = new OnSaleInf();
        onSaleInf.addPromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000005","FIVE_PERCENT_DISCOUNT");
        List<Promotion> promotionList = onSaleInf.getPromotionList();
        cart = new Cart(wantsToBuyList);
        cart.formatItem(promotionList);
        purchasedList = cart.getPurchasedList();

        StringBuilder sb = new StringBuilder("买二赠一商品:\n");
        sb.append("名称:可口可乐,数量:1瓶\n");
        sb.append("名称:羽毛球,数量:1个\n");
        sb.append("----------------------\n");
        assertThat(cart.printPromotionList("BUY_TWO_GET_ONE_FREE"),is(sb.toString()));
    }

    @Test
    public void shouldNotPrintPromotionListWhenBuyPromotionItem() throws Exception {
        OnSaleInf onSaleInf = new OnSaleInf();
        List<Promotion> promotionList = onSaleInf.getPromotionList();
        cart = new Cart(wantsToBuyList);
        cart.formatItem(promotionList);
        purchasedList = cart.getPurchasedList();
        StringBuilder sb = new StringBuilder();
        assertThat(cart.printPromotionList("BUY_TWO_GET_ONE_FREE"),is(sb.toString()));
    }

    @Test
    public void shouldPrintPayInfWithSaveWhenBuyFivePercentPromotionItem() throws Exception {
        DecimalFormat df   = new DecimalFormat("######0.00");
        StringBuilder sb = new StringBuilder();
        sb.append("总计:23.55(元)\n");
        sb.append("节省:1.45(元)\n");
        sb.append("**********************\n");
        assertThat(cart.printPayInf(),is(sb.toString()));
    }

    @Test
    public void shouldNotPrintPayInfWithSaveWhenBuyItemIsNotFivePercentPromotion() throws Exception {
        OnSaleInf onSaleInf = new OnSaleInf();
        onSaleInf.addPromotion("ITEM000003-","BUY_TWO_GET_ONE_FREE");
        List<Promotion> promotionList = onSaleInf.getPromotionList();
        cart = new Cart(wantsToBuyList);
        cart.formatItem(promotionList);
        purchasedList = cart.getPurchasedList();

        DecimalFormat df   = new DecimalFormat("######0.00");
        StringBuilder sb = new StringBuilder();
        sb.append("总计:25.00(元)\n");
        sb.append("**********************\n");
        assertThat(cart.printPayInf(),is(sb.toString()));
    }

}
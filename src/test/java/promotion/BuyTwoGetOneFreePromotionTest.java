package promotion;

import goods.Goods;
import goods.GoodsMap;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BuyTwoGetOneFreePromotionTest {
    private BuyTwoGetOneFreePromotion promotion = new BuyTwoGetOneFreePromotion();
    private HashMap<String, Goods> map = GoodsMap.getMap();

    @Before
    public void setUp() throws Exception {
        promotion.addPromotionItem("ITEM000001");    //羽毛球
        promotion.addPromotionItem("ITEM000005");    //可口可乐

    }

    @Test
    public void shouldGetItemsFreeWhenTheNumberOfPromotionItemsIsMoreThanTwo() throws Exception {
        double price = promotion.getPrice(map.get("ITEM000001"),6);
        assertThat(price,is(4.00));
    }

    @Test
    public void shouldNotGetItemsFreeWhenTheNumberOfPromotionItemsIsLessThanTwo() throws Exception {
        double price = promotion.getPrice(map.get("ITEM000001"),1);
        assertThat(price,is(1.00));
    }

    @Test
    public void shouldNotGetItemsFreeWhenTheItemsIsNotPromotion() throws Exception {
        double price = promotion.getPrice(map.get("ITEM000003-"),2);
        assertThat(price,is(11.00));
    }
}
package promotion;

import goods.Goods;
import goods.GoodsMap;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NinetyFiveDiscountPromotionTest {
    NinetyFiveDiscountPromotion promotion = new NinetyFiveDiscountPromotion();
    HashMap<String, Goods> map = GoodsMap.getMap();

    @Before
    public void setUp() throws Exception {
        promotion.addPromotionItem("ITEM000003-"); //苹果

    }

    @Test
    public void shouldGetNinetyFiveDiscountWhenTheItemIsPromotion() throws Exception {
        double price = promotion.getPrice(map.get("ITEM000003-"),2);
        assertThat(price,is(10.45));
    }

    @Test
    public void shouldNotGetNinetyFiveDiscountWhenTheItemIsNotPromotion() throws Exception {
        double price = promotion.getPrice(map.get("ITEM000001"),1);
        assertThat(price,is(1.00));
    }
}
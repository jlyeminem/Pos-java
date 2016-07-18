package promotion;

import cart.Item;
import onsale.BuyTwoGetOneFreeGoodsList;
import onsale.NinetyFiveDiscountGoodsList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PromotionFactoryTest {
    private List<String> goodsList;
    @Before
    public void setUp() throws Exception {
        goodsList= new ArrayList<>();
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000003-2");
        goodsList.add("ITEM000005");
        goodsList.add("ITEM000005");
        goodsList.add("ITEM000000");
        goodsList.add("ITEM000006");
        goodsList.add("ITEM000006");
        goodsList.add("ITEM000006");
        goodsList.add("ITEM000002");
        BuyTwoGetOneFreeGoodsList.addPromotionItem("ITEM000000");
        NinetyFiveDiscountGoodsList.addPromotionItem("ITEM000000");
        BuyTwoGetOneFreeGoodsList.addPromotionItem("ITEM000006");
        NinetyFiveDiscountGoodsList.addPromotionItem("ITEM000006");
    }

    @Test
    public void shouldListLength() throws Exception {
        List<Item> items = PromotionFactory.solveItems(goodsList);
        assertThat(items.size(),is(6));
    }

    @Test
    public void shouldGetPrice() throws Exception {
        List<Item> items = PromotionFactory.solveItems(goodsList);
        double allPrice = 0;
        double realPrice = 0;
        for(Item item : items) {
            allPrice += item.getPrice();
            realPrice += item.getPromotedPrice();
        }
        double price = Double.parseDouble(String.format("%.2f",allPrice - realPrice));
        assertThat(price,is(16.55));
    }
}
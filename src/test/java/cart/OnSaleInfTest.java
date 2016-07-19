package cart;

import org.junit.Before;
import org.junit.Test;
import promotion.BuyTwoGetOneFreePromotion;
import promotion.NinetyFiveDiscountPromotion;
import promotion.Promotion;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by sunnior on 7/19/16.
 */
public class OnSaleInfTest {
    List<Promotion> promotionList;
    OnSaleInf onSaleInf = new OnSaleInf();

    @Before
    public void setUp() throws Exception {
        onSaleInf.addPromotion("ITEM000005","FIVE_PERCENT_DISCOUNT");
        onSaleInf.addPromotion("ITEM000003-","FIVE_PERCENT_DISCOUNT");
        onSaleInf.addPromotion("ITEM000005","BUY_TWO_GET_ONE_FREE");
        onSaleInf.addPromotion("ITEM000001","BUY_TWO_GET_ONE_FREE");
    }

    @Test
    public void shouldGetPromotionListWhenBuyPromotionItem() throws Exception {

        promotionList = onSaleInf.getPromotionList();
        assertThat(promotionList.size(),is(2));

        BuyTwoGetOneFreePromotion promotion0 = (BuyTwoGetOneFreePromotion) promotionList.get(0);
        assertThat(promotion0.getType(),is("BUY_TWO_GET_ONE_FREE"));
        assertThat(promotion0.isContain("ITEM000005"),is(true));
        assertThat(promotion0.isContain("ITEM000001"),is(true));

        NinetyFiveDiscountPromotion promotion1 = (NinetyFiveDiscountPromotion) promotionList.get(1);
        assertThat(promotion1.getType(),is("FIVE_PERCENT_DISCOUNT"));
        assertThat(promotion1.isContain("ITEM000003-"),is(true));
    }
}
package goods;

import cart.CartItems;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class CartItemsTest {
    private CartItems cartItems;

    @Before
    public void setUp() throws Exception {
        List<String> goodsList= new ArrayList<>();
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000001");
        goodsList.add("ITEM000003-2");
        goodsList.add("ITEM000005");
        goodsList.add("ITEM000005");
        goodsList.add("ITEM000005");
        cartItems = new CartItems(goodsList);
    }

    @Test
    public void shouldOneItemOneNum() throws Exception {
        int num = cartItems.getCartItems().get("ITEM000001");
        assertThat(num, is(5));
    }

    @Test
    public void shouldOneItemMoreThanOneNum() throws Exception {
        int num = cartItems.getCartItems().get("ITEM000003");
        assertThat(num, is(2));
    }

    @Test
    public void shouldAddNumToHashMap() throws Exception {
        int num = cartItems.getCartItems().get("ITEM000005");
        assertThat(num,is(3));
    }
}
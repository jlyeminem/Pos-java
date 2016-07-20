package goods;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class GoodsMapTest {

    @Test
    public void shouldAddGoods() throws Exception {
        GoodsMap.addGoods(new Goods("ITEM000008","电风扇","个",35,"生活用品"));
        assertThat(GoodsMap.getMap().containsKey("ITEM000008"),is(true));
    }

    @Test
    public void shouldRemoveGoods() throws Exception {
        GoodsMap.removeGoods("ITEM000000");
        assertThat(GoodsMap.getMap().containsKey("ITEM000000"),is(false));
    }

    @Test (expected = Exception.class)
    public void shouldRemoveWrongGoods() throws Exception {
        GoodsMap.removeGoods("ITEM000010");
    }

    @Test
    public void shouldAddAllGoods() throws Exception {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods("ITEM000008","电风扇","个",35,"生活用品"));
        goodsList.add(new Goods("ITEM000009","牙刷","个",15,"生活用品"));
        GoodsMap.addAllGoods(goodsList);
        assertThat(GoodsMap.getMap().containsKey("ITEM000009") && GoodsMap.getMap().containsKey("ITEM000008"),is(true));

    }

}
package utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParseUtilsTest {
    @Test
    public void shouldGetOneItemWhenBarcodeIsLegal() throws Exception {
        int number = ParseUtils.parseBarcode("ITEM000001");
        assertThat(number, is(1));
    }

    @Test
    public void shouldGetItemsWhenBarcodeWithACross() throws Exception {
        int number = ParseUtils.parseBarcode("ITEM000003-3");
        assertThat(number,is(3));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenBarcodeWithoutACross() throws Exception {
        ParseUtils.parseBarcode("ITEM000001-3");   //ITEM000001不是带'-'的条形码
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenNumberOfItemIsIllegal() throws Exception {
        ParseUtils.parseBarcode("ITEM000003-ju");   //ju不是有效的数量信息
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenBarcodeIsIllegal() throws Exception {
        ParseUtils.parseBarcode("pos");            //pos不是有效地条形码
    }
}
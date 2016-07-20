package utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParseUtilsTest {

    @Test
    public void shouldGetBarcodeWhenBarcodeWithACross() throws Exception {
        String barcode = ParseUtils.parseItemBarcode("ITEM000003-3");
        assertThat(barcode,is("ITEM000003-"));
        assertThat(ParseUtils.parseBarcode("ITEM000003-3"),is(3));
    }

    @Test
    public void shouldGetBarcodeWhenBarcodeWithoutACross() throws Exception {
        String barcode = ParseUtils.parseItemBarcode("ITEM000001");
        assertThat(barcode,is("ITEM000001"));
        assertThat(ParseUtils.parseBarcode("ITEM000001"),is(1));
    }

    @Test
    public void shouldGetItemsWhenBarcodeWithACross() throws Exception {
        int number = ParseUtils.parseBarcode("ITEM000003-2");
        assertThat(number,is(2));
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
        ParseUtils.parseBarcode("pos");            //pos不是有效的条形码
    }

    @Test
    public void shouldParseAppleBarcode() throws Exception {
        String barcode = ParseUtils.parseItemBarcode("ITEM000003-2");
        assertThat(barcode, is("ITEM000003-"));
    }

    @Test
    public void shouldParseCocoBarcode() throws Exception {
        String barcode = ParseUtils.parseItemBarcode("ITEM000005");
        assertThat(barcode, is("ITEM000005"));
        assertThat(ParseUtils.parseBarcode("ITEM000005"),is(1));
    }
}
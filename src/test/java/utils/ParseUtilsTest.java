package utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by jly on 16-7-17.
 */
public class ParseUtilsTest {
    @Test
    public void shouldGetOneItem() throws Exception {
        int number = ParseUtils.parse("ITEM000001");
        assertThat(number, is(1));
    }

    @Test
    public void shouldGetItems() throws Exception {
        int number = ParseUtils.parse("ITEM000003-3");
        assertThat(number,is(3));
    }

    @Test(expected = Exception.class)
    public void shouldGetAppleItems() throws Exception {
        ParseUtils.parse("jijijijiji-3");
    }

    @Test(expected = Exception.class)
    public void shouldGetNotAppleItems() throws Exception {
        ParseUtils.parse("ITEM000003-ju");
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenBarcodeIsIllegal() throws Exception {
        ParseUtils.parse("ijlsdajf");
    }
}
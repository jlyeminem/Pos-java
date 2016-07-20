package utils;

import org.junit.Test;


import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class JsonUtilsTest {
    @Test
    public void shouldParseList() throws Exception {
        String string  = "[\n" + "\n"
                + "    'ITEM000001',\n" + "\n" + "    'ITEM000001',\n" + "\n"
                + "    'ITEM000001',\n" + "\n" + "    'ITEM000001',\n" + "\n"
                + "    'ITEM000001',\n" + "\n" + "    'ITEM000003-2',\n" + "\n" + "    'ITEM000005',\n" + "\n"
                + "    'ITEM000005',\n" + "\n" + "    'ITEM000005'\n" + "\n" + "]";
        List<String> list= JsonUtils.parseJsonString(string);
        assertThat(list.contains("ITEM000001"),is(true));
    }
}
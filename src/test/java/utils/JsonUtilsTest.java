package utils;

import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by jly on 16-7-20.
 */
public class JsonUtilsTest {
    private String string = "[\n" +
            "\n" +
            "    'ITEM000001',\n" +
            "\n" +
            "    'ITEM000001',\n" +
            "\n" +
            "    'ITEM000001',\n" +
            "\n" +
            "    'ITEM000001',\n" +
            "\n" +
            "    'ITEM000001',\n" +
            "\n" +
            "    'ITEM000003-2',\n" +
            "\n" +
            "    'ITEM000005',\n" +
            "\n" +
            "    'ITEM000005',\n" +
            "\n" +
            "    'ITEM000005'\n" +
            "\n" +
            "]";

    @Test
    public void shouldParseList() throws Exception {
        List<String> list= JsonUtils.parseJsonString(string);
        assertThat(list.contains("ITEM000001"),is(true));
    }
}
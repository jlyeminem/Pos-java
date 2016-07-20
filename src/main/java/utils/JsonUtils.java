package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;


import java.lang.reflect.Type;
import java.util.List;


public class JsonUtils {
    public static List<String> parseJsonString(String str) {
        String jsonStr = str;
        Type type = new TypeReference<List<String>>() {}.getType();
        List<String> list = JSON.parseObject(jsonStr, type);
        return list;
    }
}

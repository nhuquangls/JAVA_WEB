package org.example.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static final Map<String, String> dic = new HashMap<>();
    static {
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
    }
    public static String getValue(String key) {
        return dic.get(key);
    }
}

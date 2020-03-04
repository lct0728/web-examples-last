package com;

import java.util.HashMap;
import java.util.Map;

public class CodeService {
    static Map<String,String> map=new HashMap<>();
    static {
        map.put("150036", "黑龙江，哈尔滨");
        map.put("100000", "北京，北京");
    }
    public static String getCode(String key){
        if(map.containsKey(key)){
            return map.get(key);
        }else {
            return "null，null";
        }
    }

}

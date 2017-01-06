package com.lcc.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcc on 2017/1/6.
 */
public class StringUtil {

    /**
     * 判断之间是否为空
     */
    public static boolean isEmpty(String str){
        if (str == null || "".equals(str.trim())){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断不为空
     */
    public static boolean isNotEmpty(String str){
        if((str != null) && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public static String formatLike(String str) {
        if(isNotEmpty(str)) {
            return "%" + str + "%";
        } else {
            return null;
        }
    }

    public static List<String> filterWhite(List<String> list) {
        List<String> resultList = new ArrayList<String>();
        for(String l : list) {
            if(isNotEmpty(l)) {
                resultList.add(l);
            }
        }
        return resultList;
    }
}

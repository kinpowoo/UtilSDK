package com.jinhanyu.kinpowoo.android_utils.date_util;

import java.lang.reflect.Method;  
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Locale;

/** 
 * java bean 反射的方法 
 * @author Michael 
 */  
public class TimeRevert {
    /** 
     * 格式化string为Date 
     * @param datestr 
     * @return date 
     */  
    public static Date parseDate(String datestr) {  
        if (null == datestr || "".equals(datestr)) {  
            return null;  
        }  
        try {  
            String fmtstr = null;  
            if (datestr.indexOf(':') > 0) {  
                fmtstr = "yyyy-MM-dd HH:mm:ss";  
            } else {  
  
                fmtstr = "yyyy-MM-dd";  
            }  
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);  
            return sdf.parse(datestr);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
    /** 
     * 日期转化为String 
     * @param date 
     * @return date string 
     */  
    public static String formatDate(Date date) {
        if (null == date) {  
            return null;  
        }  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",  
                    Locale.US);  
            return sdf.format(date);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
    /** 
     * 判断是否存在某属性的 set方法 
     * @param methods 
     * @param fieldSetMet 
     * @return boolean 
     */  
    public static boolean checkSetMet(Method[] methods, String fieldSetMet) {  
        for (Method met : methods) {  
            if (fieldSetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false;  
    }  
  
    /** 
     * 判断是否存在某属性的 get方法 
     * @param methods 
     * @param fieldGetMet 
     * @return boolean 
     */  
    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {  
        for (Method met : methods) {  
            if (fieldGetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false;  
    }  
  
    /** 
     * 拼接某属性的 get方法 
     * @param fieldName 
     * @return String 
     */  
    public static String parGetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        return "get" + fieldName.substring(0, 1).toUpperCase()  
                + fieldName.substring(1);  
    }  
  
    /** 
     * 拼接在某属性的 set方法 
     * @param fieldName 
     * @return String 
     */  
    public static String parSetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        return "set" + fieldName.substring(0, 1).toUpperCase()  
                + fieldName.substring(1);  
    }
}  
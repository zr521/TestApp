package com.example.test.util;

/**
 * 判断String是否isEmpty
 */
public class StringUtils {
    //为空
    public static boolean isEmpty(String string){
        if(string==null || string.length()<=0){
            return true;
        }else {
            return false;
        }
    }
    //大于指定输入
    public static boolean isGreater_user(String string){
        if( string.equals("admin")){
            return false;
        }else {
            return true;
        }
    }
    public static boolean isGreater_passwd(String string){
        if( string.equals("111")){
            return false;
        }else {
            return true;
        }
    }
    public static boolean isAll(String string1,String string2){
        if(string1.equals("admin")&&string2.equals("111")){
            return false;
        }else {
            return true;
        }
    }
}

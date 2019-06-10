package com.fyf.meijiayi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 格式化日期
 */
public class FormatDate {

    /**
     * data 转化指定格式字符
     * @param format
     * @param date
     * @return
     */
    public static String getData(String format, Date date){
        DateFormat simpleDateFormat = new SimpleDateFormat(format);
        String formatdate = simpleDateFormat.format(date);
        return formatdate;
    }


    public static Date getDate(String format){
        DateFormat simpleDateFormat = new SimpleDateFormat(format);
        try{
            Date parse = simpleDateFormat.parse(format);
            return parse;
        }catch (Exception e){
            throw new RuntimeException("转换失败");
        }
    }
}

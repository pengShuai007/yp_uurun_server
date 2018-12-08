package com.pengshuai.uurun.common.utils;

import com.pengshuai.uurun.common.constants.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YangPeng on 2018/12/8.
 */
public class DateUtil {
    public static String formatDate(Date date, Constants.DATE_PATTERN datePattern){
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern.getValue());
        return sdf.format(date);
    }
}

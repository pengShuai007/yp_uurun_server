package com.pengshuai.school;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by YangPeng on 2019/3/8.
 */
public class Test {

    public static void main(String args[]){
        LocalDate today2 = LocalDate.now();
        LocalDate endDate2 = today2.minusDays(5);
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = df.format(today);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 5);
        Date start_date =  calendar.getTime();
        String startDate = df.format(start_date);
        System.out.println("1-----s:" + startDate);
        System.out.println("1-----e:" + endDate);
        System.out.println("12-----s:" + today2);
        System.out.println("12-----e:" + endDate2);
    }
}

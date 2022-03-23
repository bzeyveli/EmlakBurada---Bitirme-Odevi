package com.patika.emlakburada.model.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductsDateFormatter {

    public static final String MM_DD_YY = "ddMMyy";

    public static String format() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(MM_DD_YY);
        return dateFormat.format(new Date());
    }

    // 30 gün sonrasının tarihini buluyor
    public static Date AfterAmountDateFormat(Date now) {
        long oneDayLongValue = 1000 * 60 * 60 * 24;
        Date afterFiveDays = new Date(now.getTime() + (30 * oneDayLongValue)); // 30 gün sonrası
        return afterFiveDays;
    }
}

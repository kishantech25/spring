package com.job.primitves;

import java.math.BigDecimal;

public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal c = new BigDecimal("0.3");
        BigDecimal d = new BigDecimal("0.4");

        BigDecimal result = a.add(b).add(c).add(d);
        System.out.println(result);
    }


}

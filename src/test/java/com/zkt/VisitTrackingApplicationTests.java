package com.zkt;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class VisitTrackingApplicationTests {

    @Test
    void contextLoads() {
        DateTime dateTime = DateUtil.offsetHour(DateUtil.beginOfDay(DateUtil.date()), 2);
//        DateTime dateTime1 = DateUtil.endOfDay(DateUtil.offsetHour(DateUtil.date(), 1));
//        System.out.println(dateTime);
        System.out.println(dateTime);
    }

}

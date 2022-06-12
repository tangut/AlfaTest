package com.utls;

import com.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void testGetYesterdayString() {
        String str = DateUtils.getYesterdayDateString();
        Assertions.assertNotNull(str);
        LocalDate now = LocalDate.now();
        LocalDate yesterday = LocalDate.parse(str);
        Assertions.assertTrue(now.minusDays(1l).equals(yesterday));
    }
}

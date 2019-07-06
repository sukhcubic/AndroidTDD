package com.example.notetaking.util;

import org.junit.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static com.example.notetaking.util.DateUtil.GET_MONTH_ERROR;
import static com.example.notetaking.util.DateUtil.getMonthFromNumber;
import static com.example.notetaking.util.DateUtil.monthNumbers;
import static com.example.notetaking.util.DateUtil.months;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilTest {

    private static final String today = "07-2019";

    @Test
    public void testGetCurrentTimestamp(){

        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                assertEquals(today, DateUtil.getCurrentTimeStamp());
                System.out.println("Timestamp is generated");

            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 4, 5,6,7,8,9, 10 })
    public void getMonth(int month, TestInfo testInfo, TestReporter testReporter){
        assertEquals(months[month], getMonthFromNumber(monthNumbers[month]));
        System.out.println("Month test passed" + monthNumbers[month] + ":" +months[month] );
    }

//    @ParameterizedTest
//    @CsvSource()
//    public void getMonth(int month, TestInfo testInfo, TestReporter testReporter){
//
//    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11})
    public void testGetMonthFromNumber_returnError(int monthNumber, TestInfo testInfo, TestReporter testReporter){
        int randomInt = new Random().nextInt(90) + 13;
        assertEquals(getMonthFromNumber(String.valueOf(monthNumber * randomInt)), GET_MONTH_ERROR);
        System.out.println(monthNumbers[monthNumber] + " : " + GET_MONTH_ERROR);
    }
}

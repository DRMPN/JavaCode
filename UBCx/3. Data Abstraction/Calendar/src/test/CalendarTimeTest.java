package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import other.CalendarTime;

public class CalendarTimeTest {

    CalendarTime testCT;

    @Before
    public void setUp() {
        testCT = new CalendarTime(12,12,true);
    }

    @Test
    public void testGetters(){
        Assert.assertEquals(testCT.getHours(),12);
        Assert.assertEquals(testCT.getMinutes(),12);
    }

    @Test
    public void testGetTime() {
        Assert.assertEquals(testCT.getTime(),"12:12 am");
    }
}

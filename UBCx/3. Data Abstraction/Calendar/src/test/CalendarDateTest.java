package test;

import org.junit.Before;
import org.junit.Test;
import other.CalendarDate;

import static org.junit.Assert.assertEquals;

public class CalendarDateTest {

    public CalendarDate testCD;

    @Before
    public void setUp() {
        testCD = new CalendarDate(12,12,2012);
    }

    @Test
    public void testGetters() {
        assertEquals(testCD.getDay(),12);
        assertEquals(testCD.getMonth(),12);
        assertEquals(testCD.getYear(),2012);
    }

    @Test
    public void testGetShortDate() {
       assertEquals(testCD.getShortDate(),"12/12/2012");
    }

    @Test
    public void testGetLongDate() {
        assertEquals(testCD.getLongDate(),"12 December 2012");
    }
}

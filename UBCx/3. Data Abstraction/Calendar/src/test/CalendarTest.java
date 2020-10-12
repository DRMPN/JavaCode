package test;

import model.Calendar;
import model.Event;
import model.Meeting;
import model.Reminder;
import org.junit.Before;
import org.junit.Test;
import other.CalendarDate;
import other.CalendarTime;

import static org.junit.Assert.assertEquals;

public class CalendarTest {

   private CalendarDate earlyDate;
   private CalendarDate middleDate;
   private CalendarDate latestDate;

   private CalendarTime earlyTime;
   private CalendarTime middleTime;
   private CalendarTime latestTime;

   private Calendar testCalendar;

   private Reminder testReminder;
   private Event testEvent;
   private Meeting testMeeting;

    @Before
    public void setUp() {
        earlyDate = new CalendarDate(10,10,2010);
        middleDate = new CalendarDate(11,11,2011);
        latestDate = new CalendarDate(12,12,2012);

        earlyTime = new CalendarTime(10,10,true);
        middleTime = new CalendarTime(11,11,true);
        latestTime = new CalendarTime(12,12,true);

        testCalendar = new Calendar(earlyDate,"calendarEmail@mail.me");

        testReminder = new Reminder(earlyDate,earlyTime,"Reminder");
        testEvent = new Event(middleDate,middleTime,"Event");
        testMeeting = new Meeting(latestDate,latestTime,"Meeting");

        testCalendar.addCalendarEntry(testReminder);
        testCalendar.addCalendarEntry(testEvent);
        testCalendar.addCalendarEntry(testMeeting);
    }

    @Test
    public void testListAddition() {
        assertEquals(testCalendar.getCalendarEntries().size(),3);
        testCalendar.removeCalendarEntry(testReminder);
        assertEquals(testCalendar.getCalendarEntries().size(),2);
    }

    @Test
    public void testGetSoonestEntry() {
        assertEquals(testCalendar.getSoonestEntry(), "The soonest entry is: Reminder -- 10/10/2010");
    }

    @Test
    public void testCalendarIntervals() {
        testReminder.setInterval(1,0,0);
        testEvent.setInterval(0,6,0);
        testMeeting.setInterval(0,0,30);

        assertEquals(testReminder.getInterval(),"is on repeat every: 1 day(s), 0 hour(s), 0 minute(s)");
        assertEquals(testEvent.getInterval(),"is on repeat every: 0 day(s), 6 hour(s), 0 minute(s)");
        assertEquals(testMeeting.getInterval(),"is on repeat every: 0 day(s), 0 hour(s), 30 minute(s)");
    }

    @Test
    public void testMeeting() {
        testMeeting.addAttendee("1stAttendee@mail.com");
        testMeeting.addAttendee("2stAttendee@mail.com");
        testMeeting.addAttendee("3stAttendee@mail.com");
        assertEquals(testMeeting.getListOfAttendees().size(), 3);
        testMeeting.removeAttendee("2stAttendee@mail.com");
        testMeeting.sendInvitations();
    }

    @Test
    public void testReminder() {
        testEvent.setRemindOnDate(latestDate);
        testEvent.setRemindOnTime(latestTime);
        testEvent.addNote("Remember to do it!");
        assertEquals(testEvent.getTime().getTime(),"11:11 am");
        assertEquals(testEvent.getNote(),"Remember to do it!" );
    }
}

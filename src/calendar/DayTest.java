package calendar;

import student.TestCase;

public class DayTest
    extends TestCase
{
    // ~ Fields ................................................................
    Event allDay;
    Event timedFirst;
    Event timedSecond;
    Day today;

    // ~ Set Up ..........................................................
    public void setUp()
    {
        allDay = new Event("All Day", "Here", true);
        timedFirst = new TimedEvent(
            "Yoga",
            "Gym",
            true,
            new Time(11, 30, true),
            new Time(1, 30, false));
        timedSecond = new TimedEvent(
            "Birthday",
            "Home",
            true,
            new Time(5, 30, false),
            new Time(7, 45, false));
        today = new Day(22);
    }


    // ~Test Methods ........................................................
    public void testAddEvent()
    {
        assertEquals("", today.toString());

        today.addEvent(timedSecond);
        assertEquals(1, today.getListOfEvents().size());
        assertEquals("Birthday at Home from 5:30-7:45\n", today.toString());

        today.addEvent(allDay);
        assertEquals(2, today.getListOfEvents().size());
        assertEquals(
            "Birthday at Home from 5:30-7:45\nAll Day at Here\n",
            today.toString());

        today.addEvent(timedFirst);
        assertEquals(3, today.getListOfEvents().size());
        assertEquals(
            "Yoga at Gym from 11:30-1:30\nBirthday at Home from 5:30-7:45\nAll Day at Here\n",
            today.toString());
    }
}

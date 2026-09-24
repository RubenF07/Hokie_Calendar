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
        allDay = new Event("Mother's Day", "This is all day", "Here", true);
        timedFirst = new TimedEvent(
            "Yoga",
            "Weekly Class",
            "Gym",
            true,
            new Time(11, 30, true),
            new Time(1, 30, false));
        timedSecond = new TimedEvent(
            "Birthday",
            "Mom's turning 40",
            "Home",
            true,
            new Time(5, 30, false),
            new Time(7, 45, false));
        today = new Day(22);
    }


    // ~Test Methods ........................................................
    // ----------------------------------------------------------
    /**
     * test addEvent()
     */
    public void testAddEvent()
    {
        assertEquals("", today.toString());

        today.addEvent(timedSecond);
        assertEquals(1, today.getListOfEvents().size());
        assertEquals("Birthday at 5:30 PM\n", today.toString());

        today.addEvent(allDay);
        assertEquals(2, today.getListOfEvents().size());
        assertEquals("Birthday at 5:30 PM\nMother's Day\n", today.toString());

        today.addEvent(timedFirst);
        assertEquals(3, today.getListOfEvents().size());
        assertEquals(
            "Yoga at 11:30 AM\nBirthday at 5:30 PM\nMother's Day\n",
            today.toString());
    }
}

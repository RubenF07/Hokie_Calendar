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
        allDay = new Event("All Day", "This is all day", "Here", true);
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
        assertEquals("Date: 22\n", today.toString());

        today.addEvent(timedSecond);
        assertEquals(1, today.getListOfEvents().size());
        assertEquals(
            "Date: 22\nBirthday\nMom's turning 40\nat Home\n5:30 PM-7:45 PM\n",
            today.toString());

        today.addEvent(allDay);
        assertEquals(2, today.getListOfEvents().size());
        assertEquals(
            "Date: 22\nBirthday\nMom's turning 40\nat Home\n5:30 PM-7:45 PM\nAll Day\nThis is all day\nat Here\n",
            today.toString());

        today.addEvent(timedFirst);
        assertEquals(3, today.getListOfEvents().size());
        assertEquals(
            "Date: 22\nYoga\nWeekly Class\nat Gym\n11:30 AM-1:30 PM\nBirthday\nMom's turning 40\nat Home\n5:30 PM-7:45 PM\nAll Day\nThis is all day\nat Here\n",
            today.toString());
    }
}

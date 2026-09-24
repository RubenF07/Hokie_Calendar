package calendar;

import student.TestCase;

public class TimeTest extends TestCase {
    private Time amEarly;
    private Time amLate;
    private Time amSame;
    private Time pmEarly;

    public void setUp() {
        amEarly = new Time(9, 15, true);
        amLate  = new Time(11, 30, true);
        amSame  = new Time(9, 15, true);
        pmEarly = new Time(5, 0, false);
    }

    public void testCompareTo() {
        assertEquals(1, amEarly.compareTo(pmEarly));
        assertEquals(-1, pmEarly.compareTo(amEarly));
        assertEquals(1, amEarly.compareTo(amLate));
        assertEquals(-1, amLate.compareTo(amEarly));
        assertEquals(0, amEarly.compareTo(amSame));

        Time amMiddle = new Time(9, 45, true);
        assertEquals(1, amEarly.compareTo(amMiddle));
        assertEquals(-1, amMiddle.compareTo(amEarly));
    }
}
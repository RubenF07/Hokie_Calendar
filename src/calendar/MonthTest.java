package calendar;

import student.TestCase;

public class MonthTest
    extends TestCase
{
    // ~ Fields ................................................................
    Calendar myCalendar;
    Month[] allMonths;
    Month august;
    Month september;
    Month october;
    Month november;
    Month december;
    Month january;
    Month february;
    Month march;
    Month april;
    Month may;

    // ~ SetUp ..........................................................
    public void setUp()
    {
        myCalendar = new Calendar();
        allMonths = myCalendar.getYear();
        august = allMonths[0];
        september = allMonths[1];
        october = allMonths[2];
        november = allMonths[3];
        december = allMonths[4];
        january = allMonths[5];
        february = allMonths[6];
        march = allMonths[7];
        april = allMonths[8];
        may = allMonths[9];
    }


    // ~Public Methods ........................................................
    public void testGetStartWeekDay()
    {
        assertEquals("Saturday", august.getStartWeekDay());
        assertEquals("Tuesday", september.getStartWeekDay());
        assertEquals("Thursday", october.getStartWeekDay());
        assertEquals("Sunday", november.getStartWeekDay());
        assertEquals("Tuesday", december.getStartWeekDay());
        assertEquals("Friday", january.getStartWeekDay());
        assertEquals("Monday", february.getStartWeekDay());
        assertEquals("Monday", march.getStartWeekDay());
        assertEquals("Thursday", april.getStartWeekDay());
        assertEquals("Saturday", may.getStartWeekDay());
    }
}

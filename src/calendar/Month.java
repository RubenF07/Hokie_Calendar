package calendar;

/**
 * Creates a day object that contains and manages events for a specific day
 * 
 * @author Sarah
 * @version Sep 17, 2026
 */
public class Month
{
    // ~ Fields ................................................................
    private String monthName;
    private int numDays;
    private String startWeekDay;
    private Day[] entireMonth;

    // ----------------------------------------------------------
    /**
     * Create a new Month object.
     * 
     * @param monthName
     * @param numDays
     * @param startWeekDay
     */
    // ~ Constructors ..........................................................
    public Month(String monthName, int numDays, String startWeekDay)
    {
        this.monthName = monthName;
        this.numDays = numDays;
        this.startWeekDay = startWeekDay;

        entireMonth = new Day[numDays];
        for (int i = 0; i < numDays; i++) {
            entireMonth[i] = new Day(i + 1);
        }
    }


    // ----------------------------------------------------------
    // ~Public Methods ........................................................
    /**
     * get the name of the month
     * 
     * @return monthName
     */
    public String getMonth()
    {
        return monthName;
    }


    // ----------------------------------------------------------
    /**
     * get the number of days in the month
     * 
     * @return numDays
     */
    public int getNumDays()
    {
        return numDays;
    }


    // ----------------------------------------------------------
    /**
     * get the day of the week the first day of the month occurs
     * 
     * @return startWeekDay
     */
    public String getStartWeekDay()
    {
        return startWeekDay;
    }


    // ----------------------------------------------------------
    /**
     * Gets the entire month's worth of days
     * 
     * @return day array
     */
    public Day[] getDays()
    {
        return entireMonth;
    }


    public String toString()
    {
        String monthArrayString = "";
        for (int i = 0; i < numDays; i++)
        {
            monthArrayString += (entireMonth[i]).getDate() + " ";
        }
        return monthArrayString;
    }
}

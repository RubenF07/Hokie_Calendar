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
     * Place a description of your method here.
     * 
     * @param dayNumber:
     *            nth of the month
     * @return specific Day from month array
     */
    public Day getDay(int dayNumber)
    {
        return entireMonth[dayNumber - 1];
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

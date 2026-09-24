package calendar;

/**
 * A 12-hour clock time with an am/pm marker.
 */
public class Time {
    private int hour;
    private int minute;
    private Boolean am;

    /**
     * Creates a time.
     *
     * @param hour
     *            the hour (1-12)
     * @param minute
     *            the minute (0-59)
     * @param am
     *            true for am, false for pm
     */
    public Time(int hour, int minute, Boolean am) {
        this.hour = hour;
        this.minute = minute;
        this.am = am;
    }


    /**
     * Formats the time like 03:12pm.
     *
     * @return the formatted time
     */
    @Override
    public String toString() {
        String am_pm;
        if (am) {
            am_pm = "am";
        }
        else {
            am_pm = "pm";
        }
        return String.format("%02d:%02d%s", hour, minute, am_pm);
    }


    /**
     * Compares this time to another.
     *
     * @param t
     *            the time to compare to
     * @return 1 if t is later, -1 if t is earlier, 0 if equal
     */
    public int compareTo(Time t) {
        return Integer.compare(t.toMinutes(), this.toMinutes());
    }


    /**
     * Converts this time to minutes since midnight.
     *
     * @return the minutes since midnight
     */
    private int toMinutes() {
        return (hour % 12) * 60 + minute + (am ? 0 : 12 * 60);
    }
}

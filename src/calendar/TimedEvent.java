package calendar;

/**
 * An event with a start time and an end time.
 */
public class TimedEvent extends Event {
    private Time startTime;
    private Time endTime;

    /**
     * Creates a timed event.
     *
     * @param title
     *            the event title
     * @param description
     *            the event description
     * @param location
     *            the event location
     * @param mutable
     *            true if the event can be edited
     * @param startTime
     *            the start time
     * @param endTime
     *            the end time
     */
    public TimedEvent(
        String title,
        String description,
        String location,
        Boolean mutable,
        Time startTime,
        Time endTime) {
        super(title, description, location, mutable);
        this.startTime = startTime;
        this.endTime = endTime;
    }


    /**
     * Gets the start time.
     *
     * @return the start time
     */
    public Time getStart() {
        return startTime;
    }


    /**
     * Sets the start time.
     *
     * @param newStartTime
     *            the new start time
     */
    public void setStart(Time newStartTime) {
        startTime = newStartTime;
    }


    /**
     * Gets the end time.
     *
     * @return the end time
     */
    public Time getEnd() {
        return endTime;
    }


    /**
     * Sets the end time.
     *
     * @param newEndTime
     *            the new end time
     */
    public void setEnd(Time newEndTime) {
        endTime = newEndTime;
    }


    /**
     * Describes the event followed by its start and end times.
     *
     * @return the event as a string
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + startTime + "-" + endTime;
    }
}

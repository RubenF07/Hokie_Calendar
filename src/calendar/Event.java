package calendar;

/**
 * An all-day calendar event with a title, description, and location.
 */
public class Event {
    private String title;
    private String description;
    private String location;
    private Boolean mutable;

    /**
     * Creates an event.
     *
     * @param title
     *            the event title
     * @param description
     *            the event description
     * @param location
     *            the event location
     * @param mutable
     *            whether the event can be edited or removed
     */
    public Event(
        String title,
        String description,
        String location,
        Boolean mutable) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.mutable = mutable;
    }


    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets the title.
     *
     * @param newTitle
     *            the new title
     */
    public void setTitle(String newTitle) {
        title = newTitle;
    }


    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description.
     *
     * @param newDesc
     *            the new description
     */
    public void setDescription(String newDesc) {
        description = newDesc;
    }


    /**
     * Gets the location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }


    /**
     * Sets the location.
     *
     * @param newLocation
     *            the new location
     */
    public void setLocation(String newLocation) {
        location = newLocation;
    }


    /**
     * Checks whether the event can be edited or removed.
     *
     * @return true if the event is mutable
     */
    public boolean getMutability() {
        return mutable;
    }


    /**
     * Returns the event as text: title, description, and location if set.
     *
     * @return the event as a string
     */
    @Override
    public String toString() {
        String res = title + "\n" + description;
        if (!location.equals("")) {
            res += "\nat " + location;
        }
        return res;
    }
}

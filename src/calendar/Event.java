package calendar;

public class Event {
    private String title;
    private String location;
    private Boolean mutable;

    public Event(String title, String location, Boolean mutable) {
        this.title = title;
        this.location = location;
        this.mutable = mutable;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String newLocation) {
        location = newLocation;
    }

    public boolean getMutability() {
        return mutable;
    }
    
    public String toString() {
        return title + " at " + location;
    }
}

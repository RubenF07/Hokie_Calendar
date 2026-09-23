package calendar;

public class Event {
    private String title;
    private String description;
    private String location;
    private Boolean mutable;

    public Event(String title, String description, String location, Boolean mutable) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.mutable = mutable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String newDesc) {
        description = newDesc;
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

    @Override
    public String toString() {
        return title+"\n"+description+"\nat "+location;
    }
}

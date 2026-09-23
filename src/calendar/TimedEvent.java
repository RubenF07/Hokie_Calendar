package calendar;

public class TimedEvent extends Event {
    private Time startTime;
    private Time endTime;

    public TimedEvent(String title, String description, String location, Boolean mutable, Time startTime, Time endTime) {
        super(title, description, location, mutable);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Time getStart() {
        return startTime;
    }

    public void setStart(Time newStartTime) {
        startTime = newStartTime;
    }

    public Time getEnd() {
        return endTime;
    }

    public void setEnd(Time newEndTime) {
        endTime = newEndTime;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"+ startTime + "-" + endTime;
    }
}

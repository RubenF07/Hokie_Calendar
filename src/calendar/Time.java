package calendar;

public class Time {
    private int hour;
    private int minute;
    private Boolean am;

    public Time(int hour, int minute, Boolean am) {
        this.hour = hour;
        this.minute = minute;
        this.am = am;
    }

    public String toString() {
        return hour + ":" + minute;
    }

    public int compareTo(Time t) {
        if (t.hour > this.hour || (t.hour == this.hour && t.minute > this.minute)) {
            return 1;
        } else if (t.hour == this.hour && t.minute == this.minute) {
            return 0;
        } else if (t.hour < this.hour || (t.hour == this.hour && t.minute < this.minute)) {
            return -1;
        }
    }
}

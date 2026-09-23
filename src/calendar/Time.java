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

    @Override
    public String toString() {
            if(am) {
                return hour + ":" + minute + " AM";
            }
            return hour + ":" + minute + " PM";
    }

    public int compareTo(Time t) {
        if (t.am != this.am) {
            if(t.am) {
                return -1;
            }
            else {
                return 1;
            }
        }
        if (t.hour > this.hour || (t.hour == this.hour && t.minute > this.minute)) {
            return 1;
        } else if (t.hour == this.hour && t.minute == this.minute) {
            return 0;
        } else {
            return -1;
        }
    }
}

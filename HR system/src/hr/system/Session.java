
package hr.system;

import java.sql.Time;
import java.util.Date;

public class Session {
    public int id;
    private Date date;
    private Time clockInTime;
    private Time clockOutTime;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(Time clockInTime) {
        this.clockInTime = clockInTime;
    }

    public Time getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(Time clockOutTime) {
        this.clockOutTime = clockOutTime;
    }
}


package edu.jsu.mcis.cs310.tas_fa22;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.util.HashMap;




public class ScheduleOverride {
    private int id;
    private LocalDateTime start, end;
    private DayOfWeek day;
    private DailySchedule dailyschedule;
    private Badge badge;
    
    public ScheduleOverride(HashMap<String, Object> map) {
        this.id = Integer.parseInt((map.get("id")));
        this.start = LocalDateTime.parse((map.get("start")));
        this.end = LocalDateTime.parse((map.get("end")));
        this.badge = (Badge)map.get("badge");
        this.day = Integer.parseInt((map.get("day")));
        this.dailyschedule = (DailySchedule)map.get("dailyschedule");
        
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public DailySchedule getDailyschedule() {
        return dailyschedule;
    }

    public Badge getBadge() {
        return badge;
    }
    
    
}

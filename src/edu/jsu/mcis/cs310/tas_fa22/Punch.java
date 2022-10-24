package edu.jsu.mcis.cs310.tas_fa22;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Punch {
    //Instance Fields
    private int terminalid;
    private EventType punchtype;
    private Badge badge;
    private Integer id;
    private LocalDateTime originaltimestamp;
    private LocalDateTime adjustedtimestamp;
    private PunchAdjustmentType adjustmenttype;
    
    //Constructor For New Punches
    public Punch (int terminalid, Badge badge, EventType punchtype) {
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtype = punchtype;
        this.id = null;
        this.originaltimestamp = LocalDateTime.now();
    }
    
    //Constructor for Existing Punches
    public Punch (int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, EventType
            punchtype) {
        this.id = id;
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtype = punchtype;
        this.originaltimestamp = originaltimestamp;
    }
    
    //Getter Methods
    public int getTerminalid() {
        return terminalid;
    }

    public EventType getPunchtype() {
        return punchtype;
    }

    public Badge getBadge() {
        return badge;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getOriginaltimestamp() {
        return originaltimestamp;
    }
    
    public String printOriginal() {
        
        StringBuilder s = new StringBuilder();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        
    
        s.append('#').append(badge.getId()).append(' ');
        s.append(punchtype).append(": ").append(originaltimestamp.format(formatter).toUpperCase());
        
        return s.toString();
    }
    
   
}

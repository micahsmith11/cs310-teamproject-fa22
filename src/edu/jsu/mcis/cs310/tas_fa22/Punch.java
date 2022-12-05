package edu.jsu.mcis.cs310.tas_fa22;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.lang.Math;
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
        this.originaltimestamp = LocalDateTime.now().withNano(0);
    }
    
    //Constructor for Existing Punches
    public Punch (int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, EventType
            punchtype) {
        this.id = id;
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtype = punchtype;
        this.originaltimestamp = originaltimestamp.withNano(0);
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
    
    public void adjust(Shift s) {
        adjustedtimestamp = originaltimestamp;
        int roundInterval = s.getRoundinterval();
        int dockPenalty = s.getDockpenalty();
        int gracePeriod = s.getGraceperiod();
        var shiftStart = adjustedtimestamp.with(s.getShiftstart());
        var shiftStop = adjustedtimestamp.with(s.getShiftstop());
        var lunchStart = adjustedtimestamp.with(s.getLunchstart());
        var lunchStop = adjustedtimestamp.with(s.getLunchstop());
        
       
        
         //If the punch is from the Weekend       
         if(adjustedtimestamp.getDayOfWeek() == DayOfWeek.SUNDAY || 
                adjustedtimestamp.getDayOfWeek() == DayOfWeek.SATURDAY) {
            //make adjustment type interval round
            adjustmenttype = adjustmenttype.INTERVAL_ROUND;
            int roundIntInSeconds = roundInterval * 60;  
            int num1 = 60 - roundInterval;
            int num2 = roundInterval / 2;
            int roundMinutes = num1 + num2;
            double num4 = Math.abs(num2 - Math.round(num2));
            double num5 = num4 * 60;
            int roundSeconds = (int)num5;
            int punchMinute = adjustedtimestamp.getMinute();
            //If round up to next hour
            if(adjustedtimestamp.isEqual(adjustedtimestamp.withMinute(roundMinutes).withSecond(roundSeconds))
                    || adjustedtimestamp.isAfter(adjustedtimestamp.withMinute(roundMinutes).withSecond(roundSeconds))) {
                adjustedtimestamp = adjustedtimestamp.plusHours(1).withMinute(0).withSecond(0);
            }
            //If round down within hour
            else if(punchMinute % roundInterval < (roundInterval / 2)) {
                adjustedtimestamp = adjustedtimestamp.withMinute(adjustedtimestamp.getMinute() / roundInterval * roundInterval);
                adjustedtimestamp = adjustedtimestamp.withSecond(adjustedtimestamp.getSecond() / roundIntInSeconds * roundIntInSeconds); 
            }
            //If round up in hour
            else {
                punchMinute = (Math.round(punchMinute/roundInterval) * roundInterval) + roundInterval;
                adjustedtimestamp = adjustedtimestamp.withMinute(punchMinute);
                adjustedtimestamp = adjustedtimestamp.withSecond(adjustedtimestamp.getSecond() / roundIntInSeconds * roundIntInSeconds);
            }
            
                
              
         }
         //If Punch is from the Weekday
          
         else{  
           //If Punch is a clock in
            if(punchtype == punchtype.CLOCK_IN) {
                //Round Interval Shift Start
                if(adjustedtimestamp.isEqual(shiftStart.minusMinutes(roundInterval)) || adjustedtimestamp.isBefore(shiftStart) && 
                        adjustedtimestamp.isAfter(shiftStart.minusMinutes(roundInterval))){
                    //adjust time to shift start
                   adjustedtimestamp = shiftStart;
                   //make adjusttype shift start
                   adjustmenttype = adjustmenttype.SHIFT_START;
                 }
                 //Grace Period Shift Start
                else if(adjustedtimestamp.isAfter(adjustedtimestamp.with(shiftStart)) && 
                        adjustedtimestamp.isBefore(adjustedtimestamp.with(shiftStart).plusMinutes(gracePeriod))
                        || adjustedtimestamp.isEqual(shiftStart.plusMinutes(gracePeriod))) {
                   adjustedtimestamp = shiftStart;
                   adjustmenttype = adjustmenttype.SHIFT_START;
                }
                 //Dock Penalty Shift Start
               else  if(adjustedtimestamp.isAfter(shiftStart) && 
                        adjustedtimestamp.isBefore(shiftStart.plusMinutes(dockPenalty))
                        || adjustedtimestamp.isEqual(shiftStart.plusMinutes(dockPenalty))) {
                   adjustedtimestamp = shiftStart.plusMinutes(dockPenalty);
                   adjustmenttype = adjustmenttype.SHIFT_DOCK;
                }
                //Round interval Lunch Stop 
               else if(adjustedtimestamp.isBefore(lunchStop) && 
                        adjustedtimestamp.isAfter(lunchStop.minusMinutes(roundInterval)) ||
                       adjustedtimestamp.isEqual(lunchStop.minusMinutes(roundInterval))){
                   adjustedtimestamp = lunchStop;
                   adjustmenttype = adjustmenttype.LUNCH_STOP;
                 }
                //Grace Period Lunch Stop 
              else if(adjustedtimestamp.isAfter(lunchStop) && 
                        adjustedtimestamp.isBefore(lunchStop.plusMinutes(gracePeriod))
                      || adjustedtimestamp.isEqual(lunchStop.plusMinutes(gracePeriod))) {
                   adjustedtimestamp = lunchStop;
                   adjustmenttype = adjustmenttype.LUNCH_STOP;
                 }
                //Dock Penalty Lunch Stop 
                else if(adjustedtimestamp.isAfter(adjustedtimestamp.with(lunchStop)) && 
                        adjustedtimestamp.isBefore(adjustedtimestamp.with(lunchStop).plusMinutes(dockPenalty))
                        || adjustedtimestamp.isEqual(lunchStop.plusMinutes(dockPenalty))) {
                   adjustedtimestamp = lunchStop.plusMinutes(dockPenalty);
                   adjustmenttype = adjustmenttype.SHIFT_DOCK;
                 }



                //None
                else if(adjustedtimestamp.getMinute() % roundInterval == 0 || 
                    adjustedtimestamp.getMinute() == 0) {
                    adjustedtimestamp = adjustedtimestamp.withSecond(0).withNano(0);
                    adjustmenttype = adjustmenttype.NONE;        
                }

                //Interval Round
                else {
                    adjustmenttype = adjustmenttype.INTERVAL_ROUND;
                    
                    int roundIntInSeconds = roundInterval * 60;  
                    int num1 = 60 - roundInterval;
                    int num2 = roundInterval / 2;
                    int roundMinutes = num1 + num2;
                    double num4 = Math.abs(num2 - Math.round(num2));
                    double num5 = num4 * 60;
                    int roundSeconds = (int)num5;
                    int punchMinute = adjustedtimestamp.getMinute();
                    //If round up to next hour
                    if(adjustedtimestamp.isEqual(adjustedtimestamp.withMinute(roundMinutes).withSecond(roundSeconds))
                            || adjustedtimestamp.isAfter(adjustedtimestamp.withMinute(roundMinutes).withSecond(roundSeconds))) {
                        adjustedtimestamp = adjustedtimestamp.plusHours(1).withMinute(0).withSecond(0);
                    }
                    //If round up within hour
                    else if(punchMinute % roundInterval < (roundInterval / 2)) {
                        adjustedtimestamp = adjustedtimestamp.withMinute(adjustedtimestamp.getMinute() / roundInterval * roundInterval);
                        adjustedtimestamp = adjustedtimestamp.withSecond(adjustedtimestamp.getSecond() / roundIntInSeconds * roundIntInSeconds); 
                    }
                    else {
                        punchMinute = (Math.round(punchMinute/roundInterval) * roundInterval) + roundInterval;
                        adjustedtimestamp = adjustedtimestamp.withMinute(punchMinute);
                        adjustedtimestamp = adjustedtimestamp.withSecond(adjustedtimestamp.getSecond() / roundIntInSeconds * roundIntInSeconds);
                    }
                }
            
            }

            else if(punchtype == punchtype.CLOCK_OUT) {
                  //Round Interval Shift Stop
                if(adjustedtimestamp.isAfter(shiftStop) &&
                   adjustedtimestamp.isBefore(shiftStop.plusMinutes(roundInterval)) ||
                    adjustedtimestamp.isEqual(lunchStop.plusMinutes(roundInterval))) {
                   adjustedtimestamp = shiftStop;
                   adjustmenttype = adjustmenttype.SHIFT_STOP;
                 }
                 //Grace Period Shift Stop
                else if(adjustedtimestamp.isBefore(shiftStop) &&
                        adjustedtimestamp.isAfter(shiftStop.minusMinutes(gracePeriod)) ||
                        adjustedtimestamp.isEqual(shiftStop.minusMinutes(gracePeriod))) {
                   adjustedtimestamp = shiftStop;
                   adjustmenttype = adjustmenttype.SHIFT_STOP;
                }
                //Dock Penalty Shift Stop
                else if(adjustedtimestamp.isBefore(shiftStop) &&
                        adjustedtimestamp.isAfter(shiftStop.minusMinutes(dockPenalty)) ||
                        adjustedtimestamp.isEqual(shiftStop.minusMinutes(dockPenalty))) {
                   adjustedtimestamp = shiftStop.minusMinutes(dockPenalty);
                   adjustmenttype = adjustmenttype.SHIFT_DOCK;
                }

                 //Round Interval Lunch Start 
                else if(adjustedtimestamp.isAfter(lunchStart) &&
                   adjustedtimestamp.isBefore(lunchStart.plusMinutes(roundInterval)) ||
                   adjustedtimestamp.isEqual(lunchStart.plusMinutes(roundInterval))){
                    adjustedtimestamp = lunchStart;
                    adjustmenttype = adjustmenttype.LUNCH_START;
                  } 
                 //Grace Period Lunch Start 
                else if(adjustedtimestamp.isBefore(lunchStart) &&
                        adjustedtimestamp.isAfter(lunchStart.minusMinutes(gracePeriod)) ||
                        adjustedtimestamp.isEqual(lunchStart.minusMinutes(gracePeriod))) { 
                    adjustedtimestamp = lunchStart;
                    adjustmenttype = adjustmenttype.LUNCH_START;
                  }
                  //Dock Penalty Lunch Start 
                else if(adjustedtimestamp.isBefore(lunchStart) &&
                        adjustedtimestamp.isAfter(lunchStart.minusMinutes(dockPenalty)) ||
                        adjustedtimestamp.isEqual(lunchStart.minusMinutes(dockPenalty))) { 
                    adjustedtimestamp = lunchStart.minusMinutes(dockPenalty);
                    adjustmenttype = adjustmenttype.LUNCH_START;
                  }


                //None
                else if(adjustedtimestamp.getMinute() % 15 == 0 || 
                    adjustedtimestamp.getMinute() == 0) {
                    adjustedtimestamp = adjustedtimestamp.withSecond(0).withNano(0);
                    adjustmenttype = adjustmenttype.NONE;        
                }
                //Interval Round
                else {
                    adjustmenttype = adjustmenttype.INTERVAL_ROUND;
                    int roundIntInSeconds = roundInterval * 60;  
                    int num1 = 60 - roundInterval;
                    int num2 = roundInterval / 2;
                    int roundMinutes = num1 + num2;
                    double num4 = Math.abs(num2 - Math.round(num2));
                    double num5 = num4 * 60;
                    int roundSeconds = (int)num5;
                    int punchMinute = adjustedtimestamp.getMinute();
                    //If round up to next hour
                    if(adjustedtimestamp.isEqual(adjustedtimestamp.withMinute(roundMinutes).withSecond(roundSeconds))
                            || adjustedtimestamp.isAfter(adjustedtimestamp.withMinute(roundMinutes).withSecond(roundSeconds))) {
                        adjustedtimestamp = adjustedtimestamp.plusHours(1).withMinute(0).withSecond(0);
                    }
                    //If round down within hour
                    else if(punchMinute % roundInterval < (roundInterval / 2)) {
                        adjustedtimestamp = adjustedtimestamp.withMinute(adjustedtimestamp.getMinute() / roundInterval * roundInterval);
                        adjustedtimestamp = adjustedtimestamp.withSecond(adjustedtimestamp.getSecond() / roundIntInSeconds * roundIntInSeconds); 
                    }
                    //If round up within hour
                    else {
                        punchMinute = (Math.round(punchMinute/roundInterval) * roundInterval) + roundInterval;
                        adjustedtimestamp = adjustedtimestamp.withMinute(punchMinute);
                        adjustedtimestamp = adjustedtimestamp.withSecond(adjustedtimestamp.getSecond() / roundIntInSeconds * roundIntInSeconds);
                    }
                }
             
            }

        } 
    }          
        
    

    public LocalDateTime getOriginaltimestamp() {
        return originaltimestamp;
    }
    
    public LocalDateTime getAdjustedtimestamp() {
        return adjustedtimestamp;
    }
    
    public PunchAdjustmentType getAdjustmenttype() {
        return adjustmenttype;
    }
    
    @Override
    public String toString() {
        return printOriginal();
    }
    
    public String printOriginal() {
        
        StringBuilder s = new StringBuilder();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        
    
        s.append('#').append(badge.getId()).append(' ');
        s.append(punchtype).append(": ").append(originaltimestamp.format(formatter).toUpperCase());
        
        return s.toString();
    }
    
    public String printAdjusted() {
        
        StringBuilder s = new StringBuilder();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        
    
        s.append('#').append(badge.getId()).append(' ');
        s.append(punchtype).append(": ").append(adjustedtimestamp.format(formatter).toUpperCase());
        s.append(' ').append('(').append(adjustmenttype).append(')');
        
        return s.toString();
    }
   
}

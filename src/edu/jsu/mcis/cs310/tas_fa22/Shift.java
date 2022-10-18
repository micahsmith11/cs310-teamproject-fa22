package edu.jsu.mcis.cs310.tas_fa22;

import java.time.*;
import java.util.HashMap;

public class Shift {
    private int id, roundinterval, graceperiod, dockpenalty, lunchthreshold, lunchDuration, shiftDuration;
    private String description;
    private LocalTime shiftstart, shiftstop, lunchstart, lunchstop;

    public Shift(HashMap<String, String> map) {
        this.id = Integer.parseInt(map.get("id"));
        this.description = map.get("description");
        this.shiftstart = LocalTime.parse(map.get("shiftstart"));
        this.shiftstop = LocalTime.parse(map.get("shiftstop"));
        this.roundinterval = Integer.parseInt(map.get("roundinterval"));
        this.graceperiod = Integer.parseInt(map.get("graceperiod"));
        this.dockpenalty = Integer.parseInt(map.get("dockpenalty"));
        this.lunchstart = LocalTime.parse(map.get("lunchstart"));
        this.lunchstop = LocalTime.parse(map.get("lunchstop"));
        this.lunchthreshold = Integer.parseInt(map.get("lunchthreshold"));
        this.lunchDuration = (int)Duration.between(this.lunchstart, this.lunchstop).toMinutes();
        this.shiftDuration = (int)Duration.between(this.shiftstart, this.shiftstop).toMinutes();
    }

    public int getId() {return id;}

    public int getRoundinterval() {return roundinterval;}

    public int getGraceperiod() {return graceperiod;}

    public int getDockpenalty() {return dockpenalty;}

    public int getLunchthreshold() {return lunchthreshold;}

    public String getDesciption() {return description;}

    public LocalTime getShiftstart() {return shiftstart;}

    public LocalTime getShiftstop() {return shiftstop;}

    public LocalTime getLunchstart() {return lunchstart;}

    public LocalTime getLunchstop() {return lunchstop;}

    public int getLunchDuration() {return lunchDuration;}

    public int getShiftDuration() {return shiftDuration;}

    @Override

    public String toString(){

        StringBuilder s = new StringBuilder();

        s.append(getDesciption()).append(':').append(' ');
        s.append(getShiftstart()).append(' ').append('-');
        s.append(' ').append(getShiftstop()).append(' ');
        s.append('(').append(getShiftDuration()).append(' ').append("minutes").append(')').append(';');
        s.append(' ').append("Lunch:").append(' ').append(getLunchstart()).append(' ').append('-').append(' ');
        s.append(getLunchstop()).append(' ').append('(').append(getLunchDuration()).append(' ').append("minutes").append(')');

        return s.toString();
    }
}

package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import org.json.simple.*;

/**
 * 
 * Utility class for DAOs.  This is a final, non-constructable class containing
 * common DAO logic and other repeated and/or standardized code, refactored into
 * individual static methods.
 *
 */
public final class DAOUtility {
    
        public static int calculateTotalMinutes(ArrayList<Punch> dailypunchlist, Shift s) {
        
        int m = 0;
        int startHours = 0;
        int stopHours = 0;
        int startMinutes = 0;
        int stopMinutes = 0;
        int calculations = 0;
        int totalWithLunch = 0;
        int lunchDuration = s.getLunchDuration();
        
        LocalDateTime punches;
        
        boolean pair = false;
        
       
        for (Punch p : dailypunchlist){
            if (p.getPunchtype() == EventType.CLOCK_IN || 
                    p.getPunchtype() == EventType.CLOCK_OUT){
                }
                if (p.getPunchtype() == EventType.CLOCK_IN){
                   pair = false;
                }
                
                if (p.getPunchtype() == EventType.CLOCK_OUT){
                   pair = true; 
                }
           
           
           if (pair == false) {
               punches = p.getAdjustedtimestamp();
               startHours = punches.getHour();
               startMinutes = punches.getMinute();
           }
           
           else if (pair){ 
                
                punches = p.getAdjustedtimestamp();
                stopHours = punches.getHour();
                stopMinutes = punches.getMinute();
                totalWithLunch = ((stopHours - startHours) * 60)
                        + (stopMinutes - startMinutes);
                
                if (totalWithLunch > s.getLunchthreshold()){
                    calculations = totalWithLunch - lunchDuration;
                    m = m + calculations;
                }
                
                else if (totalWithLunch <= s.getLunchthreshold()){
                    calculations = ((stopHours - startHours) * 60)
                            + (stopMinutes - startMinutes);
                    m = m + calculations; 
                }
            }
        }  
    return m;
    }
        
        public static String getPunchListAsJSON(ArrayList<Punch> dailypunchlist){
           
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        
        for(int i = 0; i < dailypunchlist.size(); i++){
            
            
            
            HashMap<String, String> punch = new HashMap<String, String>();
            punch.put("originaltimestamp", dailypunchlist.get(i).getOriginaltimestamp().format(DateTimeFormatter.ofPattern("E MM/dd/yyyy HH:mm:ss")).toUpperCase());
            punch.put("badgeid", dailypunchlist.get(i).getBadge().getId());
            punch.put("adjustedtimestamp", dailypunchlist.get(i).getAdjustedtimestamp().format(DateTimeFormatter.ofPattern("E MM/dd/yyyy HH:mm:ss")).toUpperCase());
            punch.put("adjustmenttype", dailypunchlist.get(i).getAdjustmenttype().toString());
            punch.put("terminalid", Integer.toString(dailypunchlist.get(i).getTerminalid()));
            punch.put("id", Integer.toString(dailypunchlist.get(i).getId()));
            punch.put("punchtype", dailypunchlist.get(i).getPunchtype().toString());
            
            
            list.add(punch);
            
        }
        
        String json = JSONValue.toJSONString(list);
         return json;
    }    
}

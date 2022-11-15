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
}
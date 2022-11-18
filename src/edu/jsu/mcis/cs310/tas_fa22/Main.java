package edu.jsu.mcis.cs310.tas_fa22;

import edu.jsu.mcis.cs310.tas_fa22.dao.*;
import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import org.json.simple.*;

public class Main {

    public static void main(String[] args) {
        
        LocalDate begin = LocalDate.of(2018, 7, 30);
        LocalDate end = LocalDate.of(2018, 8, 3);
        
        DAOFactory daoFactory = new DAOFactory("tas.jdbc");
        
        PunchDAO punchDAO = daoFactory.getPunchDAO();
        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        
        Badge badge = badgeDAO.find("4E6E296E");
        
        ArrayList<Punch> punchList = punchDAO.list(badge, begin, end);
        
        for (Punch p : punchList) {
            System.err.println(p);
        }
        
        
        // test database connectivity; get DAOs

        //DAOFactory daoFactory = new DAOFactory("tas.jdbc");
       // BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        //ShiftDAO shiftDao = daoFactory.getShiftDAO();
        //PunchDAO punchDao = daoFactory.getPunchDAO();
        
        // find badge

        //Badge b = badgeDAO.find("31A25435");
        
        // output should be "Test Badge: #31A25435 (Munday, Paul J)"
        
        //System.err.println("Test Badge: " + b.toString());

    }
    
    //Kenneth Jones
    //Micah Smith
    //Austin Rush
    //Laila Hamdan
    
    //Completed Sprint 1 on October 21, 2022.
    //Completed Sprint 2 on November 4, 2022.
}

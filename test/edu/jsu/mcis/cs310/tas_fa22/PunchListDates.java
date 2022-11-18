package edu.jsu.mcis.cs310.tas_fa22;

import edu.jsu.mcis.cs310.tas_fa22.dao.*;
import java.time.*;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class PunchListDates {

    private DAOFactory daoFactory;

    @Before
    public void setup() {

        daoFactory = new DAOFactory("tas.jdbc");

    }
    public void testPunchFindDates1() {

        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        LocalDate begin = LocalDate.of(2018, Month.AUGUST, 2);
        LocalDate end = LocalDate.of(2018, Month.AUGUST, 9);

        Badge b = badgeDAO.find("8C0644BA");

        ArrayList<Punch> p1 = punchDAO.list(b, begin, end);

        for (Punch p : p1) {
            s1.append(p.printOriginal());
            s1.append("\n");
        }

        ArrayList<Punch> p2 = new ArrayList<>();

        p2.add(punchDAO.find(302));
        p2.add(punchDAO.find(323));
        p2.add(punchDAO.find(408));
        p2.add(punchDAO.find(489));
        p2.add(punchDAO.find(522));
        p2.add(punchDAO.find(571));
        p2.add(punchDAO.find(690));
        p2.add(punchDAO.find(758));
        p2.add(punchDAO.find(819));


        for (Punch p : p2) {
            s2.append(p.printOriginal());
            s2.append("\n");
        }
        
        assertEquals(s2.toString(), s1.toString());
    }  
    
     public void testPunchFindDate2() {

        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        LocalDate begin = LocalDate.of(2018, Month.AUGUST, 23);
        LocalDate end = LocalDate.of(2018, Month.AUGUST, 29);

        Badge b = badgeDAO.find("7CB9642F");

        ArrayList<Punch> p1 = punchDAO.list(b, begin, end);

        for (Punch p : p1) {
            s1.append(p.printOriginal());
            s1.append("\n");
        }

        ArrayList<Punch> p2 = new ArrayList<>();

        p2.add(punchDAO.find(2342));
        p2.add(punchDAO.find(2415));
        p2.add(punchDAO.find(2472));
        p2.add(punchDAO.find(2552));
        p2.add(punchDAO.find(2600));
        p2.add(punchDAO.find(2814));
        p2.add(punchDAO.find(2881));
        p2.add(punchDAO.find(2947));
        p2.add(punchDAO.find(2989));


        for (Punch p : p2) {
            s2.append(p.printOriginal());
            s2.append("\n");
        }
        
        assertEquals(s2.toString(), s1.toString());
    }  
}
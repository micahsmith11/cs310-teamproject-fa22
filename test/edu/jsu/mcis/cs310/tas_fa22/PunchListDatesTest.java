package edu.jsu.mcis.cs310.tas_fa22;

import edu.jsu.mcis.cs310.tas_fa22.dao.*;
import java.time.*;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class PunchListDatesTest {

    private DAOFactory daoFactory;

    @Before
    public void setup() {

        daoFactory = new DAOFactory("tas.jdbc");

    }
    
    @Test
    public void PunchListDatesTest1() {

        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        LocalDate begin = LocalDate.of(2018, Month.AUGUST, 2);
        LocalDate end = LocalDate.of(2018, Month.AUGUST, 8);

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
        p2.add(punchDAO.find(650));
        p2.add(punchDAO.find(690));
        p2.add(punchDAO.find(758));
        p2.add(punchDAO.find(819));


        for (Punch p : p2) {
            s2.append(p.printOriginal());
            s2.append("\n");
        }
        
        assertEquals(s2.toString(), s1.toString());
    }
    
    @Test
    public void PunchListDateTest2() {

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

        p2.add(punchDAO.find(2285));
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
    
    @Test
    public void PunchListDateTest3() {

        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        LocalDate begin = LocalDate.of(2018, Month.SEPTEMBER, 4);
        LocalDate end = LocalDate.of(2018, Month.SEPTEMBER, 7);

        Badge b = badgeDAO.find("08D745A6");

        ArrayList<Punch> p1 = punchDAO.list(b, begin, end);

        for (Punch p : p1) {
            s1.append(p.printOriginal());
            s1.append("\n");
        }

        ArrayList<Punch> p2 = new ArrayList<>();

        p2.add(punchDAO.find(3319));
        p2.add(punchDAO.find(3331));
        p2.add(punchDAO.find(3335));
        p2.add(punchDAO.find(3382));
        p2.add(punchDAO.find(3428));
        p2.add(punchDAO.find(3485));
        p2.add(punchDAO.find(3555));
        p2.add(punchDAO.find(3605));
        p2.add(punchDAO.find(3664));
        p2.add(punchDAO.find(3726));


        for (Punch p : p2) {
            s2.append(p.printOriginal());
            s2.append("\n");
        }
        
        assertEquals(s2.toString(), s1.toString());
    } 
    
    @Test
    public void PunchListDateTest4() {

        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        LocalDate begin = LocalDate.of(2018, Month.AUGUST, 10);
        LocalDate end = LocalDate.of(2018, Month.AUGUST, 17);

        Badge b = badgeDAO.find("6CA0FF4A");

        ArrayList<Punch> p1 = punchDAO.list(b, begin, end);

        for (Punch p : p1) {
            s1.append(p.printOriginal());
            s1.append("\n");
        }

        ArrayList<Punch> p2 = new ArrayList<>();

        p2.add(punchDAO.find(964));
        p2.add(punchDAO.find(1056));
        p2.add(punchDAO.find(1175));
        p2.add(punchDAO.find(1248));
        p2.add(punchDAO.find(1311));
        p2.add(punchDAO.find(1395));
        p2.add(punchDAO.find(1464));
        p2.add(punchDAO.find(1470));
        p2.add(punchDAO.find(1705));
        p2.add(punchDAO.find(1783));


        for (Punch p : p2) {
            s2.append(p.printOriginal());
            s2.append("\n");
        }
        
        assertEquals(s2.toString(), s1.toString());
    } 
    
    @Test
    public void PunchListDateTest5() {

        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        LocalDate begin = LocalDate.of(2018, Month.AUGUST, 24);
        LocalDate end = LocalDate.of(2018, Month.AUGUST, 30);

        Badge b = badgeDAO.find("4C459F1E");

        ArrayList<Punch> p1 = punchDAO.list(b, begin, end);

        for (Punch p : p1) {
            s1.append(p.printOriginal());
            s1.append("\n");
        }

        ArrayList<Punch> p2 = new ArrayList<>();

        p2.add(punchDAO.find(2400));
        p2.add(punchDAO.find(2487));
        p2.add(punchDAO.find(2523));
        p2.add(punchDAO.find(2636));
        p2.add(punchDAO.find(2651));
        p2.add(punchDAO.find(2750));
        p2.add(punchDAO.find(2806));
        p2.add(punchDAO.find(2902));
        p2.add(punchDAO.find(2928));
        p2.add(punchDAO.find(2994));
        p2.add(punchDAO.find(3041));
        p2.add(punchDAO.find(3106));


        for (Punch p : p2) {
            s2.append(p.printOriginal());
            s2.append("\n");
        }
        
        assertEquals(s2.toString(), s1.toString());
    } 
}
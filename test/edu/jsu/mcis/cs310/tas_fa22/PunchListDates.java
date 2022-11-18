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

    @Test
    public void testFindPunchList1() {

        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();
        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        LocalDate ts = LocalDate.of(2018, Month.SEPTEMBER, 17);

        Badge b = badgeDAO.find("67637925");
        
        ArrayList<Punch> p1 = punchDAO.list(b, ts);
        
        for (Punch p : p1) {
            s1.append(p.printOriginal());
            s1.append("\n");
        }
        
        ArrayList<Punch> p2 = new ArrayList<>();

        /* Add Punches */
        p2.add(punchDAO.find(4716));
        p2.add(punchDAO.find(4811));
        p2.add(punchDAO.find(4813));
        p2.add(punchDAO.find(4847));
        
        for (Punch p : p2) {
            s2.append(p.printOriginal());
            s2.append("\n");
        }

        
        assertEquals(s2.toString(), s1.toString());

    }

    @Test
    public void testFindPunchList2() {

        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        PunchDAO punchDAO = daoFactory.getPunchDAO();

        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        
        LocalDate ts = LocalDate.of(2018, Month.SEPTEMBER, 27);

        Badge b = badgeDAO.find("87176FD7");

        
        ArrayList<Punch> p1 = punchDAO.list(b, ts);

        
        for (Punch p : p1) {
            s1.append(p.printOriginal());
            s1.append("\n");
        }

        
        ArrayList<Punch> p2 = new ArrayList<>();

        
        p2.add(punchDAO.find(6089));
        p2.add(punchDAO.find(6112));
        p2.add(punchDAO.find(6118));
        p2.add(punchDAO.find(6129));

        
        for (Punch p : p2) {
            s2.append(p.printOriginal());
            s2.append("\n");
        }
        
        assertEquals(s2.toString(), s1.toString());

    }
}
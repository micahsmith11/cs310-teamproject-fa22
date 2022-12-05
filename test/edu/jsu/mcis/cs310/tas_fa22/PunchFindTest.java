package edu.jsu.mcis.cs310.tas_fa22;

import edu.jsu.mcis.cs310.tas_fa22.dao.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PunchFindTest {

    private DAOFactory daoFactory;

    @Before
    public void setup() {

        daoFactory = new DAOFactory("tas.jdbc");

    }

    @Test
    public void testFindPunches1() {

        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Retrieve Punches from Database */
        
        Punch p1 = punchDAO.find(3433);
        Punch p2 = punchDAO.find(3325);
        Punch p3 = punchDAO.find(1963);
        Punch p4 = punchDAO.find(1856);
        Punch p5 = punchDAO.find(6544);

        /* Compare to Expected Values */
        
        assertEquals("#D2C39273 CLOCK IN: WED 09/05/2018 07:00:07", p1.printOriginal());
        assertEquals("#DFD9BB5C CLOCK IN: TUE 09/04/2018 08:00:00", p2.printOriginal());
        assertEquals("#99F0C0FA CLOCK IN: SAT 08/18/2018 06:00:00", p3.printOriginal());
        assertEquals("#8C0644BA CLOCK OUT: SAT 08/18/2018 11:02:02", p4.printOriginal());
        assertEquals("#E880B82A CLOCK IN: SAT 09/29/2018 06:00:00", p5.printOriginal());
    }

    @Test
    public void testFindPunches2() {

        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Retrieve Punches from Database */

        Punch p6 = punchDAO.find(5702);
        Punch p7 = punchDAO.find(4976);
        Punch p8 = punchDAO.find(2193);
        Punch p9 = punchDAO.find(331);
        Punch p10 = punchDAO.find(958);

        /* Compare to Expected Values */

        assertEquals("#0FFA272B CLOCK OUT: MON 09/24/2018 17:30:04", p6.printOriginal());
        assertEquals("#FCE87D9F CLOCK OUT: TUE 09/18/2018 17:34:00", p7.printOriginal());
        assertEquals("#FCE87D9F CLOCK OUT: MON 08/20/2018 17:30:00", p8.printOriginal());
        assertEquals("#CEC9A3DA CLOCK OUT: THU 08/02/2018 15:31:44", p9.printOriginal());
        assertEquals("#C457EFF7 CLOCK IN: FRI 08/10/2018 06:47:24", p10.printOriginal());
    }
    
    @Test
    public void testFindPunches3() {

        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Retrieve Punches from Database */

        Punch p11 = punchDAO.find(954);
        Punch p12 = punchDAO.find(258);
        Punch p13 = punchDAO.find(717);
        Punch p14 = punchDAO.find(1189);
        Punch p15 = punchDAO.find(1181);

        /* Compare to Expected Values */

        assertEquals("#618072EA TIME OUT: FRI 08/10/2018 00:12:35", p11.printOriginal());
        assertEquals("#0886BF12 TIME OUT: THU 08/02/2018 06:06:38", p12.printOriginal());
        assertEquals("#67637925 TIME OUT: TUE 08/07/2018 23:12:34", p13.printOriginal());
        assertEquals("#E8A58074 CLOCK IN: MON 08/13/2018 06:53:05", p14.printOriginal());
        assertEquals("#C457EFF7 CLOCK IN: MON 08/13/2018 06:51:15", p15.printOriginal());
    }
    
    @Test
    public void testFindPunches4() {

        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Retrieve Punches from Database */

        Punch p16 = punchDAO.find(393);
        Punch p17 = punchDAO.find(455);
        Punch p18 = punchDAO.find(1645);
        Punch p19 = punchDAO.find(2022);

        /* Compare to Expected Values */

        assertEquals("#DFDFE648 CLOCK IN: FRI 08/03/2018 06:54:20", p16.printOriginal());
        assertEquals("#CF697DE6 CLOCK OUT: FRI 08/03/2018 15:31:43", p17.printOriginal());
        assertEquals("#CB99D1E8 CLOCK OUT: THU 08/16/2018 15:33:51", p18.printOriginal());
        assertEquals("#398B1563 CLOCK IN: TUE 08/21/2018 06:48:23", p19.printOriginal());
        
    }
    
    @Test
    public void testFindPunches5() {

        PunchDAO punchDAO = daoFactory.getPunchDAO();

        /* Retrieve Punches from Database */

        Punch p20 = punchDAO.find(212);
        Punch p21 = punchDAO.find(575);
        Punch p22 = punchDAO.find(1212);
        Punch p23 = punchDAO.find(1776);

        /* Compare to Expected Values */

        assertEquals("#B09A75D7 CLOCK OUT: WED 08/01/2018 15:31:49", p20.printOriginal());
        assertEquals("#76118CDC CLOCK OUT: MON 08/06/2018 15:33:09", p21.printOriginal());
        assertEquals("#CB99D1E8 CLOCK IN: MON 08/13/2018 07:00:25", p22.printOriginal());
        assertEquals("#BE51FA92 CLOCK OUT: FRI 08/17/2018 15:32:54", p23.printOriginal());
    }
    
    
}

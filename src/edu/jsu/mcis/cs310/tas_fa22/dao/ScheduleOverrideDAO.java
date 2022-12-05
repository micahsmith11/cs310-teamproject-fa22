
package edu.jsu.mcis.cs310.tas_fa22.dao;
import java.util.HashMap;
import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.time.LocalDate;


public class ScheduleOverrideDAO {
    private static final String QUERY_FIND_DAILYSCHEDULE = "SELECT * FROM scheduleovveride WHERE id = ?";
     
    private final DAOFactory daoFactory;
    
    private HashMap<String, String> map2 = new HashMap<>();
    
    public ScheduleOverrideDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public DailySchedule find(int id){
        //Shift shift = null;
        DailySchedule dailyschedule = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)){
                ps = conn.prepareStatement(QUERY_FIND_DAILYSCHEDULE);
                ps.setInt(1, id);

                boolean hasresults = ps.execute();

                if (hasresults){
                    rs = ps.getResultSet();

                    while (rs.next()){
                        
                    
}

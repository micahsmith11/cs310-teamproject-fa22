
package edu.jsu.mcis.cs310.tas_fa22.dao;
import java.util.HashMap;
import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;

public class DailyScheduleDAO {
    private static final String QUERY_FIND_DAILYSCHEDULE = "SELECT * FROM dailyschedule WHERE id = ?";
   
    private final DAOFactory daoFactory;
    
    private HashMap<String, String> map2 = new HashMap<>();
    
    public DailyScheduleDAO(DAOFactory daoFactory) {
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
                        map2.put("shiftstart", rs.getString("shiftstart"));
                        map2.put("shiftstop", rs.getString("shiftstop"));
                        map2.put("roundinterval", rs.getString("roundinterval"));
                        map2.put("graceperiod", rs.getString("graceperiod"));
                        map2.put("dockpenalty", rs.getString("dockpenalty"));
                        map2.put("lunchstart", rs.getString("lunchstart"));
                        map2.put("lunchstop", rs.getString("lunchstop"));
                        map2.put("lunchthreshold", rs.getString("lunchthreshold"));
                    }
                    dailyschedule = new DailySchedule(map2);
                    
                }
            }
        }
        catch (SQLException e) {

            throw new DAOException(e.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }

        }
        return dailyschedule;
    }
        

}

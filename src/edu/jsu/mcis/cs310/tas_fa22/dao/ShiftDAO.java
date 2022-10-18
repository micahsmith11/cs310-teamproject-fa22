package edu.jsu.mcis.cs310.tas_fa22.dao;
import java.util.HashMap;
import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;

public class ShiftDAO {

    private static final String QUERY_FIND = "SELECT * FROM shift WHERE id = ?";
     private static final String QUERY_FIND_BY_BADGE = "SELECT s.id, s.description, s.shiftstart, s.shiftstop,\n" +
            "s.roundinterval, s.graceperiod, s.dockpenalty, s.lunchstart, \n" +
            "s.lunchstop, s.lunchthreshold\n" +
            "from badge b\n" +
            "join employee e on b.id = e.badgeid\n" +
            "join shift s on s.id = e.shiftid\n" +
            "where b.id = ?";

    private final DAOFactory daoFactory;

    private HashMap<String, String> map = new HashMap<>();


    public ShiftDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Shift find(int id){
        Shift shift = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)){
                ps = conn.prepareStatement(QUERY_FIND);
                ps.setInt(1, id);

                boolean hasresults = ps.execute();

                if (hasresults){
                    rs = ps.getResultSet();

                    while (rs.next()){
                        map.put("id", rs.getString("id"));
                        map.put("description", rs.getString("description"));
                        map.put("shiftstart", rs.getString("shiftstart"));
                        map.put("shiftstop", rs.getString("shiftstop"));
                        map.put("roundinterval", rs.getString("roundinterval"));
                        map.put("graceperiod", rs.getString("graceperiod"));
                        map.put("dockpenalty", rs.getString("dockpenalty"));
                        map.put("lunchstart", rs.getString("lunchstart"));
                        map.put("lunchstop", rs.getString("lunchstop"));
                        map.put("lunchthreshold", rs.getString("lunchthreshold"));
                    }
                    //create a shift class with this hash map
                    shift = new Shift(map);
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
        return shift;
    }
    
     public Shift find(Badge badge){
        Shift shift = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)){
                ps = conn.prepareStatement(QUERY_FIND_BY_BADGE);
                ps.setString(1, badge.getId());

                boolean hasresults = ps.execute();

                if (hasresults){
                    rs = ps.getResultSet();

                    while (rs.next()){
                        map.put("id", rs.getString("id"));
                        map.put("description", rs.getString("description"));
                        map.put("shiftstart", rs.getString("shiftstart"));
                        map.put("shiftstop", rs.getString("shiftstop"));
                        map.put("roundinterval", rs.getString("roundinterval"));
                        map.put("graceperiod", rs.getString("graceperiod"));
                        map.put("dockpenalty", rs.getString("dockpenalty"));
                        map.put("lunchstart", rs.getString("lunchstart"));
                        map.put("lunchstop", rs.getString("lunchstop"));
                        map.put("lunchthreshold", rs.getString("lunchthreshold"));
                    }
                    //create a shift class with this hash map
                    shift = new Shift(map);
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
        return shift;
    }
}

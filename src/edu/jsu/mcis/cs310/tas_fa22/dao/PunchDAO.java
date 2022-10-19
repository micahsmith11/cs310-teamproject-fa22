package edu.jsu.mcis.cs310.tas_fa22.dao;
import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;

public class PunchDAO {
    private static final String QUERY_FIND = "SELECT * FROM event WHERE id = ?";
    
    private final DAOFactory daoFactory;
    
    public PunchDAO (DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }
    
    public Punch find (int id){
        Punch punch = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{ 
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                ps = conn.prepareStatement(QUERY_FIND);
                ps.setInt(1, id);
                
                boolean hasresults = ps.execute();
                
                if (hasresults) {
                    rs = ps.getResultSet();
                    
                    while (rs.next()) {
                        punch = new Punch(rs.getInt("id"), rs.getInt("terminalid"), findBadge(rs.getString("badgeid")),rs.getTimestamp("timestamp").toLocalDateTime(), EventType.values()[rs.getInt("eventtypeid")]);
                    }
                }
            }
        }
        catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        finally { 
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
            if (ps != null){
                try {
                    ps.close();
                }
                catch (SQLException e){ 
                    throw new DAOException(e.getMessage());
                }
            }
        }
        return punch;
    }
    
    private Badge findBadge(String id){
        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
        Badge b = badgeDAO.find(id);
        return b;        
        
    }
    
}    

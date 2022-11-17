package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.time.LocalDate;


public class AbsenteeismDAO {
   
    private static final String QUERY_FIND = "SELECT * FROM absenteeism WHERE employeeid = ? AND payperiod = ?";
    private static final String QUERY_CREATE = "INSERT INTO absenteeism (employeeid, payperiod, percentage) VALUES (?, ?, ?)";
    private static final String QUERY_UPDATE = "UPDATE absenteeism SET employeeid = ? AND payperiod = ? AND percentage = ?";
    private final DAOFactory daoFactory;

    AbsenteeismDAO(DAOFactory daoFactory) {
        
        this.daoFactory = daoFactory;
    }
    
    public Absenteeism find(Employee employee, LocalDate payperiod) {

        Absenteeism absenteeism = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        
         try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setInt(1, employee.getId());
                ps.setObject(2, payperiod);
                
                boolean hasresults = ps.execute();
                
                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                      //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        double percentage = rs.getDouble("percentage");
                        absenteeism = new Absenteeism(employee, payperiod, percentage);
                        }
                }
            }
                 
        } catch (SQLException e) {

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

        return absenteeism;

    }
    
    public  Absenteeism create(Absenteeism absenteeism) {
        
        PreparedStatement ps = null;
        //int employeeid = absenteeism.getEmployee().getId();
        AbsenteeismDAO absenteeismDAO = new AbsenteeismDAO(daoFactory);
        
        if(absenteeismDAO.find(absenteeism.getEmployee(), absenteeism.getPayPeriod()) == null) {
            
             try {


                Connection conn = daoFactory.getConnection();

                if (conn.isValid(0)) {
                    ps = conn.prepareStatement(QUERY_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, absenteeism.getEmployee().getId());
                    ps.setObject(2, absenteeism.getPayPeriod());
                    ps.setDouble(3, absenteeism.getPercentage());
                
                    //boolean hasresults = ps.execute();
                    
                    int update = ps.executeUpdate();
                
                    if (update == 1) {
                        boolean hasresults = true;
                   }
                
                }   
             }  catch (SQLException e) {
                throw new DAOException(e.getMessage());
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        throw new DAOException(e.getMessage());
                    }
                }
             }
        }
        
        else {
            
             try {


                Connection conn = daoFactory.getConnection();

                if (conn.isValid(0)) {
                    ps = conn.prepareStatement(QUERY_UPDATE);
                    ps.setInt(1, absenteeism.getEmployee().getId());
                    ps.setObject(2, absenteeism.getPayPeriod());
                    ps.setDouble(3, absenteeism.getPercentage());
                
                    int update = ps.executeUpdate();
                    if(update == 1) {
                        boolean hasresults = true;
                    }
                    
                }
                
                
             }  catch (SQLException e) {
                throw new DAOException(e.getMessage());
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        throw new DAOException(e.getMessage());
                    }
                }
             }
        }
        return absenteeism;
    }
}

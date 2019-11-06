/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class DAO {
    /**
     *
     */
    protected final DataSource myDataSource;   
    	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        
        public List<String> getDiscountCode() throws DAOException, SQLException{
           
            List<String> result = new LinkedList<>();
               
            String sql = "SELECT DISTINCT DISCOUNT_CODE FROM DISCOUNT_CODE";
		
               try (	Connection connection = myDataSource.getConnection(); 
			Statement stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String state = rs.getString("DISCOUNT_CODE");
				result.add(state);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return result;
            
        }

                public List<Double> getRATE() throws DAOException, SQLException{
           
            List<Double> result = new LinkedList<>();
               
            String sql = "SELECT RATE FROM DISCOUNT_CODE";
		
               try (	Connection connection = myDataSource.getConnection(); 
			Statement stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				double state = rs.getDouble("RATE");
				result.add(state);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return result;
            
        }
                
                
                
           public List<entity> getEntity() throws DAOException, SQLException {
               
               List<String> S = getDiscountCode();
               List<Double> D = getRATE();
               List<entity> E = new LinkedList<entity>();
               for(int i = 0 ; i < S.size(); i++){
                E.add(new entity(S.get(i), D.get(i)));
               
               
               }
               
               
            
               
               return E;
               
                }
           
           }
        


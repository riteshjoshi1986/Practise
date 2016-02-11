/**
 * 
 */
package Utilities;

/**
 * @author rj0844
 *
 */
import  java.sql.Connection;        
import  java.sql.Statement;     
import  java.sql.ResultSet;     
import  java.sql.DriverManager;     
import  java.sql.SQLException;      

public class  DBConnection {                
        public static void  main(String[] args) throws  ClassNotFoundException, SQLException {                                                  
                //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"        
                String dbUrl = "jdbc:sqlserver://cahywr1pacepd06//dd_pacexx02";                   
 
                //Database Username     
                String username = "ITSERVICES\rj0844";   
                 
                //Database Password     
                String password = "";             
 
                //Query to Execute      
                String query = "SELECT * FROM [PACE_TaskUpdate_Mobility].[dbo].[Requests] where Id = '204099'";
                 
                //Load mysql jdbc driver        
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         
            
                //Create Connection to DB       
                Connection con = DriverManager.getConnection(dbUrl,username,password);
           
                //Create Statement Object       
               Statement stmt = con.createStatement();                  
        
                // Execute the SQL Query. Store results in ResultSet        
                ResultSet rs= stmt.executeQuery(query);                         
          
                // While Loop to iterate through all data and print results     
                while (rs.next()){
                            String myName = rs.getString(1);                                        
                            String myAge = rs.getString(2);                                                
                            System. out.println(myName+"  "+myAge);     
                    }       
                 // closing DB Connection       
                con.close();            
        }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Getters.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Santos
 */
public class LoginModel {
    
  
  DBconnection connectionModel = new DBconnection();

    String dbServer = connectionModel.dbServer;
    String user = connectionModel.user;
    String password = connectionModel.password;
    Connection conn = null;
    Statement stmt = null;
    
    // Constructor. This guy is starting the DB connection and 
    // putting everything in the variables declared above
    public LoginModel(){
        
        
        
        try{
            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password) ;

            // Get a statement from the connection
            stmt = conn.createStatement() ;

        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
    }
    
    // This method is only in charge of asking the DB if a user exists
    // Notice that it is using the variables initialised by the constructor
    public boolean login(User userLogged){
        
        // Variable to define if the login is successful
        boolean login = false;
        
        
        try{
            // Building the query
            String query = "SELECT * FROM main_admin WHERE Username = '" + userLogged.getUn() + "' AND admin_password = '" + userLogged.getPw() + "';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query) ;

            
            login = rs.next();
            
             userLogged.setId(rs.getInt("idMain_admin"));
            userLogged.setFname(rs.getString("First_Name"));
            userLogged.setLname(rs.getString("Second_name")); 
            userLogged.setemail(rs.getString("Email"));
           userLogged.setpassword(rs.getString("admin_password"));
            
            
           
           
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:llllll" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }

        // Retuning the login status
        return login;
    }
    public boolean logincus(User userLogged){
        
        // Variable to define if the login is successful
        boolean logincus = false;
        try{
            // Building the query
            String query = "SELECT * FROM user WHERE Username = '" + userLogged.getUn() + "' AND Password = '" + userLogged.getPw() + "';";

            // Sending the query to the database
            ResultSet rs2 = stmt.executeQuery(query) ;

            // If there is an entry in the database that satisfies
            // the username and password, then the login is successful
            // otherwise it fails
            logincus = rs2.next();
            
            userLogged.setId(rs2.getInt("Costumer_ID"));
            userLogged.setFname(rs2.getString("First_Name"));
            userLogged.setLname(rs2.getString("Last_name")); 
            userLogged.setemail(rs2.getString("Email"));
           userLogged.setpassword(rs2.getString("Password"));
            userLogged.setAddress(rs2.getString("Address"));
            
           // int cost = userLogged.setId(rs.getInt("Costumer_ID"));
            
            System.out.println();
            // Close the result set, statement and the connection
            rs2.close() ;

            // Calling the method in charge of closing the connections
            closings();
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }

        // Retuning the login status
        return logincus;
    }
        
    // This method is only in charge of saving a new user into the the DB
   
    // Separeating closing statements for better code structure
    private void closings(){
        try {            
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}

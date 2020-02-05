/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Getters.User;
/**
 *
 * @author Jonathan Santos
 */
public class registermodel {
    
    // getting the connection from the DBconnection
   DBconnection connectionModel = new DBconnection();

    String dbServer = connectionModel.dbServer;
    String user = connectionModel.user;
    String password = connectionModel.password;
    Connection conn = null;
    Statement stmt = null;
    
   
    //this constructor is responsable for starting the connection
    public registermodel(){
        
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
    // after getting all the information from the view the "register' is creating a query for register the user
    public void register(User reg){
        
        try{
            // Building the query 
            String query = "INSERT INTO user (Username, First_Name, Last_Name, Email, Password, Address) VALUES ('"+reg.getUn()+"', '"+reg.getFm()+"', '"+reg.getLm()+"', '"+reg.getEm()+"', '"+reg.getPw()+"', '"+reg.getAd()+"');";

            // Execute the query
            stmt.execute(query) ;

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


    }
    
    // Separeating closing statements for better code structure
    private void closings(){
        try {            
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
             Logger.getLogger(registermodel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}

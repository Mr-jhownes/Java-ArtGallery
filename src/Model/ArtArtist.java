/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Getters.Art;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Getters.Artist;
import Getters.User;

/**
 *
 * @author Jonathan Santos
 */
public class ArtArtist {
    
    DBconnection connectionModel = new DBconnection();

    String dbServer = connectionModel.dbServer;
    String user = connectionModel.user;
    String password = connectionModel.password;
    Connection conn = null;
    Statement stmt = null;
    


public ArtArtist(){

 try{
			
    
                         conn = DriverManager.getConnection(dbServer, user, password) ;

			// Get a statement from the connection
			stmt = conn.createStatement() ;
        
    } catch( SQLException se ){
			System.out.println( "SQL Exception:1" ) ;

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
// constructor to get art and artist
 public String[][] printArt(){
            
                       
            String[][] result = null;
            
                        try {
                        //executing two queries, the first one to know how many rows are in the database
			String query = "SELECT * FROM art";
                        String query2 = "SELECT * FROM art inner join artist ON art.Artist_Artist_ID = artist.Artist_ID;";
                        

			

			// Execute the query
			ResultSet rs = stmt.executeQuery(query) ;
                        
                        
                        
                        //starting row from 0
                        int rows = 0;
                        //while the resultset has next keep reading
                        while(rs.next()){
                            rows++;
                            
                        }
			// the second query gets the value and store inside the array
                        ResultSet rs2 = stmt.executeQuery(query2) ;
                        result = new String[rows][5];
                        
			int row = 0;
                        
                        
                        
                        
			// Loop through the result set
			while(rs2.next()) {
                            //retrieving the data needed so it will be accessible in another class
                                
                                result[row][0] = rs2.getString("ART_id");
				result[row][1] = rs2.getString("Piece_name");
                                result[row][2] = rs2.getString("Type");
                                result[row][3] = rs2.getString("First_name");
                                result[row][4] = rs2.getString("Last_name");
                                
                                
                               // result[jb] = rs.getString("first_name");
                                row++;
			}

			
		}
		
		catch( Exception e ){
			System.out.println( e ) ;
		}
                return result;
            
            
            
    }

 
 public String[][] printArtist() {
            
                       
            String[][] resultartist = null;
            
                        try {
                        //executing two queries, the first one to know how many rows are in the database
			String query = "SELECT * FROM artist";
                        String query2 = "SELECT * FROM artist;";
                        

			

			// Execute the query
			ResultSet rs = stmt.executeQuery(query) ;
                        
                        
                        
                        
                        int rows = 0;
                        
                        while(rs.next()){
                            rows++;
                            
                        }
			
                        ResultSet rs2 = stmt.executeQuery(query2) ;
                        resultartist = new String[rows][5];
                        
			int row = 0;
                        
                        
                        
                        
			// Loop through the result set
			while(rs2.next()) {
                            
                                
                                resultartist[row][0] = rs2.getString("Artist_ID");
				resultartist[row][1] = rs2.getString("First_name");
                                resultartist[row][2] = rs2.getString("Last_name");
                                resultartist[row][3] = rs2.getString("Website");
                                resultartist[row][4] = rs2.getString("Address");
                                
                                
                               // result[jb] = rs.getString("first_name");
                                row++;
			}

			// Close the result set, statement and the connection
			//rs.close() ;
			//stmt.close() ;
			//conn.close() ;
		}
		
		catch( Exception e ){
			System.out.println( e ) ;
		}
                return resultartist;
            
            
            
    }

 public void deleteart(Art artdelete) {
        
        try{
            // this queries built  are made because of the foreign key on the favorites table
            //the first query checks if there are any art on favorites
            //the second query deletes this art id from the favorites
            //the third deletes the art from the art table
            String query = "SELECT* FROM favorites WHERE ART_Art_ID = '"+artdelete.GetId()+"';";
            String query1 = "DELETE FROM favorites WHERE ART_Art_ID = '"+artdelete.GetId()+"';";
            String query2= "DELETE FROM art WHERE Art_ID = '"+artdelete.GetId()+"';";
            // Sending the query to the database
           if(stmt.execute(query)){
               stmt.execute(query1);
               stmt.execute(query2);
               
           }
           else {
               stmt.execute(query2);
           }
           
       
           
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:here" ) ;

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
       
    }

    public void createArtist(Artist newartist) {
        try{
            // Building the query 
            String query = "INSERT INTO artist ( First_name, Last_name, Website, Address) VALUES ( '"+newartist.GetName()+"', '"+newartist.GetLastName()+"','"+newartist.GetWebsite()+"', '"+newartist.GetAddress()+"');";

            // Execute the query
            stmt.execute(query) ;

            // Calling the method in charge of closing the connections
            //closings();
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

    public void deleteArtist(Artist artistdelete) {
        try{
            // Building the query
            
            String query = "SELECT* FROM art WHERE Artist_Artist_ID = '"+artistdelete.GetId()+"';";
            String query1 = "DELETE FROM art WHERE Artist_Artist_ID = '"+artistdelete.GetId()+"';";
            String query2= "DELETE FROM artist WHERE Artist_ID = '"+artistdelete.GetId()+"';";
            // Sending the query to the database
           if(stmt.execute(query)){
               stmt.execute(query1);
               stmt.execute(query2);
               
           }
           else {
               stmt.execute(query2);
           }
           
       
           
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:here" ) ;

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

    public void like(Art artid, User myuser) {
        try {

            // Building the query 
            String query = "INSERT INTO favorites (ART_Art_ID, USER_Costumer_ID) VALUES ('" + artid.GetId() + "', '" + myuser.getId() + "')";

            // Execute the query
            stmt.execute(query);

            // Calling the method in charge of closing the connections
            //closings();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
         }
    
    public String[][] liked() {
        
        User myuser = new User();
        String[][] result = null;
        
        try{
            // Building the query 
            String query1 = "Select * FROM favorites";
            String query2 = "SELECT * FROM favorites JOIN art ON ART_Art_ID = Art_ID JOIN artist ON Artist_Artist_ID = Artist_ID WHERE USER_Costumer_ID= '"+myuser.getId()+"';" ;

            // Execute the query
           
            ResultSet rs = stmt.executeQuery(query1) ;
                        
                        
                        
                        
                        int rows = 0;
                        
                        while(rs.next()){
                            rows++;
                            
                        }
			
                        ResultSet rs2 = stmt.executeQuery(query2) ;
                        result = new String[rows][5];
                        
			int row = 0;
                        
                        
                        
                        
			// Loop through the result set
			while(rs2.next()) {
                            
                                
                                result[row][0] = rs2.getString("ART_id");
				result[row][1] = rs2.getString("Piece_name");
                                result[row][2] = rs2.getString("Type");
                                result[row][3] = rs2.getString("First_name");
                                result[row][4] = rs2.getString("Last_name");;
                                
                                
                               // result[jb] = rs.getString("first_name");
                                row++;
			}

            // Calling the method in charge of closing the connections
            //closings();
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
        
        return result;


    }

}



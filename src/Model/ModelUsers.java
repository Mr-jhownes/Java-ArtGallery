
package Model;

import Getters.Art;
import Getters.Artist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Getters.User;

public class ModelUsers {
    
                         DBconnection connectionModel = new DBconnection();

                         String dbServer = connectionModel.dbServer;
                         String user = connectionModel.user;
                         String password = connectionModel.password;
                         Connection conn = null;
                         Statement stmt = null;
                        
                        
    public ModelUsers(){
        
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
    
 
        
        public String[][] printAdm(){
            
                       
            String[][] resultadm = null;
            
                        try {
                        
			String query = "SELECT * FROM main_admin";
                        String query2 = "SELECT * FROM main_admin";
                        
//art.Piece_Name, art.Type, artist.First_name, artist.Last_name    
			// Get a connection to the database
			

			// Execute the query
			ResultSet rs = stmt.executeQuery(query) ;
                        
                        int rows = 0;
                        
                        while(rs.next()){
                            rows++;
                            
                        }
			
                        ResultSet rs2 = stmt.executeQuery(query2) ;
                        resultadm = new String[rows][5];
                        
			int row = 0;
                        
                        
                        
                        
			// Loop through the result set
			while(rs2.next()) {
                            
                                
                                resultadm[row][0] = rs2.getString("idMain_admin");
				resultadm[row][1] = rs2.getString("First_name");
                                resultadm[row][2] = rs2.getString("Second_name");
                                resultadm[row][3] = rs2.getString("Username");
                                resultadm[row][4] = rs2.getString("Email");
                                
                                
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
                return resultadm;
            
            
            
    }
        public void update(User upd, User myuser){
        
        try{
            
            boolean up = false;
            // Building the query 
            String query = "UPDATE user SET Username='"+upd.getUn()+"', First_Name='"+upd.getFm()+"', Last_name='"+upd.getLm()+"', Email='"+upd.getEm()+"', Password='"+upd.getPw()+"', Address='"+upd.getAd()+"' WHERE Costumer_ID = '"+myuser.getId()+"';";

            // Execute the query
            stmt.execute(query) ;

            // Calling the method in charge of closing the connections
            //closings();
            stmt.close();
            //conn.close();
            
            myuser.setUsername(upd.getUn());
            myuser.setFname(upd.getFm());
            myuser.setLname(upd.getLm());
            myuser.setemail(upd.getEm());
            myuser.setpassword(upd.getPw());
            myuser.setAddress(upd.getAd());
            
            
            
            
            
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


    public void delAdm(User userDelete) {
        
        
        
        //boolean login = false;
        
        
        try{
            // Building the query
            String query = "DELETE FROM main_admin WHERE idMain_admin = '"+userDelete.getId()+"';";

            // Sending the query to the database
            stmt.execute(query);

            
            
            
             
            
            
           
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

    public void AdminUpdate(User updateAdmin, User adminUser) {
        
        try{
            
            boolean up = false;
            // Building the query 
            String query = "UPDATE main_admin SET First_Name='"+updateAdmin.getFm()+"', Second_name='"+updateAdmin.getLm()+"', Username='"+updateAdmin.getUn()+"', Email='"+updateAdmin.getEm()+"', admin_password='"+updateAdmin.getPw()+"' WHERE idMain_admin = '"+adminUser.getId()+"';";

            // Execute the query
            stmt.execute(query) ;

            // Calling the method in charge of closing the connections
            //closings();
            stmt.close();
            //conn.close();
            
            
            adminUser.setFname(updateAdmin.getFm());
            adminUser.setLname(updateAdmin.getLm());
            adminUser.setUsername(updateAdmin.getUn());
            adminUser.setemail(updateAdmin.getEm());
            adminUser.setpassword(updateAdmin.getPw());
            
            
            
            
            
            
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

    

    public void createUser(User newuser) {
       try{
            // Building the query 
            String query = "INSERT INTO main_admin ( First_name, Second_name, Username, Email, admin_Password) VALUES ( '"+newuser.getFm()+"', '"+newuser.getLm()+"','"+newuser.getUn()+"', '"+newuser.getEm()+"', '"+newuser.getPw()+"');";

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

    public String[][] printcustomer() {
       
        String[][] resultcus = null;
            
                        try {
                        
			String query = "SELECT * FROM user";
                        String query2 = "SELECT * FROM user";
                        
//art.Piece_Name, art.Type, artist.First_name, artist.Last_name    
			// Get a connection to the database
			

			// Execute the query
			ResultSet rset = stmt.executeQuery(query) ;
                        
                        int rows = 0;
                        
                        while(rset.next()){
                            rows++;
                            
                        }
			
                        ResultSet rset2 = stmt.executeQuery(query2) ;
                        resultcus = new String[rows][6];
                        
			int row = 0;
                        
                        
                        
                        
			// Loop through the result set
			while(rset2.next()) {
                            
                                
                                resultcus[row][0] = rset2.getString("Costumer_ID");
				resultcus[row][1] = rset2.getString("Username");
                                resultcus[row][2] = rset2.getString("First_name");
                                resultcus[row][3] = rset2.getString("Last_name");
                                resultcus[row][4] = rset2.getString("Email");
                                resultcus[row][5] = rset2.getString("Email");
                                
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
                return resultcus;
            
            
            
    }

    public void deleteCus(User userdelete) {
        try{
            // Building the query
            String query = "DELETE FROM user WHERE Costumer_ID = '"+userdelete.getId()+"';";

            // Sending the query to the database
            stmt.execute(query);

            
            
            
             
            
            
           
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
    
    
    
    }
 
    

    
        
    
        
    
    
    



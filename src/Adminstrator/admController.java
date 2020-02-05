/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminstrator;

import Model.ModelUsers;
import Getters.Art;
import Getters.Artist;
import Login.LoginController;
import Getters.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.ArtArtist;

/**
 *
 * @author Jonathan Santos
 */
public class admController implements ActionListener {
   
//referencing all the elements used
    ModelUsers model;
    ArtArtist model2;
    
    admWindow view;
    admListNames view2;
    admUpdateAdmWindow view3;
    ArtistList view4;
    ArtList view5;
    newAdminWindow view6;
    NewArtistWindow view7;
    customerListWindow view8;
    
    public User adminUser;
    LoginController login;
    User userdelete;
    Art artdelete;
    User newuser;
    Artist newartist;
    Artist artistdelete;
    
    
    public admController(User userLogged){
        //userlogged has the information from the admin that is logged
        this.adminUser = userLogged;
        
// models used for queries of art, artist, admin and user  
        model = new ModelUsers();
        model2 = new ArtArtist();
// after login as admin, opening the first window
        view = new admWindow(this);
      
        
             
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // button to open the table of the artist
        if(e.getActionCommand().equals("artist")){
           view4 = new ArtistList(this);
        
    }
        //button that opens the window for register new artist
        else if (e.getActionCommand().equals("createartist")){
            
            view7 = new NewArtistWindow(this);
            
        }
        // button create the artist
        else if (e.getActionCommand().equals("create")){
            
            //retrieving the information with getters
        String fm = view7.getFname();
        String lm = view7.getLname();
        String wb = view7.getWebsite();
        String ad = view7.getAddress();
        
        
        Artist newartist = new Artist(fm, lm, wb, ad);
 //using constructor in the model to execute the query
            model2.createArtist(newartist);
            
            // close the form window
            view7.dispose();
            
            // closing the table window
            view4.dispose();
            
            //reopening the window with the information updated
            view4 = new ArtistList(this);
            
        }
        //  button to delete artist
        else if(e.getActionCommand().equals("deleteartist")){
            this.artistdelete = view4.GetArtistSelected();
            //sending the artist selected to the model and executing the delete query
            model2.deleteArtist(artistdelete);
            view4.dispose();
            //reopening the window with the information updated
            view4 = new ArtistList(this);
            
        }
        else if(e.getActionCommand().equals("art")){
            // button to send the admin to artist table
            view5 = new ArtList(this);
           
           
    }
        //button to delete art
        else if(e.getActionCommand().equals("Deleteart")) {
            this.artdelete = view5.GetArtSelected();
            model2.deleteart(artdelete);
            
        }
        //button to open the customer window with their table
        else if(e.getActionCommand().equals("customers")){
            
            view8 = new customerListWindow(this);
            
        }
        // button that gets the customer selected and send to model so it will be deleted
        else if(e.getActionCommand().equals("deletecustomer")){
            
            this.userdelete = view8.GetUserSelected();
            model.deleteCus(userdelete);
            
            view8.dispose();
            //reopening the window with the information updated
            view8 = new customerListWindow(this);
            
        }
        // button to open the window of admin table
        else if(e.getActionCommand().equals("adminlist")) {
          
            view2 = new admListNames(this);
           
    }
       // button to updated information of the user loged
        else if (e.getActionCommand().equals("updateadmin")) {
            
            view3 = new admUpdateAdmWindow(this, this.adminUser);
            
        }
         
        
        else if (e.getActionCommand().equals("updateprofile")){
            
        String un = view3.getUsername();
        String fm = view3.getFname();
        String lm = view3.getLname();
        String em = view3.getemail();
        String pw = view3.getpassword();
       
        User updateAdmin = new User(un, fm, lm, em, pw);
        
        this.model.AdminUpdate(updateAdmin, adminUser);
        
        view3.dispose();
        
            
        }
        // button to get the admin selected and sending to model to be deleted
        else if (e.getActionCommand().equals("Deleteadmin")){
            
            this.userdelete = view2.GetUserSelected();
            model.delAdm(userdelete);
            view2.dispose();
            //reopening the window with the information updated
            view2 = new admListNames(this);
            
        }
        //button to open the form to create new admin
        else if (e.getActionCommand().equals("newadmin")){
            view6 = new newAdminWindow(this);
            
        }
        //button to create the new admin, after the form being fullfield 
        else if (e.getActionCommand().equals("createadmin")){
            
        String un = view6.getUsername();
        String fm = view6.getFname();
        String lm = view6.getLname();
        String em = view6.getemail();
        String pw = view6.getpassword();
        
        
        
        User newuser = new User(un, fm, lm, em, pw);
        
            
        // sendint to the model with the information retrieved and create a new admin
            model.createUser(newuser);
            
            view6.dispose();
            view2.dispose();
            view2 = new admListNames(this);
            
        }
        //button to log out and send it back to login gae
        else if (e.getActionCommand().equals("logout")){
          
            login = new LoginController();
            
            view.dispose();
            
        }
        //in case none of the ifs works, it sends a message of error
        else{
            System.out.println("error");
        }
}
    
}


package Customer;

import Model.ModelUsers;
import Adminstrator.admController;
import Customer.WelcomeCustomer;
import Getters.Art;
import Login.LoginController;
import Getters.User;
import Model.ArtArtist;
import Register.registerController;
import Register.registerWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Jonathan Santos
 */
public class customerController implements ActionListener {
    
    //referencing all the elements
    public ModelUsers model;
    WelcomeCustomer view;
    public User myuser;
    LoginController login;
    customerUpdateWindow view2;
    ArtArtist model2;
    Art artid;
    favorites view3;
    
    public customerController(User userLogged){
   //myuser brings the information of the user logged 
        this.myuser = userLogged;
        model = new ModelUsers();
        model2 = new ArtArtist();
        
         //after the user is logged open the main window
        view = new WelcomeCustomer(this);
        
        
    
    
}
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
         
       
        
        // 
        if (e.getActionCommand().equals("bt2")){
            
            view2 = new customerUpdateWindow(this, this.myuser);
            
        }
        
        else if (e.getActionCommand().equals("like")){
            this.artid = view.GetArtSelected();
            model2.like(artid, this.myuser);
            
            
        }
        
        else if (e.getActionCommand().equals("favorites")){
            
            view3 = new favorites(this);
        }
        else if (e.getActionCommand().equals("bt")){
                
            
           //retrieving information from view and storing 
        String un = view2.getUsername();
        String fm = view2.getFname();
        String lm = view2.getLname();
        String em = view2.getemail();
        String pw = view2.getpassword();
        String ad = view2.getAddress();
        
        User upd = new User(un, fm, lm, em, pw, ad);
        // sending the info collected to the model so it can execute the query
        this.model.update(upd, myuser);
        view2.dispose();
        
            }
        
        else if (e.getActionCommand().equals("bt1")){
            
            //button the log out sending back to login window
            login = new LoginController();
            
         
            view.dispose();
            
           
        }
        
        }
    }
    



package Register;

;
import Customer.WelcomeCustomer;
import Login.LoginController;
import Model.LoginModel;
import Login.LoginWindow;
import Getters.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Register.registerWindow;
import Model.registermodel;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jonathan Santos
 */
public class registerController implements ActionListener{
    //referencing the elements
    registermodel model2;
    registerWindow view2;
    WelcomeCustomer welcome3;
    LoginController login;
    
    public registerController(){
        // when the controller starts it will firstly open the view2
          view2 = new registerWindow(this);
          model2 = new registermodel();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //storing all the information coming from the user  so its possible to send to the view
       String un = view2.getUsername();
        String fm = view2.getFname();
        String lm = view2.getLname();
        String em = view2.getemail();
        String pw = view2.getpassword();
        String ad = view2.getAddress();
        
        
       
        
        if(e.getActionCommand().equals("b3")){
            
        // in case the user left any information empty show message
        if (un.equals("")) {
                showMessageDialog(null, "Username missing");
            }
            else if (fm.equals("")) {
                showMessageDialog(null, "First Name is missing");
            }
            else  if (lm.equals("")) {
                showMessageDialog(null, "Second Name is missing");
            }
            else if (em.equals("")) {
                showMessageDialog(null, "Email is missing");
            }
            else if (pw.equals("")) {
                showMessageDialog(null, "Password is missing");
            }
            else if (ad.equals("")) {
                showMessageDialog(null, "Address is missing");
            }
        
            else{
           
        
        
        
        
            // else everything ok, send to the model
            User reg = new User(un, fm, lm, em, pw, ad);
            // message to inform that the user is registered
            showMessageDialog(null, "User Registered");
        
            model2.register(reg);
            
            //after register the page goes back to login, so the user can be logged
            new LoginController();
            // close the windows register
            view2.dispose();
            
            
        }
       
            }
        
    }
    
}
   

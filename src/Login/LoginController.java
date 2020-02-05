/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;


import Model.LoginModel;
import Getters.User;
import Adminstrator.admController;
import Customer.WelcomeCustomer;
import Customer.customerController;
import Register.registerController;
import Register.registerWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jonathan Santos
 */


public class LoginController implements ActionListener {
    
    //referencing the elements that are being used for login or register
    LoginModel model;
    LoginWindow view;
    WelcomeCustomer welcome2;
    registerController regcontroller;
    customerController customcontroler;
    admController admcontroller;
    User myuser;
    
    
    public LoginController() {
        // before opening the view checking the queries made in the model
        this.model = new LoginModel();
        this.view = new LoginWindow(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
      
       // creating two variables to allocate the information that the user have inserted
       String un = view.getUsername();
        String pw = view.getPassword();
        
        this.myuser = new User(un, pw);
        
        // When the button is clicked...
        if(e.getActionCommand().equals("b")){

            // Ask the model if the user is valid
            
            boolean login = model.login(myuser);
            boolean logincus = model.logincus(myuser);
            
            System.out.println(login);
            
            
            // if the it is valid, show the welcome screen and close the login
            if(login){
             
                new admController(myuser);
                view.dispose();
            }
            // in case the user is not a Admin it should go to if else where it goes to customer page
            else if (logincus){
                
                new customerController(myuser);
                
                view.dispose();
                
            }
                             
            
        }
        
        // in case clicked on register open the window for registering 
        else if (e.getActionCommand().equals("b2")){
            
            
            regcontroller = new registerController();
            
         
                
           
            view.dispose();
            
           
            
        }
        
        else {
            System.out.println("error");
        }
    }
    
    //using method get
    public User getmyuser(){
        return this.myuser;
        
      }
    public LoginWindow GetLoginWindow(){
        return this.view;
    }
    
}
    
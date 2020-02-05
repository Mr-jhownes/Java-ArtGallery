/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminstrator;

import Register.registerController;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan Santos
 */
public class newAdminWindow extends JFrame {
    
    //declaring variables
    private JTextField txtf;
    private JTextField txtf2;
    private JTextField txtf3;
    private JTextField txtf4;
    private JTextField txtf5;
    private admController internalcontroller; 
    
    
    //informing the constructor who is the controller
    public newAdminWindow(admController controller){
        
        this.internalcontroller = controller; 
        
        //encapsulation of the bulding process;
        attributesSetter();
        components();
        validation();
        
        
    }
    // defining the attributes
    private void attributesSetter(){
        
        this.setVisible(true);
        this.setSize(250,400);
        this.setTitle("Register");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }
    
    private void components(){
        
        JPanel pn = new JPanel();
        this.add(pn);
        
        // textfield to be filled up and create new admin
        JLabel lb = new JLabel("Username");
        pn.add(lb);
        txtf = new JTextField(20);
        pn.add(txtf);
        
        JLabel lb2 = new JLabel("First Name");
        pn.add(lb2);
        txtf2 = new JTextField(20);
          pn.add(txtf2);
        
        JLabel lb3 = new JLabel("Last Name");
        pn.add(lb3);
        txtf3 = new JTextField(20);
         pn.add(txtf3);
        
        JLabel lb4 = new JLabel("Email");
        pn.add(lb4);
         txtf4 = new JTextField(20);
        pn.add(txtf4);
        
        JLabel lb5 = new JLabel("password");
        pn.add(lb5);
         txtf5 = new JTextField(20);
        pn.add(txtf5);
        
        
        JButton btn = new JButton("Create");
        btn.addActionListener((ActionListener) internalcontroller);
        btn.setActionCommand("createadmin");
        
         pn.add(btn);
        
    }
//setting the validation
    private void validation(){
        
        this.validate();
        this.repaint();
        
        
    }
    //getters to retrieve the data collected from the admin
    public String getUsername(){
        return txtf.getText();
    }
    public String getFname(){
        return txtf2.getText();
    }
    public String getLname(){
        return txtf3.getText();
    }
    public String getemail(){
        return txtf4.getText();
    }
    public String getpassword(){
        return txtf5.getText();
    }

    
    
}


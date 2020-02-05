/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;
import Getters.User;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class customerUpdateWindow extends JFrame{
    
    private JTextField txtf;
    private JTextField txtf2;
    private JTextField txtf3;
    private JTextField txtf4;
    private JTextField txtf5;
    private JTextField txtf6;
    private customerController internalcontroller; 
    private User userlogged;
    
    
    
    public customerUpdateWindow(customerController controller, User userLogged){
        
        this.internalcontroller = controller; 
        this.userlogged = userLogged;
        attributesSetter();
        components();
        validation();
        
        
    }
    
    private void attributesSetter(){
        
        this.setVisible(true);
        this.setSize(250,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Profile");
        
    }
    
    private void components(){
        
        JPanel pn = new JPanel();
        this.add(pn);
        
        
        JLabel lb = new JLabel("Username");
        pn.add(lb);
        txtf = new JTextField(this.userlogged.getUn(),20);
        pn.add(txtf);
        
        JLabel lb2 = new JLabel("First Name");
        pn.add(lb2);
        txtf2 = new JTextField(this.userlogged.getFm(),20);
       
          pn.add(txtf2);
        
        JLabel lb3 = new JLabel("Last Name");
        pn.add(lb3);
        txtf3 = new JTextField(this.userlogged.getLm(),20);
         pn.add(txtf3);
        
        JLabel lb4 = new JLabel("Email");
        pn.add(lb4);
         txtf4 = new JTextField(this.userlogged.getEm(),20);
         
         
        pn.add(txtf4);
        
        JLabel lb5 = new JLabel("password");
        pn.add(lb5);
         txtf5 = new JTextField(this.userlogged.getPw(), 20);
        pn.add(txtf5);
        
        JLabel lb6 = new JLabel("Address");
        pn.add(lb6);
         txtf6 = new JTextField(this.userlogged.getAd(),20);
        pn.add(txtf6);
        
        JButton btn = new JButton("Update Profile");
        btn.addActionListener((ActionListener) internalcontroller);
        btn.setActionCommand("bt");
        
         pn.add(btn);
        
    }
    
    private void validation(){
        
        this.validate();
        this.repaint();
        
        
    }
    
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
     public String getAddress(){
        return txtf6.getText();
    }
    
}



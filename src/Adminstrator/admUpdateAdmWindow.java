/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminstrator;

import Getters.User;
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
public class admUpdateAdmWindow extends JFrame {
    
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;
    private JTextField txt5;
    private admController controllerint;
    private User adminLogged;
    
    public admUpdateAdmWindow(admController controller, User userLogged){
        
        this.controllerint = controller;
        this.adminLogged = userLogged;
        
        this.setVisible(true);
        this.setSize(250,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Update profile");
        
        
        JPanel pn = new JPanel();
        this.add(pn);
        
        
        JLabel lb = new JLabel("Username");
        pn.add(lb);
        txt1 = new JTextField(this.adminLogged.getUn(),20);
        pn.add(txt1);
        
        JLabel lb2 = new JLabel("First Name");
        pn.add(lb2);
        txt2 = new JTextField(this.adminLogged.getFm(),20);
       
          pn.add(txt2);
        
        JLabel lb3 = new JLabel("Last Name");
        pn.add(lb3);
        txt3 = new JTextField(this.adminLogged.getLm(),20);
         pn.add(txt3);
        
        JLabel lb4 = new JLabel("Email");
        pn.add(lb4);
         txt4 = new JTextField(this.adminLogged.getEm(),20);
         
         
        pn.add(txt4);
        
        JLabel lb5 = new JLabel("password");
        pn.add(lb5);
         txt5 = new JTextField(this.adminLogged.getPw(), 20);
        pn.add(txt5);
        
        
        
        JButton btn = new JButton("Update Profile");
        btn.addActionListener((ActionListener) controllerint);
        btn.setActionCommand("updateprofile");
        
         pn.add(btn);
        
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        this.validate();
        this.repaint();
        
        
        
    }

    String getUsername() {
        return txt1.getText();
    }

    String getFname() {
        return txt2.getText();
    }

    String getLname() {
        return txt3.getText();
    }

    String getemail() {
        return txt4.getText();
    }

    String getpassword() {
        return txt5.getText();
    }
    
}

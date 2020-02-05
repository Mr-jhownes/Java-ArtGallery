/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminstrator;

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


public class NewArtistWindow extends JFrame{
   
    //declaring variables
     private JTextField txt;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;
    
    private admController intcontroller; 
    
    
    //informing the constructor who is the controller
    public NewArtistWindow (admController controller){
        
        this.intcontroller = controller; 
        
        //encapsulation of the bulding process;
        attributesSetter();
        components();
        validation();
        
        
    }
    // defining the attributes
    private void attributesSetter(){
        
        this.setVisible(true);
        this.setSize(250,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Create New Artist");
        
    }
    //defining the components
    private void components(){
        
        JPanel pn = new JPanel();
        this.add(pn);
        
        
        
        // txt field to be fullfield 
        JLabel lb2 = new JLabel("First Name");
        pn.add(lb2);
        txt2 = new JTextField(20);
          pn.add(txt2);
        
        JLabel lb3 = new JLabel("Last Name");
        pn.add(lb3);
        txt3 = new JTextField(20);
         pn.add(txt3);
         
         JLabel lb = new JLabel("Website");
        pn.add(lb);
        txt = new JTextField(20);
        pn.add(txt);
        
        JLabel lb4 = new JLabel("Email");
        pn.add(lb4);
         txt4 = new JTextField(20);
        pn.add(txt4);
        
        
        
        //button to creat the artist
        JButton btn = new JButton("Create Artist");
        btn.addActionListener((ActionListener) intcontroller);
        btn.setActionCommand("create");
        
         pn.add(btn);
        
    }
    //setting the validation
    private void validation(){
        
        this.validate();
        this.repaint();
        
        
    }
    
    //getters to retrieve the data collected from the admin
    public String getFname(){
        return txt2.getText();
    }
    public String getLname(){
        return txt3.getText();
    }
    public String getWebsite(){
        return txt.getText();
    }
    public String getAddress(){
        return txt4.getText();
    }
   

    
    
}



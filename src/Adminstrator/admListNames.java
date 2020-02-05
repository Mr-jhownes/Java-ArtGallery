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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Jonathan Santos
 */
public class admListNames extends JFrame  {
  //declaring  variables outside of the constructor
    JTable mytb;
    String[][] result;
    private admController controllerint;
    
    //informing the constructor who is the controller
    public admListNames(admController controller){
        
        this.controllerint = controller;
        //defining the attributes 
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        JPanel panel = new JPanel();
        this.add(panel);
        //button to create a new admin
        JButton mybtn = new JButton("New admin");
        panel.add(mybtn);
    //using action listeners for this button  
        mybtn.addActionListener((ActionListener)controllerint);
        mybtn.setActionCommand("newadmin");
        
    //button to delete admin
        JButton mybtn2 = new JButton("Delete");
        panel.add(mybtn2);
        mybtn2.addActionListener((ActionListener)controllerint);
        mybtn2.setActionCommand("Deleteadmin");
        
        
        result = null;
   //creating the table of the name of columns
        String[] table = {"Admin Id", "First Name", "Second Name", "Username", "Email"};
        
   //getting the result from the model, storing on the result array
        result = controller.model.printAdm();
        
    //mytb is going to show the table array and result
        this.mytb = new JTable(result, table);
        panel.add(mytb);
        
        
        JScrollPane pnl = new JScrollPane(mytb);
        panel.add(pnl);
        
        
        
        this.validate();
        this.repaint();
        
    }
    //constructor with User type, so the admin that the user clicked can be updated or deleted
    public User GetUserSelected(){
        User UserSelected = new User();
        int getIndexNum = mytb.getSelectedRow();
        // getting the index of the table
        if (getIndexNum > -1) {
            
            String[] selectUser = result[getIndexNum];
         //storing the result inside the array, and using the setters to store the values   
            UserSelected.setId(Integer.parseInt(selectUser[0]));
            UserSelected.setFname(selectUser[1]);
            UserSelected.setLname(selectUser[2]);
            UserSelected.setUsername(selectUser[3]);
            UserSelected.setemail(selectUser[4]);
            
            
        }
        return UserSelected;
        
    }
    public JTable GetTable(){
        
        return this.mytb;
        
        
        
        
    }
    
}

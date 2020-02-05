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
public class customerListWindow extends JFrame {
    
    //declaring variables
    JTable mytb;
    String[][] result;
    private admController controllerint;
    
    //informing the constructor who is the controller
    public customerListWindow(admController controller){
        
        this.controllerint = controller;
        // defining the attributes
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        JPanel panel = new JPanel();
        this.add(panel);
        
//button to delete customer
        JButton mybt = new JButton("Delete");
        panel.add(mybt);
        mybt.addActionListener((ActionListener)controllerint);
        mybt.setActionCommand("deletecustomer");
        
        
        result = null;
 //array to store the columns names
        String[] table = {"Customer Id", "Username", "First Name", "Second Name", "Email", "Address"};
 //gettin the result from the model
        result = controller.model.printcustomer();
        this.mytb = new JTable(result, table);
        panel.add(mytb);
        
        
        JScrollPane pnl = new JScrollPane(mytb);
        panel.add(pnl);
        
        
        
        this.validate();
        this.repaint();
        
    }
    //constructor with User type, so the user that the admin clicked can be updated or deleted
    public User GetUserSelected(){
        User UserSelected = new User();
        int getIndexNum = mytb.getSelectedRow();
        
        if (getIndexNum > -1) {
            
            String[] selectUser = result[getIndexNum];
//storing the result inside the array, and using the setters to store the values            
            UserSelected.setId(Integer.parseInt(selectUser[0]));
            UserSelected.setUsername(selectUser[1]);
            UserSelected.setFname(selectUser[2]);
            UserSelected.setLname(selectUser[3]);
            UserSelected.setemail(selectUser[4]);
            UserSelected.setAddress(selectUser[5]);
            
            
        }
        return UserSelected;
        
    }
    public JTable GetTable(){
        
        return this.mytb;
        
        
        
        
    }
    
}

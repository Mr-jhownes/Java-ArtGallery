/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminstrator;


import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Jonathan Santos
 */
public class admWindow extends JFrame {
    //this class wont have any table to show, but its going to be used to send the admin towards differents pages
    
    
   private admController controllerint;
    
    //informing the constructor who is the controller
     public admWindow(admController controller ){
        
        
        this.controllerint = controller;
        
        
          //defining the attributes 
        this.setVisible(true);
        this.setSize(500, 150);
        this.setLocationRelativeTo(null);
        // lettin the resizable as false so it cant be altered 
        this.setResizable(false);
        
        
       
        
        JPanel p = new JPanel();
        this.add(p);
        
        JMenuBar mymn = new JMenuBar();
        this.setJMenuBar(mymn);
       
        JMenu myMenu = new JMenu ("Menu");
        mymn.add(myMenu);
        
        JMenuItem artist = new JMenuItem("Artists");
        myMenu.add(artist);
        artist.addActionListener((ActionListener)controllerint);
        artist.setActionCommand("artist");
        
        JMenuItem art = new JMenuItem("Art");
        myMenu.add(art);
        art.addActionListener((ActionListener)controllerint);
        art.setActionCommand("art");
        
        JMenuItem customer = new JMenuItem("Customers");
        myMenu.add(customer);
        customer.addActionListener((ActionListener)controllerint);
        customer.setActionCommand("customers");
        
        
        
        
        JMenu myMenu1 = new JMenu ("Profile");
        mymn.add(myMenu1);
        
        
        JMenuItem mItem = new JMenuItem("Update profile");
        myMenu1.add(mItem);
        mItem.addActionListener((ActionListener)controllerint);
        mItem.setActionCommand("updateadmin");
        
             
        JMenu myMenu2 = new JMenu ("Administrators");
        mymn.add(myMenu2);
       
       
        JMenuItem item = new JMenuItem("Admin List");
        myMenu2.add(item);
        item.addActionListener((ActionListener)controllerint);
        item.setActionCommand("adminlist");
        
        JMenuItem myMenuout = new JMenuItem ("Log out");
        mymn.add(myMenuout);
        myMenuout.addActionListener((ActionListener)controllerint);
        myMenuout.setActionCommand("logout");
        
        
        
        
        
       
         
         
         
        
        JLabel label = new JLabel("Welcome  " + controller.adminUser.getUn());
        label.setFont(new Font("VarelaRound-Regular", Font.BOLD, 40));
        p.add(label);
        
        
        
        
        
        this.validate();
        this.repaint();
        
    }

    
    
}
    



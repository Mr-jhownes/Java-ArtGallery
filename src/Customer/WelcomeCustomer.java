/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Getters.Art;
import Getters.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class WelcomeCustomer extends JFrame  {
    
    //declaring variables
    JTable mytb;
    String[][] result;
    private customerController controllerint;
    
    // informing constructor who is the controller
     public WelcomeCustomer(customerController controller ){
        
        
        this.controllerint = controller;
        
        
//defining the attributes 
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
       
        
        JPanel p = new JPanel();
        this.add(p);
        
        JMenuBar mymn = new JMenuBar();
        this.setJMenuBar(mymn);
       
        JMenu myMenu = new JMenu ("Menu");
        mymn.add(myMenu);
        
        //button to check the profile
        JMenuItem myMenuItem1 = new JMenuItem ("Profile");
        myMenu.add(myMenuItem1);
        myMenuItem1.addActionListener((ActionListener)controllerint);
        myMenuItem1.setActionCommand("bt2");
        
        
       
        //button to show their favorites
        JMenuItem myMenuItem2 = new JMenuItem ("My Favorites");
        myMenu.add(myMenuItem2);
        myMenuItem2.addActionListener((ActionListener)controllerint);
        myMenuItem2.setActionCommand("favorites");
        
        //button to log out
        JMenuItem myMenuItem3 = new JMenuItem ("Log out");
        myMenu.add(myMenuItem3);
        myMenuItem3.addActionListener((ActionListener)controllerint);
        myMenuItem3.setActionCommand("bt1");
       
         
         
         JButton like = new JButton("Like");
         p.add(like);
         like.addActionListener((ActionListener)controllerint);
         like.setActionCommand("like");
        
        JLabel label = new JLabel("Welcome " + controller.myuser.getUn());
        p.add(label);
        
        
        //table to show all the art and artist
        result = null;
        
        String[] table = {"Art ID", "Art", "Type", "Artist", "Artist Last Name"};
        
        result = controller.model2.printArt();
        mytb = new JTable(result, table);
        p.add(mytb);
        
        JScrollPane pnl = new JScrollPane(mytb);
        p.add(pnl);
        
        
        
        
         
        
        
        
        this.validate();
        this.repaint();
        
    }
     public Art GetArtSelected(){
         
        Art ArtSelected = new Art();
        // getting the index of the table
        int getIndexNum = mytb.getSelectedRow();
        // the index needs to be bigger than -1, because the array start at 0
        if (getIndexNum > -1) {
            
            String[] selectArt = result[getIndexNum];
            
            ArtSelected.SetId(Integer.parseInt(selectArt[0]));
            ArtSelected.SetName(selectArt[1]);
            ArtSelected.SetType(selectArt[2]);
            
            
            
            
        }
        return ArtSelected;
        
    }
    public JTable GetTable(){
        
        return this.mytb;
        
        
        
        
    }

    
    
}
    


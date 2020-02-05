/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Adminstrator.admController;
import Getters.Art;
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
public class favorites extends JFrame {
    
    User myuser;
    JTable mytb;
    String[][] result;
    private customerController controllerint;
    
    //informing the constructor who is the controller
    public favorites(customerController controller){
        
        this.controllerint = controller;
        
        //defining the attributes 
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        JPanel panel = new JPanel();
        this.add(panel);
        // creating the button dele and adding the actionlistener so It can be called on the constructor
        JButton mybtn2 = new JButton("Dislike");
        panel.add(mybtn2);
        mybtn2.addActionListener((ActionListener)controllerint);
        mybtn2.setActionCommand("deslike");
        
        
        result = null;
        // creating a array to show the table of the contents
        String[] table = {"Art ID", "Art", "Type", "Artist", "Artist Last Name"};
        
        // result is getting result from the query made in the model
        result = controller.model2.liked();
        
       
        // creating a table that will display the result together with the array table
        this.mytb = new JTable(result, table);
        panel.add(mytb);
        //adding scroll panel otherwise the table will not be shown
        JScrollPane pnl = new JScrollPane(mytb);
        panel.add(pnl);
        
        
        
        
        
         
        
        
        
        this.validate();
        this.repaint();
        
    }
    //constructor with Art type, so the art that the user clicked can be updated or deleted
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

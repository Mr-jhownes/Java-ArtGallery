/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminstrator;

import Getters.Artist;
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
public class ArtistList extends JFrame {
        
    //variables being declared
    JTable mytb;
    String[][] result;
    private admController controllerint;
   
//informing the constructor who is the controller
   
    public ArtistList(admController controller){
        
        this.controllerint = controller;
 //defining the attributes 
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.setTitle("Artist");
        
        
        JPanel panel = new JPanel();
        this.add(panel);
        
// button to create new artist
        JButton mybtn = new JButton("Create New Artist");
        panel.add(mybtn);
        mybtn.addActionListener((ActionListener)controllerint);
        mybtn.setActionCommand("createartist");
        
// button to delete the artist
       
        JButton mybtn2 = new JButton("Delete");
        panel.add(mybtn2);
        mybtn2.addActionListener((ActionListener)controllerint);
        mybtn2.setActionCommand("deleteartist");
        
        
        result = null;
//array to display the title of the columns
        String[] table = {"Artist Id", "First Name", "Second Name", "Website", "Email"};
//getting the result of the query made in the model
        result = controller.model2.printArtist();
// creating a table that will display the result together with the array table
        this.mytb = new JTable(result, table);
        panel.add(mytb);
        
        
        JScrollPane pnl = new JScrollPane(mytb);
        panel.add(pnl);
        
        
        
        this.validate();
        this.repaint();
        
    }
//constructor with Artist type, so the artist that the admin clicked can be updated or deleted
    public Artist GetArtistSelected(){
        Artist ArtistSelected = new Artist();
// getting the index of the table
        int getIndexNum = mytb.getSelectedRow();
        
        if (getIndexNum > -1) {
 //storing the result inside the array, and using the setters to store the values
            String[] selectArtist = result[getIndexNum];

            ArtistSelected.SetId(Integer.parseInt(selectArtist[0]));
            ArtistSelected.SetName(selectArtist[1]);
            ArtistSelected.SetLastName(selectArtist[2]);
            ArtistSelected.SetWebSite(selectArtist[3]);
            ArtistSelected.SetAddress(selectArtist[4]);
            
            
        }
        return ArtistSelected;
        
    }
    
    public JTable GetTable(){
        
        return this.mytb;
        
        
        
        
    }
    
        
    }
    



package Adminstrator;

import Getters.Art;
import Getters.Artist;
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
public class ArtList extends JFrame {
    
    //declaring variables
    JTable mytb;
    String[][] result;
    private admController controllerint;
    
    //informing the constructor who is the controller
    public ArtList(admController controller){
        
        this.controllerint = controller;
        
        //defining the attributes 
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        JPanel panel = new JPanel();
        this.add(panel);
        // creating the button dele and adding the actionlistener so It can be called on the constructor
        JButton mybtn2 = new JButton("Delete");
        panel.add(mybtn2);
        mybtn2.addActionListener((ActionListener)controllerint);
        mybtn2.setActionCommand("Deleteart");
        
        
        result = null;
        // creating a array to show the table of the contents
        String[] table = {"Art ID", "Art", "Type", "Artist", "Artist Last Name"};
        // result is getting result from the query made in the model
        result = controller.model2.printArt();
       
        
               
        
        
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Getters;

/**
 *
 * @author Jonathan Santos
 */
public class Artist {
    
    private int artistid;
    private String artistName;
    private String artistLname;
    private String artistWb;
    private String artistAdd;
    
    public Artist (int id, String Name, String Lname, String Web, String Address){
        
        this.artistid = id;
        this.artistName = Name;
        this.artistLname = Lname;
        this.artistWb = Web;
        this.artistAdd = Address;
        
        
    }
    
    public Artist(){
        
        
    }

    public Artist(String fm, String lm, String wb, String ad) {
        this.artistName = fm;
        this.artistLname = lm;
        this.artistWb = wb;
        this.artistAdd = ad;
    }
    
    public int GetId(){
        
        return artistid;
    }
    
    public String GetName(){
        return artistName;
    }
    
    public String GetLastName(){
        return artistLname;
    }
    
    public String GetWebsite(){
        return artistWb;
        
    }
    public String GetAddress(){
        
        return artistAdd;
    }
    
    public void SetId(int id){
        
        this.artistid = id;
    }
    
    public void SetName(String nm){
        this.artistName = nm;
    }
    
    public void SetLastName(String lnm){
        this.artistLname = lnm;
        
    }
    public void SetWebSite(String wb){
        this.artistWb = wb;
    }
    public void SetAddress (String add){
        
        this.artistAdd = add;
    }

    public void GetId(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

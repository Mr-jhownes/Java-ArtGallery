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
public class Art {
    
    private int artid;
    private String artName;
    private String artType;
    private int artistid;
    
    
    public Art (int id, String Name, String type, int artistId){
        
        this.artid = id;
        this.artName = Name;
        this.artType = type;
        this.artistid = artistId;
        
        
        
    }
    
    public Art(){
        
        
    }
    
    public Art(int id){
        this.artid = id;
    }
    
    public int GetId(){
        
        return artid;
    }
    
    public String GetName(){
        return artName;
    }
    
    public String GetType(){
        return artType;
    }
    
    public int GetArtistId(){
        return artistid;
        
    }
   
    
    public void SetId(int id){
        
        this.artid = id;
    }
    //setters used from the art window, 
    public void SetName(String nm){
        this.artName = nm;
    }
    
    public void SetType(String tp){
        this.artType = tp;
        
    }
    public void SetArtistId(int artistId){
        this.artistid = artistId;
    }
    
    
    
}

    
    
    


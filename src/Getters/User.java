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
public class User {
    
    private String un;
    private String fm;
    private String lm;
    private String em;
    private String pw;
    private String ad;
    private int id;
    
    public User(String un, String pw){
        this.un = un;
        this.pw = pw;
    }
    
    public User(String un, String fm, String lm, String em, String pw, String ad){
        this.un = un;
        this.fm = fm;
        this.lm = lm;
        this.em = em;
        this.pw = pw;
        this.ad = ad;
        
    }
    public User(){
        
    }

    public User(String un, String fm, String lm, String em, String pw) {
         this.un = un;
        this.fm = fm;
        this.lm = lm;
        this.em = em;
        this.pw = pw;
    }
    
    

    public String getUn() {
        return un;
    }
    
    public String getFm() {
        return fm;
    }
    
    public String getLm() {
        return lm;
    }
    
    public String getEm() {
        return em;
    }

    public String getPw() {
        return pw;
    }
     public String getAd() {
        return ad;
    }
     
     public int getId() {
        return id;
    }
     
     public void setId(int id){
         this.id = id;
     }

    public void setUsername(String username ) {
       this.un = username;
    }

    public void setFname(String fm) {
       this.fm = fm;
    }

    public void setLname(String lm) {
        this.lm = lm ;
        
    }

    public void setemail(String em) {
     
        this.em = em;
    }
    

    public void setpassword(String pw) {
        
        this.pw = pw;
        }

    public void setAddress(String ad) {
        
        this.ad = ad;
        }
    
}


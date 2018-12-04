/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Tanik
 */
public class Session {
    
    private String Username;
    private String Date;
    private String CLKin;
    private String CLKout;

    Session() {
         
    }

    
   

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String Username)
    {
        this.Username = Username;
    }
    
    public String getDate() {
        return this.Date;
    }
    public void setDate(String Date)
    {
        this.Date= Date;
    }

    public String getCLKin() {
        return this.CLKin;
    }
    public void setCLKin(String CLKin)
    {
        this.CLKin= CLKin;
    }

    public String getCLKout() {
        return this.CLKout;
    }
    public void setCLKout(String CLKout)
    {
        this.CLKout= CLKout;
    }
    Session(String Username,String Date, String CLKin, String CLKout) {
         this.Username = Username;
         this.Date= Date;
         this.CLKin= CLKin;
         this.CLKout= CLKout;
    }
}

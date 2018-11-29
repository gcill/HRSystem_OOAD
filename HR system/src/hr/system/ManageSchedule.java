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
public class ManageSchedule {
    
    private SimpleStringProperty username;
    private SimpleStringProperty Date;
    private SimpleStringProperty CLKin;
    private SimpleStringProperty CLKout;

    ManageSchedule() {
        
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String id)
    {
        this.username= new SimpleStringProperty(id);
    }
    
    public String getDate() {
        return Date.get();
    }
    public void setDate(String Date)
    {
        this.Date= new SimpleStringProperty(Date);
    }

    public String getCLKin() {
        return CLKin.get();
    }
    public void setCLKin(String CLKin)
    {
        this.CLKin= new SimpleStringProperty(CLKin);
    }

    public String getCLKout() {
        return CLKout.get();
    }
    public void setCLKout(String CLKout)
    {
        this.CLKout= new SimpleStringProperty(CLKout);
    }
    public ManageSchedule(String username, String Date, String CLKinH, String CLKinS,String CLKoutH,String CLKoutS) {
        super();
        this.username = new SimpleStringProperty(username);
        this.Date = new SimpleStringProperty(Date);
        this.CLKin = new SimpleStringProperty(CLKinH+"."+ CLKinS);
        this.CLKout = new SimpleStringProperty(CLKoutH+"."+ CLKoutS);
    }
}

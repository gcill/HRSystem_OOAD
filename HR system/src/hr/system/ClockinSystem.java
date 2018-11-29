/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ClockinSystem extends SQLmapper{
    boolean result;

    public boolean checkTimetoClockin(String username) throws ClassNotFoundException, SQLException{
        ///set current date
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        
        Session sess = getSession(username);
        System.out.println(sess.getUsername());
        ///set current time
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH.mm");
        LocalDateTime current = LocalDateTime.now();
        float currenttime=Float.parseFloat(time.format(current));   ////convert sting ->float
        System.out.println("Now : " +currenttime); /////print current date
        System.out.println("Clkintime : "+sess.getCLKin()); /////print clkintime
        float clockintime=Float.parseFloat(sess.getCLKin());    ////convert sting ->float
        
        System.out.println("today :"+dtf.format(now));
        System.out.println("Day in Scedule : "+sess.getDate());
        float late = currenttime - clockintime; 
        
       /////Compare Date
        if(sess.getDate().equals(dtf.format(now))){
             /////check time in schedule > current time
             if(late >= 1.00){ ///// clock in late 1 hour
               JOptionPane.showMessageDialog(null,"You Late!");
               System.out.println("late :"+ late );
               result = true;
             }
             else if (clockintime <= currenttime){ ///// clock in little bit late
               //System.out.println("Clk in Success");
               result = true;
             }
        
              else if (clockintime > currenttime){ /////ยังไม่ถึงเวลา
               JOptionPane.showMessageDialog(null,"You clock in time is "+clockintime);
               //System.out.println("Not in  Sch");
               result = false;
            }
        }
        else{System.out.println("No schdule for Today");
             result = false;}
        
       return result;
    }
}


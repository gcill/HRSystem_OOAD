/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.system;

public class Staff extends Fulltime {
    public int salary;
    public Staff(String name) {
      // This constructor has one parameter, name.
      System.out.println("Name chosen is :" + name );
   }
    @Override
    int calculateIncome() {
        int income = 0;
        return income;
    }
} 


package hr.system;

public abstract class Employee {
     public int id;
     private String name;
     private String address;
     private int phoneNumber;
     private int income;
     abstract int calculateIncome();
}

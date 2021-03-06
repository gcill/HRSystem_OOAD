
package hr.system;

public abstract class Employee {
     public int id;
     protected String name;
     protected String lastname;
     protected String position;
     protected String address;
     protected int departmentID;
     protected String username;
     

     public abstract String getName();
     public abstract void setName(String name);
     public abstract String getUsername();
     public abstract void setUsername(String username);
     public abstract String getAddress();
     public abstract void setAddress(String address);
     public abstract String getLastname();
     public abstract void setLastname(String lastname);
     public abstract String getPosition();
     public abstract void setPosition(String postion);
     public abstract int getDepartmentID();
     public abstract void setDepartmentID(int departmentID);
     public abstract int getID();
     public abstract void setID(int id);
     
     
     
}

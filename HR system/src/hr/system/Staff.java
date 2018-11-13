
package hr.system;

public class Staff extends Fulltime {

    @Override
    public int calculateIncome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getLastname() {
        return this.lastname;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int getDepartmentID() {
        return this.departmentID;
    }

    @Override
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
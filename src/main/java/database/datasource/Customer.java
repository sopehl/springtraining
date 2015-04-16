package database.datasource;

/**
 * Created by semih on 12.04.2015.
 */
// Basit bir DAO
public class Customer {

    long id;
    String name,lastName,phoneNum;

    public Customer() {
    }

    public Customer(String name, String lastName, String phoneNum) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

package hibernate.basichibernate;

import javax.persistence.*;

/**
 * Created by semih on 25.04.2015.
 */
//Aşağıdaki class db ye mapping edilecek olan classtır
@Entity
@Table(name = "Customer")
public class Customer {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "age")
    private int age;

    public Customer(String name, String firstName, int age) {
        this.name = name;
        this.firstName = firstName;
        this.age = age;
    }

    public Customer() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer {id :" + getId() + "\n" +
                "name :" + getName() + "\n" +
                "firstName :" + getFirstName() + "\n" +
                "age :" + getName() + "}"+"\n";
    }
}

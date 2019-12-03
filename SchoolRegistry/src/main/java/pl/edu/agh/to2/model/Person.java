package pl.edu.agh.to2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Columns.ID)
    private int personId;

    @Column(name = Columns.FIRST_NAME, nullable = false, length = 40)
    private String firstName;

    @Column(name = Columns.LAST_NAME, nullable = false, length = 40)
    private String lastName;

    @Column(name = Columns.PHONE, length = 9)
    private String phone;

    @Column(name = Columns.EMAIL, nullable = false, length = 40)
    private String email;

    @Column(name = Columns.PASSWORD, nullable = false, length = 20)
    private String password;

    @ManyToMany
    private Set<Course> courses = new HashSet();

    public Person(){}

    public static class Columns {
        public static final String ID = "person_id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

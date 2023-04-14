package com.paine.spring.boot.template.spring_boot_template.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String citizenship;

    public User() {
    }

    public User(String firstName, String lastName, String citizenship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenship = citizenship;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    @Override
    public String toString() {
        return String.format("User: id = %d, firstName = %s, lastName = %s, citizenship = %s",
                id, firstName, lastName, citizenship);
    }
}
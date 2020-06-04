package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "user1")
@Entity
public class User {

    enum Position {
        DIRECTOR,
        WORKER
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "firm_id")
    private Integer firmId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "position")
    @Enumerated
    private Position position;

    /*
     * Getters & Setters
     */
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getFirmId() { return firmId; }
    public void setFirmId(Integer firmId) { this.firmId = firmId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    public User() {
        super();
    }

    /*
     * Entity Basics
     */
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == null || this.getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;
        return Objects.equals(id, user.getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "firmId=" + firmId +
                "name=" + name +
                "surname=" + surname +
                "position=" + position;
    }
}

/*
* spring:
    datasource:
        driverClassName: org.postgresql.Driver
        url: jdbc:postgresql://localhost:5432/diploma
        username: diploma
        password:
    jpa:
        hibernate.ddl-auto: update
        generate-ddl: true
        show-sql: true

 */
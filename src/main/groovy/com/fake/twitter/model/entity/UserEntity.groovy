package com.fake.twitter.model.entity


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class UserEntity {
    @Id
    private String id
    private String firstName
    private String lastName
    private String username
    private String sex
    private String country
    private String city
    private String email
    private String password

    UserEntity() {
    }

    String getId() {
        return id
    }

    String getFirstName() {
        return firstName
    }

    void setFirstName(String firstName) {
        this.firstName = firstName
    }

    String getLastName() {
        return lastName
    }

    void setLastName(String lastName) {
        this.lastName = lastName
    }

    String getUsername() {
        return username
    }

    void setUsername(String userName) {
        this.username = userName
    }

    String getSex() {
        return sex
    }

    void setSex(String sex) {
        this.sex = sex
    }

    String getCountry() {
        return country
    }

    void setCountry(String country) {
        this.country = country
    }

    String getCity() {
        return city
    }

    void setCity(String city) {
        this.city = city
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }
}

package com.fake.twitter.model.dto

import com.fake.twitter.model.enums.SexEnum
import com.fasterxml.jackson.annotation.JsonProperty

class UserDTO {

    private String id
    @JsonProperty("first_name")
    private String firstName
    @JsonProperty("last_name")
    private String lastName
    @JsonProperty("user_name")
    private String userName
    private SexEnum sex
    private String country
    private String city
    private String email
    private String password

    UserDTO() {
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

    String getUserName() {
        return userName
    }

    void setUserName(String userName) {
        this.userName = userName
    }

    SexEnum getSex() {
        return sex
    }

    void setSex(SexEnum sex) {
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

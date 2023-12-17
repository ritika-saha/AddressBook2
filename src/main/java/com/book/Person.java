package com.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("fname")
    private String firstName;

    @JsonProperty("lname")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("state")
    private String state;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    // Getter and setter methods
}


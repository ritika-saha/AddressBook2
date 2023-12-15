package com.book;

public class contact {
    private String fname;
    private String lname;
    private String address;
    private String city;
    private String zip;
    private String state;
    private String phone;
    private String email;

    public contact(String fname, String lname, String address, String city, String state, String zip, String phone,
            String email) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.phone = phone;
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void updateContact(String address, String city, String state, String zip, String phone, String email) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    @Override
public String toString() {
    return String.format(
            "Name     : %s %s\n" +
            "Address  : %s\n" +
            "City     : %s\n" +
            "State    : %s\n" +
            "ZIP      : %s\n" +
            "Phone    : %s\n" +
            "Email    : %s\n",
            fname, lname, address, city, state, zip, phone, email);
}


}
package com.book;

import java.util.Scanner;

public class DBmain {
   public static void main(String args[]){
     DBops db=new DBops();
    db.getContactList();
    db.displayContactList();
   
    System.out.println("Enter fname,lname,address,city,zip,state,phone,email");
    InputValidator validator=new InputValidator();
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter first name");
                        String fname = sc.nextLine();
                        while (validator.validateName(fname) == false) {
                            System.out.println("!!!!!!!!!!!!!! invalid first name enter again !!!!!!!!!!!");
                            fname = sc.nextLine();
                        }

                        System.out.println("Enter last name");
                        String lname = sc.nextLine();
                        while (validator.validateName(lname) == false) {
                            System.out.println("!!!!!!!!!!!!!! invalid last name enter again !!!!!!!!!!!");
                            lname = sc.nextLine();
                        }

                        System.out.println("Enter address");
                        String address = sc.nextLine();
                        System.out.println("enter city");
                        String city = sc.nextLine();
                        while (validator.validatePlace(city) == false) {
                            System.out.println("!!!!!!!!!!!!!!!!   Invalid city name enter again !!!!!!!!!!!!! ");
                            city = sc.nextLine();
                        }

                        System.out.println("Enter state");
                        String state = sc.nextLine();
                        while (validator.validatePlace(state) == false) {
                            System.out.println("!!!!!!!!!!!!!!!!   Invalid state name enter again !!!!!!!!!!!!! ");
                            state = sc.nextLine();
                        }

                        System.out.println("Enter zip");
                        String zip = sc.nextLine();
                        while (validator.validateZip(zip) == false) {
                            System.out.println("!!!!!!!!!!!!!! invalid zip enter again !!!!!!!!!!!");
                            zip = sc.nextLine();
                        }

                        System.out.println("Enter phone number");
                        String phone = sc.nextLine();
                        while (validator.validatePhone(phone) == false) {
                            System.out.println("!!!!!!!!!!!!!!!!!! invalid phone number enter again !!!!!!!!!!!!!!");
                            phone = sc.nextLine();
                        }

                        System.out.println("Enter email");
                        String email = sc.nextLine();
                        while (validator.validateEmail(email) == false) {
                            System.out.println("!!!!!!!!!!!!!!!!!!! invalid email Enter again !!!!!!!!!!!!!!!!!!!!");
                            email = sc.nextLine();
                        }
               
            db.addContact(fname,lname,address,city,state,zip,phone,email);
            db.displayContactList();
         
            System.out.println("Enter first name and last name for data deletion");
            fname=sc.nextLine();
            lname=sc.nextLine();
            db.deleteEntryFromDb(fname, lname);
            db.displayContactList();

            System.out.println("Enter the following data to update contact");
            System.out.println("first name, old Address, new email, new phone, new Address, new city, new state, new zip");
            fname=sc.nextLine();
            String oldAddress=sc.nextLine();
            email=sc.nextLine();
            phone=sc.nextLine();
            address=sc.nextLine();
            city=sc.nextLine();
            state=sc.nextLine();
            zip=sc.nextLine();
            db.editDataInDb(fname, oldAddress, email, phone, address, city, state, zip);
            db.displayContactList();

            System.out.println("Writing data to json file");
            FileOps file=new FileOps();
            file.contactList=db.contactList;
            file.writeToJSONfileDB();
            file.readFromJSONfileDB();

         sc.close();
   }
}

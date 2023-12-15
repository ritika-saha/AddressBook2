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
         

         sc.close();
   }
}

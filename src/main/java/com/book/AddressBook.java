package com.book;

import java.util.ArrayList;
import java.util.Scanner;

class AddressBook {

    public ArrayList<contact> contactList;

    public AddressBook() {
        contactList = new ArrayList<contact>();
    }

     public void display() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts in the address book");
        } else {
            System.out.println("---------------------------------------------------------------");
            System.out.println( "NAME  \t\t\tADDRESS  \t\tCITY  \t\tSTATE \t\tZIP  \t\tPHONE NUMBER  \t\tEMAIL");
            for(int i=0;i<contactList.size();i++){
                 String fname=contactList.get(i).getFname();
                 String lname=contactList.get(i).getLname();
                 String address=contactList.get(i).getAddress();
                 String city=contactList.get(i).getCity();
                 String zip=contactList.get(i).getZip();
                 String state=contactList.get(i).getState();
                 String phone=contactList.get(i).getPhone();
                 String email=contactList.get(i).getEmail();
                System.out.printf( "%s %s  \t\t %s  \t\t%s  \t\t\t %s \t\t %s  \t\t %s  \t %s\n",
                fname, lname, address, city, state, zip, phone, email);
            }
        }

    }

    public void addAddress(contact c) {
        contactList.add(c);
        System.out.println("Contact added successfully");
        display();

    }

    public void editAddress(String firstName, String lastName) {
        
        for (contact contact : contactList) {
            if (contact.getFname().equalsIgnoreCase(firstName) && contact.getLname().equalsIgnoreCase(lastName)) {
                Scanner scanner=new Scanner(System.in);
                System.out.println("Enter new data----------------------> :");

                System.out.print("Enter address: ");
                String address = scanner.nextLine();

                System.out.print("Enter city: ");
                String city = scanner.nextLine();

                System.out.print("Enter state: ");
                String state = scanner.nextLine();

                System.out.print("Enter zip: ");
                String zip = scanner.nextLine();

                System.out.print("Enter phone number: ");
                String phone = scanner.nextLine();

                System.out.print("Enter email: ");
                String email = scanner.nextLine();

                contact.updateContact(address, city, state, zip, phone, email);
                System.out.println("Contact updated !!!!!!!!!!!!!!\n.");
                display();
               // scanner.close();
                return;

            }
        }
        
        System.out.println("Contact not found");
    }

      public void deleteAddress(String firstName, String lastName){
        for (contact c : contactList) {
            if(c.getFname().equalsIgnoreCase(firstName) && c.getLname().equalsIgnoreCase(lastName)){
                contactList.remove(c);
                System.out.println("Contact DELETED !!");
                display();
                return;
            }else{
                System.out.println("CONTACT NOT AVAILABLE");
            }
        }
    }
}
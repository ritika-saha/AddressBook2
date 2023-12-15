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
            System.out.printf("%-20s%-20s%-20s%-15s%-15s%-20s%-20s\n",
                    "NAME", "ADDRESS", "CITY", "STATE", "ZIP", "PHONE NUMBER", "EMAIL");
    
            for (int i = 0; i < contactList.size(); i++) {
                contact contact = contactList.get(i);
    
                System.out.printf("%-20s%-20s%-20s%-15s%-15s%-20s%-20s\n",
                        contact.getFname() + " " + contact.getLname(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        contact.getZip(),
                        contact.getPhone(),
                        contact.getEmail());
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
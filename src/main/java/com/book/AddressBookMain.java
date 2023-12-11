package com.book;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;

public class AddressBookMain {

    public static Map<String, ArrayList<String>> stateList = new HashMap<>();
    public static Map<String, ArrayList<String>> cityList = new HashMap<>();

       public static void main(String[] args) {
        System.out.println("----------------Welcome to Address Book Program--------------");

        Scanner sc = new Scanner(System.in);
        AddressBook ab1 = new AddressBook();
        InputValidator validator = new InputValidator();
        int choice = -1;

        while (choice != 0) {
            System.out.println("Enter 1 to add contact");
            System.out.println("Enter 2 to edit contact");
            System.out.println("Enter 3 to delete contact");
            System.out.println("Enter 0 to exit");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println(
                                "Enter first and last names, address, city, state, zip, phone number, and email...");
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
                        contact c = new contact(fname, lname, address, city, state, zip, phone, email);
                        ab1.addAddress(c);
                        break;

                    case 2:
                        System.out.println("Enter the firstname and lastname of person you want to edit");
                        String fn = sc.nextLine();
                        String ln = sc.nextLine();
                        ab1.editAddress(fn, ln);
                        break;

                    case 3:
                        System.out.println("Enter the firstname and lastname of person you want to edit");
                        String fn1 = sc.nextLine();
                        String ln1 = sc.nextLine();
                        ab1.deleteAddress(fn1, ln1);

                    case 0:
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine(); // Consume the invalid input
            }
        }

        // multiple addressbook branch multipleBook
        ArrayList<AddressBook> addressBookList = new ArrayList<>();
        addressBookList.add(ab1);
        System.out.println("do you want to add new address Book list? (yes/no)");
        String a = sc.nextLine();
        if (a.equals("yes")) {
            AddressBook ab = new AddressBook();
            int choice1 = -1;

            while (choice1 != 0) {
                System.out.println("Enter 1 to add contact");
                System.out.println("Enter 2 to edit contact");
                System.out.println("Enter 3 to delete contact");
                System.out.println("Enter 0 to exit");

                try {
                    choice1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    switch (choice1) {
                        case 1:
                            System.out.println(
                                "Enter first and last names, address, city, state, zip, phone number, and email...");
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
                            contact c = new contact(fname, lname, address, city, state, zip, phone, email);
                            ab.addAddress(c);
                            break;

                        case 2:
                            System.out.println("Enter the firstname and lastname of person you want to edit");
                            String fn = sc.nextLine();
                            String ln = sc.nextLine();
                            ab.editAddress(fn, ln);
                            break;

                        case 3:
                            System.out.println("Enter the firstname and lastname of person you want to edit");
                            String fn1 = sc.nextLine();
                            String ln1 = sc.nextLine();
                            ab.deleteAddress(fn1, ln1);

                        case 0:
                            break;

                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }

                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.nextLine(); // Consume the invalid input
                }
            }
            addressBookList.add(ab);
        }

        System.out.println("ADDRESS BOOKS IN THE SYSTEM----------------------->");
        for (int i = 0; i < addressBookList.size(); i++) {
            addressBookList.get(i).display();
            System.out.println("------------------------------------------------------------------------");
        }

        // searching people by state (branch searchState)
        System.out.println("Enter Name of the State to Display the list");
        String stateQuery = sc.nextLine();

        

        for (AddressBook adr : addressBookList) {
            AddressBook currentBook = adr;
            ArrayList<contact> currentContact = currentBook.contactList;

            for (contact person : currentContact) {
                if (stateQuery.equals(person.getState())) {

                    String fullName = person.getFname() + " " + person.getLname();
                    String state = person.getState();

                    if (stateList.containsKey(state)) {
                        stateList.get(state).add(fullName);
                    } else {
                        ArrayList<String> tmp = new ArrayList<>();
                        tmp.add(fullName);
                        stateList.put(state, tmp);
                    }
                }

            }

        }

        System.out.println("People in this city are ------>");
        for (String names : stateList.get(stateQuery)) {
            System.out.println(names);
        }

        // searching people by city (branch searchCity)
        System.out.println("Enter Name of the City to Display the list");
        String cityQuery = sc.nextLine();

        

        for (AddressBook adr : addressBookList) {
            AddressBook currentBook = adr;
            ArrayList<contact> currentContact = currentBook.contactList;

            for (contact person : currentContact) {
                if (cityQuery.equals(person.getCity())) {

                    String fullName = person.getFname() + " " + person.getLname();
                    String city = person.getCity();

                    if (cityList.containsKey(city)) {
                        cityList.get(city).add(fullName);
                    } else {
                        ArrayList<String> tmp = new ArrayList<>();
                        tmp.add(fullName);
                        cityList.put(city, tmp);
                    }
                }

            }

        }

        System.out.println("People in this city are ------>");
        for (String names : cityList.get(cityQuery)) {
            System.out.println(names);
        }

        // counting people by city or state
        System.out.println("enter city or state to get the count of people (c/s)");
        String query = sc.nextLine();
        if (query.equals("c")) {
            System.out.println("Enter city name");
            String cityName = sc.nextLine();
            int countByCity = 0;
            if (cityList.containsKey(cityName))
                countByCity = cityList.get(cityName).size();
            System.out.println("The number of People in this city is : " + countByCity);
        }

        else {
            System.out.println("Enter the state name");
            String stateName = sc.nextLine();
            int countByState = 0;
            if (stateList.containsKey(stateName))
                countByState = stateList.get(stateName).size();
            System.out.println("Number of people in this State is : " + countByState);
        }

        // sorting by name (branch sortByName)

        for (AddressBook adr : addressBookList) {
            AddressBook currentBook = adr;
            ArrayList<contact> currentContact = currentBook.contactList;

            // Using a custom comparator to sort contacts by name (branch sortByName)
            Comparator<contact> nameComparator = Comparator
                    .comparing(contact::getFname)
                    .thenComparing(contact::getLname);

            Collections.sort(currentContact, nameComparator);

            System.out.println("Sorted Contacts in Address Book:");
            currentBook.display();
            System.out.println("------------------------------------------------------------------------");

        }

        // sort by city state or zip (branch sortByPreference)
        System.out.println("Do you want to sort by city , state or zip? (enter : c/s/z)");
        String c = sc.nextLine();
        if (c.equals("c")) {
            for (AddressBook adr : addressBookList) {
                AddressBook currentBook = adr;
                ArrayList<contact> currContact = currentBook.contactList;
                Comparator<contact> cityComparator = Comparator.comparing(contact::getCity);
                Collections.sort(currContact, cityComparator);
                System.out.println("sorted by city : ");
                currentBook.display();
                System.out.println("----------------------------------------------------------------------");
            }
        }

        else if (c.equals("s")) {
            for (AddressBook adr : addressBookList) {
                AddressBook currentBook = adr;
                ArrayList<contact> currContact = currentBook.contactList;
                Comparator<contact> stateComparator = Comparator.comparing(contact::getState);
                Collections.sort(currContact, stateComparator);
                System.out.println("sorted by state : ");
                currentBook.display();
                System.out.println("----------------------------------------------------------------------");
            }
        }

        else if (c.equals("z")) {
            for (AddressBook adr : addressBookList) {
                AddressBook currentBook = adr;
                ArrayList<contact> currContact = currentBook.contactList;
                Comparator<contact> zipComparator = Comparator.comparing(contact::getZip);
                Collections.sort(currContact, zipComparator);
                System.out.println("sorted by zip : ");
                currentBook.display();
                System.out.println("----------------------------------------------------------------------");
            }
        }

        FileOps fileOps=new FileOps(addressBookList);
        //txt file ops
        fileOps.writeToTXTfile();
        fileOps.readFromTXTfile();
        

        sc.close();

    }

}
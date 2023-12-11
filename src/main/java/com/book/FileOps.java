package com.book;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOps {
    ArrayList<AddressBook> addressBookList;
    public FileOps(ArrayList<AddressBook> book){
        this.addressBookList=book;
    }

    public void writeToTXTfile(){
        String path="AddressBookDir/AddressBookData.txt";
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(path))){
          for (AddressBook adr : addressBookList) {
             AddressBook currentBook = adr;
             ArrayList<contact> currentContact = currentBook.contactList;
             for (contact person : currentContact) {
                 writer.write(person.toString()+"\n");
             }
         }
         System.out.println("Data Written to file");
        }catch(IOException e){
         e.printStackTrace();
        }
    }

    public void readFromTXTfile(){
        System.out.println("Displaying the data read from the txt File -------------------------------------->");
        String path="AddressBookDir/AddressBookData.txt";
       try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        String line;
           while ((line=reader.readLine()) != null)
              System.out.println(line);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}

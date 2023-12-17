package com.book;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.Type;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOps {
    ArrayList<AddressBook> addressBookList;
    public ArrayList<contact>contactList;
    public FileOps(ArrayList<AddressBook> book){
        this.addressBookList=book;
    }
    public FileOps(){
    
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

    public void writeToCSVfile(){
        String header[]={"FNAME","LNAME","ADDRESS","CITY","STATE","ZIP","PHONE","EMAIL"};
        String csvFilePath="AddressBookDir/AddressBookData.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))){
            writer.writeNext(header);
             for (AddressBook adr : addressBookList) {
             AddressBook currentBook = adr;
             ArrayList<contact> currentContact = currentBook.contactList;
             for (contact person : currentContact) {
                String data[]={person.getFname(),person.getLname(),person.getAddress(),person.getCity(),person.getState(),person.getZip(),person.getPhone(),person.getEmail()};
                writer.writeNext(data);
                 
             }
         }
            System.out.println("Data Added to CSV File -------------------------------->");
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public void readFromCSVfile(){
         String filePath="AddressBookDir/AddressBookData.csv";
         try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] header = reader.readNext();
            System.out.println(Arrays.toString(header));
            String[]  line;
            while((line = reader.readNext())!=null){
                for(String value: line){
                    System.out.print(value+ " ");
                }
                System.out.println(" ");
            }
        }catch (IOException exception){
            exception.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToJSONfile() {
    String filePath = "AddressBookDir/AddressBookData.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter writer = new FileWriter(filePath)) {
        // Serialize the entire list as an array
        gson.toJson(addressBookList, writer);
        System.out.println("Data Added");
    } catch (IOException exception) {
        exception.printStackTrace();
    }
}

 public void writeToJSONfileDB() {
    String filePath = "AddressBookDir/AddressBookDataDB.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter writer = new FileWriter(filePath)) {
        // Serialize the entire list as an array
        gson.toJson(contactList, writer);
        System.out.println("Data Added");
    } catch (IOException exception) {
        exception.printStackTrace();
    }
}


public void readFromJSONfile() {
    String filePath = "AddressBookDir/AddressBookData.json";
    Gson gson = new Gson();
    try (FileReader reader = new FileReader(filePath)) {
        // Use TypeToken to handle generic types like lists
        java.lang.reflect.Type listType = new TypeToken<List<AddressBook>>() {}.getType();
        List<AddressBook> addressBooks = gson.fromJson(reader, listType);

        for (AddressBook addressBook : addressBooks) {
            ArrayList<contact> contacts = addressBook.contactList;
            for (contact contact : contacts) {
                System.out.println(contact.toString());
            }
        }
    } catch (IOException exception) {
        exception.printStackTrace();
    }
}

    public void readFromJSONfileDB() {
    String filePath = "AddressBookDir/AddressBookDataDB.json";
    Gson gson = new Gson();
    try (FileReader reader = new FileReader(filePath)) {
        // Use TypeToken to handle generic types like lists
        java.lang.reflect.Type listType = new TypeToken<List<contact>>() {}.getType();
        List<contact> contacts = gson.fromJson(reader, listType);

        for (contact contact : contacts) {
           
                System.out.println(contact.toString());
            
        }
    } catch (IOException exception) {
        exception.printStackTrace();
    }
}



}

package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBops {
       ArrayList<contact> contactList;
      // method to connect with the database
      public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(DBcred.URL.getValue(), DBcred.USER.getValue(), DBcred.PASS.getValue());
            System.out.println("Connection success !");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            connection = null;
        }
        return connection;
    }

    public void getContactList(){
        contactList=new ArrayList<>();
        String query="select  p.first_name,p.last_name,at.type, a.address,a.city,a.zip,a.state,p.phone,p.email from address a inner join addressbook_table2 at on a.address_id=at.address_id inner join person p on p.person_id=at.person_id; ";
        try(Connection connection=getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)
        ){
            while(resultSet.next()){
                 String fname=resultSet.getString("first_name");
                 String lname=resultSet.getString("last_name");
                 String address=resultSet.getString("address");
                 String city=resultSet.getString("city");
                 String zip=resultSet.getString("zip");
                 String state=resultSet.getString("state");
                 String phone=resultSet.getString("phone");
                 String email=resultSet.getString("email");
                 contact c=new contact(fname, lname, address, city, state, zip, phone, email);
                 contactList.add(c);
            }
        }catch(SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }

    }

    public void displayContactList(){
        AddressBook book=new AddressBook();
        book.contactList=contactList;
        book.display();
    }
    

    public void addContact(String fname,String lname,String address,String city,String state,String zip,String phone,String email){
        String personQuery="insert into person(first_name, last_name, phone, email) values (?, ?, ?, ?);";
        String addressQuery="insert into address(address, city, state, zip) values (?, ?, ?, ?);";
        String getpID="select person_id from person where first_name=? and last_name=? ;";
        String getaID="select address_id from address where address=? and zip=? ;";
        String bookQuery="insert into addressbook_table2(person_id, address_id, name, type) values (?,?,'bookA','Family');";

        try (
            Connection connection = getConnection();
            PreparedStatement statement1 = connection.prepareStatement(personQuery)) {
                statement1.setString(1, fname);
                statement1.setString(2, lname);
                statement1.setString(3, phone);
                statement1.setString(4, email);
                statement1.executeUpdate();

                PreparedStatement statement2=connection.prepareStatement(addressQuery);
                statement2.setString(1, address);
                statement2.setString(2, city);
                statement2.setString(3, state);
                statement2.setString(4, zip);
                statement2.executeUpdate();

                PreparedStatement statement3=connection.prepareStatement(getpID);
                statement3.setString(1, fname);
                statement3.setString(2, lname);
                ResultSet res=statement3.executeQuery();
                String person_id="";
                while (res.next()) {  
                    person_id=res.getString("person_id");
                }

                PreparedStatement statement4=connection.prepareStatement(getaID);
                statement4.setString(1, address);
                statement4.setString(2, zip);
                String address_id="";
                ResultSet res2=statement4.executeQuery();
                while(res2.next()){
                    address_id=res2.getString("address_id");
                }

                PreparedStatement statement5=connection.prepareStatement(bookQuery);
                statement5.setString(1, person_id);
                statement5.setString(2, address_id);
                statement5.executeUpdate();

                getContactList();

                System.out.println("DATA ADDED SUCCESFULLY TO DB ----------------------->");
            }catch (SQLException exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }

    }

    public void deleteEntryFromDb(String fname,String lname){
        String getpid="select person_id from person where first_name=? and last_name=?";
        String getaid="select address_id from addressbook_table2 where person_id=?";
        String deleteBook="delete from addressbook_table2 where address_id=? and person_id=?";
        String deletePerson="delete from person where person_id=?";
        String deleteAddress="delete from address where address_id=?";

         try (
            Connection connection = getConnection();
            PreparedStatement statement1 = connection.prepareStatement(getpid)) {
                statement1.setString(1, fname);
                statement1.setString(2, lname);
                ResultSet res1=statement1.executeQuery();
                String person_id="";
                while (res1.next()) {  
                    person_id=res1.getString("person_id");
                }

                PreparedStatement statement2=connection.prepareStatement(getaid);
                statement2.setString(1, person_id);
                ResultSet res2=statement2.executeQuery();
                String address_id="";
                while (res2.next()) {  
                    address_id=res2.getString("address_id");
                }

                PreparedStatement statement3= connection.prepareStatement(deleteBook);
                statement3.setString(1, address_id);
                statement3.setString(2, person_id);
                statement3.executeUpdate();

                PreparedStatement statement4=connection.prepareStatement(deleteAddress);
                statement4.setString(1, address_id);
                statement4.executeUpdate();

                PreparedStatement statement5=connection.prepareStatement(deletePerson);
                statement5.setString(1, person_id);
                statement5.executeUpdate();

                getContactList();

                System.out.println("Entry deleted for -----------------> : "+fname+" "+lname);


             }catch (SQLException exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }

    }

    public void editDataInDb(String fname,String oldAddress,String email,String phone,String newAddress,String city,String state,String zip){
         String updatePerson="update person set phone=? , email=? where first_name=?";
         String updateAddress="update address set address=? ,city=?, state=?, zip=? where address=?;";

         try (
            Connection connection = getConnection();
            PreparedStatement statement1 = connection.prepareStatement(updateAddress)) {
                statement1.setString(1, newAddress);
                statement1.setString(2, city);
                statement1.setString(3, state);
                statement1.setString(4, zip);
                statement1.setString(5, oldAddress);
                statement1.executeUpdate();

                PreparedStatement statement2=connection.prepareStatement(updatePerson);
                statement2.setString(1, phone);
                statement2.setString(2, email);
                statement2.setString(3,fname);
                statement2.executeUpdate();

                getContactList();

                System.out.println("Entry updated successfully------------------------------>");
               

              }catch (SQLException exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }  
    }

}

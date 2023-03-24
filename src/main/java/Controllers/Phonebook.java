package Controllers;

import DTO.Contact;

import java.util.List;

public interface Phonebook {
    void addContact(Contact contact);
    void removeContact(String name);
    void updateContact(String name, Contact newContact);
    //void displayAllContacts();
    Contact findContactByName(String name);
    Contact findContactByPhoneNumber(String phoneNumber);
    Contact findContactByPartOfName(String name);
    Contact findContactByPartOfPhoneNumber(String phoneNumber);
    List<Contact> getAllContacts();



   // List<Contact> searchContacts(String searchString);
  //  List<Contact> getAllContacts();
}

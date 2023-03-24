package Controllers;

import Controllers.PhonebookImplement;
import DTO.Contact;

import javax.swing.*;
import java.util.List;

public class MenuController {

     public static void menu (){

        PhonebookImplement phonebook = new PhonebookImplement();

        while (true) {

            // Prompt user to enter a menu option
            String input = JOptionPane.showInputDialog("Select an option:\n" +
                    "1. Add Contact\n" +
                    "2. Remove Contact\n" +
                    "3. Update Contact\n" +
                    "4. Find Contact by Name\n" +
                    "5. Find Contact by Phone Number\n" +
                    "6. Find Contact by Part of Name\n" +
                    "7. Find Contact by Part of Phone Number\n" +
                    "8. display All contacts \n" +
                    "9. Exit");

            try {
                // Convert input to an integer
                int option = Integer.parseInt(input);

                // Switch statement based on user input
                switch (option) {
                    case 1:
                        //Add Contact
                        Contact newContact = new Contact("", "", "");
                        phonebook.addContact(newContact);

                        break;
                    case 2:
                        // Remove Contact
                        String name = JOptionPane.showInputDialog("Enter name of contact to remove:");
                        phonebook.removeContact(name);
                        break;
                    case 3:
                        // Update Contact
                        String oldName = JOptionPane.showInputDialog("Enter name of contact to update:");
                        Contact updatedContact = new Contact("", "", "");
                        Contact oldContact = phonebook.findContactByName(oldName);

                        if (oldContact == null) {
                            JOptionPane.showMessageDialog(null, "Contact not found.");
                        } else {
                            phonebook.updateContact(oldName, updatedContact);
                            JOptionPane.showMessageDialog(null, "Contact updated successfully.");
                        }
                        break;

                    case 4:
                        // Find Contact by Name
                        String searchName = JOptionPane.showInputDialog("Enter name to search for:");
                        Contact foundByName = phonebook.findContactByName(searchName);

                        if (foundByName == null) {
                            JOptionPane.showMessageDialog(null, "Contact not found.");
                        } else {
                            JOptionPane.showMessageDialog(null, foundByName);
                        }
                        break;

                    case 5:
                        // Find Contact by Phone Number
                        String searchNumber = JOptionPane.showInputDialog("Enter phone number to search for:");
                        Contact foundByNumber = phonebook.findContactByPhoneNumber(searchNumber);

                        if (foundByNumber == null) {
                            JOptionPane.showMessageDialog(null, "Contact with phone number " + searchNumber + " not found.");
                        } else {
                            JOptionPane.showMessageDialog(null, foundByNumber);
                        }
                        break;
                    case 6:
                        // Find Contact by Part of Name
                        String searchPartName = JOptionPane.showInputDialog("Enter part of name to search for:");
                        Contact foundByPartName = phonebook.findContactByPartOfName(searchPartName);
                        JOptionPane.showMessageDialog(null, foundByPartName);
                        break;
                    case 7:
                        // Find Contact by Part of Phone Number
                        String searchPartNumber = JOptionPane.showInputDialog("Enter part of phone number to search for:");
                        Contact foundByPartNumber = phonebook.findContactByPartOfPhoneNumber(searchPartNumber);
                        JOptionPane.showMessageDialog(null, foundByPartNumber);
                        break;

                    case 8:
                        // Display All Contacts
                        List<Contact> contacts = phonebook.getAllContacts();
                        StringBuilder sb = new StringBuilder();
                        for (Contact contact : contacts) {
                            sb.append(contact.toString() + "\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                        break;

                    case 9:
                        // Exit program
                        System.exit(0);
                        break;
                    default:
                        // Invalid input
                        JOptionPane.showMessageDialog(null, "Invalid input!");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
            }
        }
    }
}

package Controllers;

import DTO.Contact;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PhonebookImplement implements Phonebook{

    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    public void addContact(Contact contact) {
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        String phoneNumber = JOptionPane.showInputDialog("Enter phone number:");
        String email = JOptionPane.showInputDialog("Enter email:");

        // Create a new contact with the inputted details and add it to the ArrayList
        Contact newContact = new Contact(fullName, phoneNumber, email);
        contacts.add(newContact);

        // Show message to confirm contact added
        JOptionPane.showMessageDialog(null, "Contact added successfully!");

    }

    @Override
    public void removeContact(String name) {
        boolean removed = false;
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getFullName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            JOptionPane.showMessageDialog(null, "Contact removed successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Contact not found!");
        }
    }

    @Override
    public void updateContact(String name, Contact newContact) {
        Contact oldContact = findContactByName(name);
        if (oldContact != null) {
            // Prompt user to enter updated details for the contact
            String fullName = JOptionPane.showInputDialog("Enter updated full name:", oldContact.getFullName());
            String phoneNumber = JOptionPane.showInputDialog("Enter updated phone number:", oldContact.getPhoneNumber());
            String email = JOptionPane.showInputDialog("Enter updated email:", oldContact.getEmail());

            // Create a new contact with the updated details
            Contact updatedContact = new Contact(fullName, phoneNumber, email);

            // Update the contact in the ArrayList
            contacts.set(contacts.indexOf(oldContact), updatedContact);

            // Shows message to confirm contact updated
            JOptionPane.showMessageDialog(null, "Contact updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Contact not found!");
        }
    }
    @Override
    public Contact findContactByName(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getFullName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findContactByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findContactByPartOfName(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getFullName().toLowerCase().contains(name.toLowerCase())) {
                return contact;
            } else {
                System.out.println("not found");
            }
        }
        return null;
    }

    @Override
    public Contact findContactByPartOfPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getPhoneNumber().contains(phoneNumber)) {
                return contact;
            } else {
                System.out.println("not found");
            }
        }
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contacts;
    }
}
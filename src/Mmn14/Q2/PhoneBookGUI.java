package Mmn14.Q2;

import javax.swing.*;


public class PhoneBookGUI extends JPanel {

    private static final int ADD_CONTACT = 1, REMOVE_CONTACT = 2, UPDATE_CONTACT = 3, EXIT = 4;
    private static final String GUI_MENU = "Please choose one of the following methods:" + "\n1 - Add new contact to phone-book"
            + "\n2 - Delete contact from phone-book" + "\n3 - Update contact in phone-book" + "\n4 - Exit";
    private PhoneBook _phoneBook;

    public PhoneBookGUI() {
        _phoneBook = new PhoneBook();
        int answer = 0;
        while (answer != EXIT)

        {
            answer = Integer.parseInt(JOptionPane.showInputDialog(GUI_MENU));
            yourWishIsMyCommand(answer);
        }


    }


    private void yourWishIsMyCommand(int answer) {
        String name, phoneNumber;
        switch (answer) {

            case ADD_CONTACT:
                name = JOptionPane.showInputDialog("Please insert contact name:");
                phoneNumber = JOptionPane.showInputDialog("Please insert contact phone number:");
                _phoneBook.add(name, phoneNumber);
                JOptionPane.showMessageDialog(null, "The contact " + name + " added to phone book");
                break;

            case REMOVE_CONTACT:
                name = JOptionPane.showInputDialog("Please insert contact name:");
                if (_phoneBook.remove(name)) {
                    JOptionPane.showMessageDialog(null, "The contact " + name + " removed from phone book");
                } else {
                    JOptionPane.showMessageDialog(null, "The contact " + name + " not found in phone book");
                }

                break;

            case UPDATE_CONTACT:
                name = JOptionPane.showInputDialog("Please insert contact name:");
                String newName = JOptionPane.showInputDialog("Please insert contact new name:");
                phoneNumber = JOptionPane.showInputDialog("Please insert contact new phone number:");
                _phoneBook.update(name, newName, phoneNumber);
                JOptionPane.showMessageDialog(null, "The contact " + name + " updated");
                break;

            default:
                if (answer != EXIT) {
                    JOptionPane.showMessageDialog(null, "Illegal number, please insert again");
                }

                break;
        }


    }
}






package Mmn11.Q1;

import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


public class PosRunFile {

    private static final int ADD_PRODUCT = 1, PRODUCT_LIST = 2, TOTAL_PAYMENT = 3, PAYMENT = 4, CURRENT_POS_ACCOUNT = 5,
            EXIT = 6;
    private static final String POS_MENU = "Please choose one of the following methods:" + "\n1 - Add new product to shopping cart"
            + "\n2 - Shopping cart list" + "\n3 - Total to pay" + "\n4 - payment" + "\n5 - POS account status"
            + "\n6 - Exit";

    public static void main(String[] args) {
        String initialCash = JOptionPane.showInputDialog("Please inset the initial money in the POS machine:");
        Pos pos;

        if (initialCash != null) {
            pos = new Pos(Float.parseFloat(initialCash));
        } else {
            pos = new Pos();
        }

        int answer = 0;
        while (answer != EXIT) {
            answer = Integer.parseInt(JOptionPane.showInputDialog(POS_MENU));
            yourWishIsMyCommand(answer, pos);
        }
    }

    private static void yourWishIsMyCommand(int answer, Pos pos) {
        switch (answer) {

            case ADD_PRODUCT:
                String name = JOptionPane.showInputDialog("Please insert product name:");
                float price = Float.parseFloat(JOptionPane.showInputDialog("Please insert product price:"));
                float amount = Float.parseFloat(JOptionPane.showInputDialog("Please insert product amount:"));
                pos.addProductToCart(new Product(name, price, amount));
                JOptionPane.showMessageDialog(null, "The product " + name + " added to shopping cart");
                break;

            case PRODUCT_LIST:
                Product p[] = pos.getProductArray();
                JOptionPane.showMessageDialog(null, p, "Your product list", INFORMATION_MESSAGE);
                break;

            case TOTAL_PAYMENT:
                JOptionPane.showMessageDialog(null, "Total to pay: " + pos.getTotalToPay());
                break;

            case PAYMENT:
                float client_cash = Float.parseFloat(JOptionPane.showInputDialog("Please enter money."));
                if (client_cash < pos.getTotalToPay()) {
                    JOptionPane.showMessageDialog(null, "Sorry but your money is not enough\n Please give us a bit more!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Thank you about your payment.\n\tchange: " + pos.payment(client_cash));
                }
                break;

            case CURRENT_POS_ACCOUNT:
                JOptionPane.showMessageDialog(null, "The POS cash status is: " + pos.getCurrentPosAccount());
                break;

            default:
                if(answer != EXIT){
                    JOptionPane.showMessageDialog(null, "Illegal number, please insert again");
                }

                break;
        }

    }
}



package Mmn12.Q2;

import javax.swing.*;

public class BigintRunFile {

    public static void main (String argv[]){
        String bigIntString1,bigIntString2;
        do {
            bigIntString1 = JOptionPane.showInputDialog("Please insert big integer 1: ");
        }while (!isValidateText(bigIntString1));

        do {
            bigIntString2 = JOptionPane.showInputDialog("Please insert big integer 2: ");
        }while (!isValidateText(bigIntString2));

        BigInt bInt1 = new BigInt(bigIntString1);
        BigInt bInt2 = new BigInt(bigIntString2);

        bInt1.plus(bInt2);
        JOptionPane.showMessageDialog(null, "BigInt1 plus BigInt2 is: " + bInt1);
        bInt1 = new BigInt(bigIntString1);

        bInt1.minus(bInt2);
        JOptionPane.showMessageDialog(null, "BigInt1 minus BigInt2 is: " + bInt1);
        bInt1 = new BigInt(bigIntString1);

        bInt1.multiply(bInt2);
        JOptionPane.showMessageDialog(null, "BigInt1 multiply BigInt2 is: " + bInt1);
        bInt1 = new BigInt(bigIntString1);

        bInt1.divide(bInt2);
        JOptionPane.showMessageDialog(null, "BigInt1 divide BigInt2 is: " + bInt1);


    }

    private static boolean isValidateText(String bigIntAsString){
        if(bigIntAsString.length() == 0){
            return false;
        }
        if(bigIntAsString.charAt(0) != '+' && bigIntAsString.charAt(0) != '-' ){
            return false;
        }
        for (int i =1;i<bigIntAsString.length();i++){
            if (!Character.isDigit(bigIntAsString.charAt(i))){
                return false;
            }
        }
        return true;
    }

}





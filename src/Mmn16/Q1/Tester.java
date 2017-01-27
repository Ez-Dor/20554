package Mmn16.Q1;


public class Tester {
    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI(7777);
        ClientGUI c1 = new ClientGUI("localhost", 7777);
        ClientGUI c2 = new ClientGUI("localhost", 7777);
        ClientGUI c3 = new ClientGUI("localhost", 7777);

    }

}

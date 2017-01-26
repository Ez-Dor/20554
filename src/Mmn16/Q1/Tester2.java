package Mmn16.Q1;


public class Tester2 {
    public static void main(String[] args) {
        ClientInChatRoom c2 = new ClientInChatRoom("2");


        Thread two = new Thread(c2);
        two.start();

    }

}

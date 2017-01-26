package Mmn16.Q1;


public class Tester {
    public static void main(String[] args) {
        ClientInChatRoom c1 = new ClientInChatRoom("1");
       Thread one = new Thread(c1);
        one.start();

    }

}

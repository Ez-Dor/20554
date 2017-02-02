package Mmn16.Q2;


public class Runner {
    public static void main(String[] args) {
        Client client1 = new Client("localhost", 4445, "1", false);
        Client client2 = new Client("localhost", 4445, "2", true);
        client1.start();
        client2.start();
    }
}

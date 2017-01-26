package Mmn16.Q1;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class ClientInChatRoom implements Runnable {
    private String a;

    public ClientInChatRoom(String a) {
        this.a = a;
    }

    public void run() {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String host = "localhost";
        try {
            socket = new Socket(host, 7777);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("After connection");
            String s = JOptionPane.showInputDialog(null, a + " - Enter a string to send:");
            while (s != null) {
                out.println(s);
                System.out.println(in.readLine());
                s = JOptionPane.showInputDialog(null, a + " - Enter a string to send:");
            }

            out.close();
            in.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



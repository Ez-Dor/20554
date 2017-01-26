package Mmn16.Q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class EchoThread extends Thread{
    private Socket _socket = null;
    private PrintWriter _out;
    private BufferedReader _in;

    public EchoThread(Socket socket) {
        _socket = socket;
        try {
            _out = new PrintWriter(_socket.getOutputStream(), true);
            _in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void run()
    {
        String input;
        try {
            input = _in.readLine();
            while(input != null)
            {
                _out.println(input);
                input = _in.readLine();
            }
            _out.println("im out");
            _in.close();
            _out.close();
            _socket.close();
        }
        catch(IOException e) { e.printStackTrace(); }
    }
}



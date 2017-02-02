package Mmn16.Q2;


import java.io.IOException;
import java.net.*;

public class Client extends Thread {
    private String _host;
    private byte[] _buffer;
    private int _port;
    private boolean _isWaitingToReceiveMessages;
    private String _name;

    final int NUM_OF_MESSAGE = 10,
            TIME_OUT = 10000; //ten sec

    public Client(String _host, int _port, String _name, boolean _isWaitingToReceiveMessages) {
        this._host = _host;
        this._isWaitingToReceiveMessages = _isWaitingToReceiveMessages;
        this._port = _port;
        this._name = _name;
        _buffer = new byte[256];
    }

    public void run() {

        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(_host);
            socket.setSoTimeout(TIME_OUT);
            for (int i = 0; i < NUM_OF_MESSAGE; i++) {

                String message = Integer.toString(i);

                //send message
                _buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(_buffer, _buffer.length, address, _port);
                socket.send(packet);
                packet = new DatagramPacket(_buffer, _buffer.length);

                //get response
                socket.receive(packet);
                _buffer = packet.getData();
                int len = packet.getLength();
                String received = (new String(_buffer).substring(0, len));

                while (_isWaitingToReceiveMessages && !(received.equals(message))) {
                    socket.receive(packet);
                    _buffer = packet.getData();
                    len = packet.getLength();
                    received = (new String(_buffer).substring(0, len));
                }

                System.out.println("Name: " + _name + " message: " + received + " is \"waiting-mode\":  " + _isWaitingToReceiveMessages);
            }


            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

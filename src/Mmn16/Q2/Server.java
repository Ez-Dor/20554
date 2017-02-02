package Mmn16.Q2;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    private DatagramSocket _socket = null;
    private boolean _moreClients = true;

    public Server() {
        try {
            _socket = new DatagramSocket(4445);
            System.out.println("server ready...");
        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void start() {

        DatagramPacket packet;

        while (_moreClients) {

            try {
                byte[] buf = new byte[256];

                //get message
                packet = new DatagramPacket(buf, buf.length);
                _socket.receive(packet);
                buf = packet.getData();
                int len = packet.getLength();
                String received = (new String(buf).substring(0, len));
                System.out.println(received);

                //return the message
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                _socket.send(packet);

            } catch (IOException e) {
                e.printStackTrace();
                _moreClients = false;
            }
        }
        _socket.close();
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}

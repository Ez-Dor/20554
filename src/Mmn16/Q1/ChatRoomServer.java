package Mmn16.Q1;

import java.net.*;
import java.io.*;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatRoomServer {
    private LinkedList<User> _users;
    private ServerSocket _serverSocket;
    private boolean _listening;
    private ExecutorService runGame; // will run players

    public ChatRoomServer() throws IOException {
        _users = new LinkedList<User>();
        _serverSocket = null;
        _listening = true;
        runGame = Executors.newCachedThreadPool();
        try {
            _serverSocket = new ServerSocket(7777);
            System.out.println("Server's ready");
            Socket socket = null;
            while (_listening) {
                _users.addFirst(new User(_serverSocket.accept()));
                runGame.execute(_users.getFirst());

            }
        } catch (InterruptedIOException e) {
            System.out.println("Time out");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


    }

    private void sendMessageToAllUsers(String message) {
        for (User user : _users) {
            user.sendMessageToUser(message);
        }
    }

    private void userLeaveChatRoom(User user) {
        _users.remove(user);
    }




    // private inner class User manages each User as a runnable
    private class User implements Runnable {
        private Socket connection; // connection to client
        private BufferedReader input;
        private PrintWriter output;
        private String _name; // mark for this player

        // set up User thread
        public User(Socket socket) {
            _name = socket.getInetAddress().getHostName();
            connection = socket; // store socket for client
            sendMessageToAllUsers("User " + _name + " has joined to conversation.");
            try // obtain streams from Socket
            {
                input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                output = new PrintWriter(connection.getOutputStream(), true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }

        // send message that other player moved
        public void sendMessageToUser(String message) {
            output.println(message);
        }

        // control thread's execution
        public void run() {
            // send client its mark (X or O), process messages from client

            try {
                String message = input.readLine();
                while (message != null) {
                    sendMessageToAllUsers(message);
                    message = input.readLine();
                }
                userLeaveChatRoom(this);
                sendMessageToAllUsers("User leave chat room");
                input.close();
                output.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        ChatRoomServer c = new ChatRoomServer();
    }
}





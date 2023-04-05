package lk.ijse.dep10;

import lk.ijse.dep10.shared.Dep10Headers;
import lk.ijse.dep10.shared.Dep10Message;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerAppInitializer {
    private static volatile ArrayList<Socket> localSocketList = new ArrayList<>();
    private static volatile ArrayList<String> userList = new ArrayList<>();
    private static volatile String chatHistory = "";




    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server is listening to 5050");


        while (true) {
            System.out.println("Waiting for an incoming client");
            Socket localSocket = serverSocket.accept();
            System.out.println("Incoming client " + localSocket.getRemoteSocketAddress());

            InetSocketAddress remoteAddress = (InetSocketAddress) localSocket.getRemoteSocketAddress();
            String ipAddress = remoteAddress.getHostName();
            userList.add(ipAddress);
            localSocketList.add(localSocket);


            broadCastConnectedUsers();


            new Thread(() -> {
                /*send chat history to new user*/
                try {
                    sendChatHistory(localSocket);

                    InputStream is = localSocket.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);
                    Dep10Message dep10Message = (Dep10Message) ois.readObject();

                    if (dep10Message.getHeader() == Dep10Headers.MSG) {
                        chatHistory += ipAddress + " " + dep10Message.getBody();
                        broadCastChatHistory();
                    }


                } catch (Exception e) {
                    userList.remove(ipAddress);
                    localSocketList.remove(localSocket);
                    broadCastConnectedUsers();
                    e.printStackTrace();
                }



            }).start();

        }


    }

    private static void broadCastConnectedUsers() {
        for (Socket socket : localSocketList) {
            new Thread(()->{
                try {
                    OutputStream os = socket.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);

                    Dep10Message msg = new Dep10Message(Dep10Headers.USERS, userList);
                    oos.writeObject(msg);
                    oos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }


    private static void broadCastChatHistory() {
        for (Socket socket : localSocketList) {
            new Thread(()->{
                try {
                    OutputStream os = socket.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);

                    Dep10Message msg = new Dep10Message(Dep10Headers.USERS, chatHistory);
                    oos.writeObject(msg);
                    oos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    private static void sendChatHistory(Socket localSocket) throws IOException {
        OutputStream os = localSocket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        Dep10Message msg=new Dep10Message(Dep10Headers.MSG, chatHistory);
        oos.writeObject(msg);
        oos.flush();

    }
}

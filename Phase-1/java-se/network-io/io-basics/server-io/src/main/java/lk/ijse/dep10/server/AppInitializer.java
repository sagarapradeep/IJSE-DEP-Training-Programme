package lk.ijse.dep10.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Remote;

public class AppInitializer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server Started & listening to 5050!");

        while (true) {
            Socket localSocket = serverSocket.accept();
            System.out.println("Incoming connection "+ localSocket.getRemoteSocketAddress());

            new Thread(()->{
                InputStream is = null;
                try {
                    is = localSocket.getInputStream();
                    while(true) {
                        byte[] buffer = new byte[1024];
                        int read = is.read(buffer);
                        if(read ==-1)break;
                        System.out.println("new Message from " + localSocket.getRemoteSocketAddress());
                        System.out.print(new String(buffer, 0, read));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }).start();

        }






    }
}

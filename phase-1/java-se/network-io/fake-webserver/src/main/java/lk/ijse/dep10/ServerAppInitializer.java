package lk.ijse.dep10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerAppInitializer {
    public static void main(String[] args) throws IOException {

        String port = System.getProperty("port", "5050");
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
        System.out.println("A fake webserver created and starts in port "+port);

        while (true) {
            Socket localSocket = serverSocket.accept();
            System.out.println("New connection!" + localSocket.getRemoteSocketAddress());

            new Thread(() -> {
                try {
                    InputStream inputStream = localSocket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    while (true) {
                        String line = br.readLine();

                        Pattern regExp = Pattern.compile("^GET(.+) (HTTP/[0-9.]{0,3})$");
                        Matcher matcher = regExp.matcher(line);


                        if (matcher.find()) {
                            System.out.println(line);
                            System.out.println("URI - " + matcher.group(1));
                            System.out.println("HTTP Version- " + matcher.group(2));

                            StringBuilder responseHeader = new StringBuilder();
                            responseHeader.append(matcher.group(2)).append(" ").append(200).append(" OK").append("\n");
                            responseHeader.append("Content Type: text/html").append("\n\n");


                            localSocket.getOutputStream().write(responseHeader.toString().getBytes());
                            localSocket.getOutputStream().flush();


                            localSocket.getOutputStream().write("<h1>This is a fake webserver </h1>".getBytes());
                            localSocket.getOutputStream().write(("The requested resource is "+matcher.group(1)).getBytes());
                            localSocket.getOutputStream().flush();

                        }


                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }).start();
        }
    }
}

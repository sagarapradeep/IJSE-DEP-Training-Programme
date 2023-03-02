package lk.ijse.dep10.client.controler;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ijse.dep10.shared.Dep10Headers;
import lk.ijse.dep10.shared.Dep10Message;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ChatViewController {

    public TextArea txtChatHistory;
    @FXML
    private ListView<String> lstMessages;

    @FXML
    private ListView<String> lstUsers;

    @FXML
    private TextField txtMessage;

    private Socket socket;

    public void initialize() {
        connect();

        readServerResponses();



    }

    public void connect() {
        try {
            socket = new Socket("192.168.8.117", 5050);
            Platform.runLater(()->{
                txtMessage.getScene().getWindow().setOnCloseRequest(windowEvent -> {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        new Alert(Alert.AlertType.ERROR, "Failed to close the Server Socket!").show();
                    }
                });

            });


        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to connect the server!").showAndWait();
            Platform.exit();
        }

    }

    @FXML
    void txtMessageOnAction(ActionEvent event) {
        try {
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            Dep10Message msg = new Dep10Message(Dep10Headers.MSG, txtMessage.getText());
            oos.writeObject(msg);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to send the messages");

        }


    }

    public void readServerResponses( )
    {

        new Thread(()->{
            try {
                InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                Dep10Message msg = (Dep10Message) ois.readObject();
                if(msg.getHeader()==Dep10Headers.MSG){
                    txtChatHistory.setText(msg.getBody().toString());

                }else {
                    Platform.runLater(()->{
                        ObservableList<String> userList = lstUsers.getItems();
                        userList.clear();
                        userList.addAll((ArrayList<String>)msg.getBody());
                    });

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }

}

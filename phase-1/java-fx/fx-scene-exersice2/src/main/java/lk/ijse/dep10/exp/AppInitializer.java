package lk.ijse.dep10.exp;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);

    }

    private void mainScene(Stage stage) {
        stage.setTitle("Student Form");


        Label lblTitle = new Label(("Student Form").toUpperCase());
        lblTitle.setFont(Font.font("Ubuntu",FontWeight.BOLD,40));

        lblTitle.setTextFill(Color.NAVY);
        lblTitle.setPadding(new Insets(20, 40, 20, 30));

        Label validateId = new Label("Invalid Id (Correct form S***)");                         //labels for validation
        validateId.setTextFill(Color.RED);
        validateId.setVisible(false);
        Label validateName = new Label("Invalid Name");
        validateName.setTextFill(Color.RED);
        validateName.setVisible(false);
        Label validateNIC = new Label("Invalid NIC");
        validateNIC.setTextFill(Color.RED);
        validateNIC.setVisible(false);
        Label validateContact = new Label("Invalid Contact Number");
        validateContact.setTextFill(Color.RED);
        validateContact.setVisible(false);

        GridPane gridPane = new GridPane();
        gridPane.add(lblTitle, 0, 0, 2, 1);         //add title
        GridPane.setHalignment(lblTitle, HPos.CENTER);
//        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);

        Label lblId = new Label("ID");          //define labels for name,id
        lblId.setPadding(new Insets(10));
        lblId.setFont(Font.font("Ubuntu",FontWeight.BOLD,20));
        GridPane.setHalignment(lblId,HPos.RIGHT);

        Label lblName = new Label("Name");
        lblName.setFont(Font.font("Ubuntu",FontWeight.BOLD,20));
        lblName.setPadding(new Insets(10));
        GridPane.setHalignment(lblName,HPos.RIGHT);

        Label lblNIC = new Label("NIC");
        lblNIC.setFont(Font.font("Ubuntu",FontWeight.BOLD,20));
        lblNIC.setPadding(new Insets(10));
        GridPane.setHalignment(lblNIC,HPos.RIGHT);

        Label lblCntNum = new Label("Contact Number");
        lblCntNum.setFont(Font.font("Ubuntu",FontWeight.BOLD,20));
        lblCntNum.setPadding(new Insets(10));
        GridPane.setHalignment(lblCntNum,HPos.RIGHT);

        gridPane.add(lblId, 0, 1);                  //place labels for name, id
        gridPane.add(lblName, 0, 3);
        gridPane.add(lblNIC, 0, 5);
        gridPane.add(lblCntNum, 0, 7);

        ColumnConstraints column1 = new ColumnConstraints();        //set column constrains for column 1
        column1.setPrefWidth(200);
        gridPane.getColumnConstraints().add(column1);


        TextField txtId = new TextField();      //text fields
        txtId.setMaxWidth(100);


        TextField  txtName = new TextField ();
        txtName.setMaxWidth(650);


        TextField  txtNIC = new TextField ();
        txtNIC.setMaxWidth(400);


        TextField  txtCntNum = new TextField ();
        txtCntNum.setMaxWidth(600);


        gridPane.add(txtId, 1, 1, 2, 1);        //id text field place with invalid
        gridPane.add(validateId,1,2,3,1);
        GridPane.setHalignment(validateId,HPos.LEFT);


        gridPane.add(txtName, 1, 3, 4, 1);      //Name text field place with invalid
        gridPane.add(validateName,1,4,5,1);
        GridPane.setHalignment(validateName,HPos.LEFT);

//
        gridPane.add(txtNIC, 1, 5, 6, 1);       //Nic text field place with invalid
        gridPane.add(validateNIC,1,6,7,1);
        GridPane.setHalignment(validateNIC,HPos.LEFT);


        gridPane.add(txtCntNum, 1, 7, 8, 1);        //Contact text field place with invalid
        gridPane.add(validateContact,1,8,9,1);
        GridPane.setHalignment(validateContact,HPos.LEFT);


        ColumnConstraints column2 = new ColumnConstraints();        //set column constrains for column 1
        column2.setPercentWidth(70);
        gridPane.getColumnConstraints().add(column2);

        Button btnValidate = new Button("Validate");        //set and position validate button
        btnValidate.setBackground(Background.fill(Color.NAVY));
        btnValidate.setFont(Font.font("Ubuntu",FontWeight.BOLD,16));
        btnValidate.setTextFill(Color.WHEAT);
        btnValidate.setPadding(new Insets(10));
        btnValidate.setDefaultButton(true);
        GridPane.setHalignment(btnValidate,HPos.CENTER);

        gridPane.add(btnValidate,0,10,2,10);

        btnValidate.setOnAction(event ->
        {
            String id = txtId.getText();
            String nic = txtNIC.getText();
            String name = txtName.getText();
            String contactNum = txtCntNum.getText();
            if(!(idValidation(id))){
                validateId.setVisible(true);
                txtId.selectAll();
            }
            else validateId.setVisible(false);
            if(!(nicValidation(nic))){
                validateNIC.setVisible(true);
                txtNIC.selectAll();
            }
            else validateNIC.setVisible(false);
            if (!(nameValidate(name))) {
                validateName.setVisible(true);
                txtName.selectAll();
            }
            else validateName.setVisible(false);
            if (!(contactNumberValidate(contactNum))) {
                validateContact.setVisible(true);
                txtCntNum.selectAll();
            }
            else validateContact.setVisible(false);

        });

        gridPane.setVgap(5);

        gridPane.setPrefWidth(700);
        gridPane.setPadding(new Insets(20));

        gridPane.setBackground(Background.fill(Color.web("Lightblue")));

        Scene scene = new Scene(gridPane);

        stage.setScene(scene);
        stage.setMinWidth(500);


        stage.centerOnScreen();
        stage.show();

    }

    public boolean idValidation(String id) {
        if (id.length() == 0||id.length()!=4) {
            return false;
        }

        char[] idCharArray=id.toCharArray();
        String firstLetter = idCharArray[0] + "";

        boolean condition = (((firstLetter).equalsIgnoreCase("S")));
        System.out.println(condition);
        if (condition) {
            for (int i = 1; i < 3; i++) {
                if (!(Character.isDigit(idCharArray[i]))) {
                    condition=false;
                    break;
                }
            }
        }
        return condition;
    }

    public boolean nicValidation(String nic) {
        if (nic.length() != 10) {
            return false;
        }
        char[] nicCharArray=nic.toCharArray();
        String lastLetter = nicCharArray[nicCharArray.length-1] + "";


        boolean condition = (((lastLetter).equalsIgnoreCase("V")));
        System.out.println(condition);
        if (condition) {
            for (int i = 0; i < 9; i++) {
                if (!(Character.isDigit(nicCharArray[i]))) {
                    condition=false;
                    break;
                }
            }
        }
        return condition;
    }

    public boolean nameValidate(String name) {
        boolean condition =!name.isEmpty();
        condition = condition && !name.isBlank();
        return condition;
    }

    public boolean contactNumberValidate(String number) {
        char[] charNumArray = number.toCharArray();
        boolean condition =true;
        if ((number.length() != 11) || (charNumArray[3] != '-')) {
            return false;
        }
        for (int i = 0; i < charNumArray.length; i++) {
            if(i==3)continue;
            else if (!Character.isDigit(charNumArray[i])) {
                condition=false;
                break;

            }
        }
        return condition;

    }
}

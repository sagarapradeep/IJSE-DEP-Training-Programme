import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void start(Stage primaryStage) {
        String[] firstWindowButtonSet = new String[]{"Anchor Pane", "Flow Pane", "Tile Pane", "Stack Pane", "Grid Pane","H Box","V Box"};
        String[] commonButtonSet = new String[]{"Button 1", "Button 2", "Button 3", "Button 4","Button 5"};
        gridPane(firstWindowButtonSet,commonButtonSet);

    }

    public void gridPane(String[] fistWindowButtonSet, String[] commonButtonSet) {      //done

        Button[] btnArray = mainPanelButtonInitializer(fistWindowButtonSet);
        Text text = new Text();
        text.setText("Java FX Containers");



        btnArray[0].setOnAction(event -> {
            anchorPane(commonButtonSet);
        });
        btnArray[1].setOnAction(event -> {
            flowPane(commonButtonSet);
        });
        btnArray[2].setOnAction(event -> {
            tilePane(commonButtonSet);
        });
        btnArray[3].setOnAction(event -> {
            stackPane(commonButtonSet);
        });
        btnArray[4].setOnAction(event -> {
            gridPane(commonButtonSet);
        });
        btnArray[5].setOnAction(event -> {
            hBox(commonButtonSet);
        });
        btnArray[6].setOnAction(event -> {
            vBox(commonButtonSet);
        });
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));

        GridPane gridPane = new GridPane();     //create grid pane container
        gridPane.add(text,0,0);
        btnArray[0].setStyle("-fx-background-color: Red");
        gridPane.add(btnArray[0], 0, 1);
        btnArray[1].setStyle("-fx-background-color: Orange");
        gridPane.add(btnArray[1], 0, 2);
        btnArray[2].setStyle("-fx-background-color: Yellow");
        gridPane.add(btnArray[2], 0, 3);
        btnArray[3].setStyle("-fx-background-color: Green");
        gridPane.add(btnArray[3], 0, 4);
        btnArray[4].setStyle("-fx-background-color: Blue");
        gridPane.add(btnArray[4], 0, 5);
        btnArray[5].setStyle("-fx-background-color: Indigo");
        gridPane.add(btnArray[5], 0, 6);
        btnArray[6].setStyle("-fx-background-color: Purple");
        gridPane.add(btnArray[6], 0, 7);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(20, 50, 20, 50));

        for (int i = 0; i < btnArray.length; i++) {
            GridPane.setHalignment(btnArray[i], HPos.CENTER);
        }

        Scene scene = new Scene(gridPane);
        scene.setFill(Color.YELLOWGREEN);

        stage("Interface 1", scene);
    }

    public void anchorPane(String[] commonButtonSet) {      //done
        Button[] btnArray = buttonInitializer(commonButtonSet);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(btnArray[0], btnArray[1], btnArray[2], btnArray[3], btnArray[4]);

        btnArray[0].setLayoutX(10);
        btnArray[0].setLayoutY(10);

        btnArray[1].setLayoutX(10);
        btnArray[1].setLayoutY(60);

        btnArray[2].setLayoutX(10);
        btnArray[2].setLayoutY(110);

        btnArray[3].setLayoutX(10);
        btnArray[3].setLayoutY(160);

        btnArray[4].setLayoutX(10);
        btnArray[4].setLayoutY(210);

        anchorPane.setPadding(new Insets(10,100,10,10));
        Scene scene = new Scene(anchorPane);
        stage("Anchor Pane",scene);

    }

    public void flowPane(String[] commonButtonSet) {        //done
        Button[] btnArray = buttonInitializer(commonButtonSet);
        FlowPane flowPane = new FlowPane();

        flowPane.getChildren().addAll(btnArray[0], btnArray[1], btnArray[2], btnArray[3], btnArray[4]);
        flowPane.setHgap(15);
        flowPane.setVgap(15);
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(flowPane);

        Stage stage = new Stage();      //create new stage
        stage.setTitle("Tile Pane");      //set title

        stage.setScene(scene);
        stage.setResizable(true);          //enable resizable for flow pane only

        stage.sizeToScene();        //create stage size as scene size
        stage.show();

    }

    public void tilePane(String[] commonButtonSet) {        //done
        Button[] btnArray = buttonInitializer(commonButtonSet);
        TilePane tilePane = new TilePane();

        tilePane.setHgap(20);
        tilePane.getChildren().addAll(btnArray[0], btnArray[1], btnArray[2], btnArray[3], btnArray[4]);

        tilePane.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(tilePane);
        stage("Tile Pane", scene);
    }

    public void stackPane(String[] commonButtonSet) {
        Button[] btnArray = buttonInitializer(commonButtonSet);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(btnArray[0]);
        StackPane.setAlignment(btnArray[0], Pos.TOP_LEFT);
        stackPane.getChildren().add(btnArray[1]);
        StackPane.setAlignment(btnArray[1],Pos.TOP_RIGHT);
        stackPane.getChildren().add(btnArray[2]);
        StackPane.setAlignment(btnArray[2],Pos.CENTER);
        stackPane.getChildren().add(btnArray[3]);
        StackPane.setAlignment(btnArray[3],Pos.BOTTOM_LEFT);
        stackPane.getChildren().add(btnArray[4]);
        StackPane.setAlignment(btnArray[4],Pos.BOTTOM_RIGHT);

        stackPane.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(stackPane,200,145);
        stage("Stack Pane", scene);
    }

    public void gridPane(String[] commonButtonSet) {
        Button[] btnArray = buttonInitializer(commonButtonSet);
        GridPane gridPane = new GridPane();

        gridPane.add(btnArray[0], 0, 0);
        gridPane.add(btnArray[1], 0, 1);
        gridPane.add(btnArray[2], 0, 2);
        gridPane.add(btnArray[3], 0, 3);
        gridPane.add(btnArray[4], 0, 4);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 50, 20, 50));
        for (int i = 0; i < btnArray.length; i++) {
            GridPane.setHalignment(btnArray[i], HPos.CENTER);
        }

        Scene scene = new Scene(gridPane);
        stage("Grid Pane", scene);
    }

    public void hBox(String[] commonButtonSet) {
        Button[] btnArray = buttonInitializer(commonButtonSet);
        HBox hBox = new HBox(15, btnArray);
        Scene scene = new Scene(hBox);
        hBox.setPadding(new Insets(15, 20, 15, 20));
        stage("H Box", scene);
    }

    public void vBox(String[] commonButtonSet) {
        Button[] btnArray = buttonInitializer(commonButtonSet);
        VBox vBox = new VBox(15, btnArray);
        Scene scene = new Scene(vBox);
        vBox.setPadding(new Insets(15, 25, 15, 25));
        stage("V Box", scene);
    }

    public void stage(String title,Scene scene) {
        Stage stage = new Stage();      //create new stage
        stage.setTitle(title);      //set title

        stage.setScene(scene);
        stage.setResizable(true);          //disable resizing option

        stage.sizeToScene();        //create stage size as scene size
        stage.show();                       //show stage
    }

    public Button[] mainPanelButtonInitializer(String[] btnList) {
        Button[] buttons = new Button[7];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(btnList[i]);
        }
        return buttons;

    }

    public Button[] buttonInitializer(String[]buttons) {
        Button[] button = new Button[5];

        for (int i = 0; i < button.length; i++) {
            button[i] = new Button(buttons[i]);
        }
        return button;
    }
}

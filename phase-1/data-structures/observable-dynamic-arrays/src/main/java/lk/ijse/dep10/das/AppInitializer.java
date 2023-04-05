package lk.ijse.dep10.das;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableList ol = FXCollections.observableArrayList();        //create observable array list


        /*Subscribers for observable array list*/
        ListChangeListener subscriber1 = change -> System.out.println("Subscriber 1 "+change);
        ListChangeListener subscriber2 = change -> System.out.println("Subscriber 2 "+change);
        ListChangeListener subscriber3 = change -> System.out.println("Subscriber 3 "+change);
        ListChangeListener subscriber4 = change -> System.out.println(change);

        ol.addListener(subscriber1);
//        ol.addListener(subscriber2);
        ol.addListener(subscriber3);

        ol.add(10);
        ol.add(20);

        ol.remove(0);

        ol.set(0, 1);



//        ol.add(10);
//        ol.addAll(12, 3, 45, 56, 67, 78, 5);
//        System.out.println(ol);
//        System.out.println(ol.size());
//        System.out.println(ol.get(0));
//        System.out.println(ol.contains(45));

    }
}

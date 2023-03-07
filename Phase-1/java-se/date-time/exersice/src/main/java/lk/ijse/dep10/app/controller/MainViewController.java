package lk.ijse.dep10.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.LocalDate;

public class MainViewController {

    public Label lblHint;
    @FXML
    private ComboBox<String> cmbtype;

    @FXML
    private DatePicker dptOut;

    @FXML
    private DatePicker dtpIn;

    @FXML
    private Label lblRate;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblTotalDates;

    public void initialize() {
        ObservableList<String> typeList = cmbtype.getItems();
        typeList.add("Economy");
        typeList.add("Premium Economy");
        typeList.add("Business Executive");
        typeList.add("First Class");
    }

    @FXML
    void cmbtypeOnAction(ActionEvent event) {
        String selectedItem = cmbtype.getSelectionModel().getSelectedItem();
        switch (selectedItem) {
            case"Economy":
                lblRate.setText("Rate 5$");
                break;
            case"Premium Economy":
                lblRate.setText("Rate 7$");
                break;
            case"Business Executive":
                lblRate.setText("Rate 10$");
                break;
            case"First Class":
                lblRate.setText("Rate 15$");
                break;
            default:
                lblRate.setText("Select Type to display rates");

        }
        calculateTotal();



    }

    @FXML
    void dptOutOnAction(ActionEvent event) {
        calculateTotal();

    }

    @FXML
    void dtpInOnAction(ActionEvent event) {
        calculateTotal();

    }

    private void calculateTotal() {
        int selectedIndex = cmbtype.getSelectionModel().getSelectedIndex();
        if(selectedIndex==-1)return;

        int[] rate = new int[]{5, 7, 10, 15};

        if (dtpIn.getValue() == null || dptOut.getValue() == null) {
            lblHint.setText("Select In and Out Dates");
            return;
        } else if (dtpIn.getValue().isAfter(dptOut.getValue())) {
            lblHint.setText("In and out date invalid");
            return;
        } else if (dtpIn.getValue().isEqual(dptOut.getValue())) {
            lblHint.setText("In And out dates cannot be same");
        }
        LocalDate inDate =dtpIn.getValue();
        LocalDate outDate = dptOut.getValue();

        long days = Duration.between(outDate.atStartOfDay(), (inDate.atStartOfDay())).toDays();
        lblHint.setText("Num of Days " + days);

        long total = rate[selectedIndex] * days;
        lblTotal.setText(String.format("Total: %.2s", ((double)total)));

    }

}

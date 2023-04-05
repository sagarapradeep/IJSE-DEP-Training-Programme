package lk.ijse.dep10.se.controller;

import javafx.beans.binding.ObjectExpression;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.se.model.Item;

import java.math.BigDecimal;

public class MainSceneController {

    public Label lblEstTotalProfit;
    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Item> tblItems;

    @FXML
    private TextField txtBuyingPrice;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtSellingPrice;

    public void initialize() {
        btnNew.fire();
        ObservableList<TableColumn<Item, ?>> columnsList = tblItems.getColumns();
        columnsList.get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        columnsList.get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        columnsList.get(2).setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
        columnsList.get(3).setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        columnsList.get(4).setCellValueFactory(new PropertyValueFactory<>("profit"));
        columnsList.get(5).setCellValueFactory(new PropertyValueFactory<>("qty"));
        columnsList.get(6).setCellValueFactory(new PropertyValueFactory<>("total"));
        columnsList.get(7).setCellValueFactory(new PropertyValueFactory<>("totalProfit"));

    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        txtCode.setText(generateID());
        txtDescription.clear();
        txtQty.clear();
        txtSellingPrice.clear();
        txtBuyingPrice.clear();
        tblItems.getSelectionModel().clearSelection();
        txtDescription.requestFocus();

    }

    private String generateID() {
        ObservableList<Item> itemList = tblItems.getItems();
        if(itemList.isEmpty()) return "I001";

        String code=itemList.get(itemList.size()-1).getCode();
        int newItemCode=Integer.parseInt(code.substring(1))+1;
        return String.format("I%03d", newItemCode);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Item newItem = new Item(txtCode.getText(), txtDescription.getText(), new BigDecimal(txtBuyingPrice.getText())
                , new BigDecimal(txtSellingPrice.getText()), Integer.parseInt(txtQty.getText()));



        ObservableList<Item> itemList = tblItems.getItems();
        itemList.add(newItem);
        lblEstTotalProfit.setText((calculateTotalProfit().setScale(2)).toString());

        btnNew.fire();


    }

    private BigDecimal calculateTotalProfit() {
        ObservableList<Item> items = tblItems.getItems();
        BigDecimal currentTotalProfit = BigDecimal.ZERO;

        for (Item item : items) {
            currentTotalProfit=currentTotalProfit.add(item.getTotalProfit());

        }
        return currentTotalProfit;
    }

    @FXML
    void txtBuyingPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtCodeOnAction(ActionEvent event) {

    }

    @FXML
    void txtDescriptionOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }

    @FXML
    void txtSellingPriceOnAction(ActionEvent event) {

    }





}

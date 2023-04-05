package lk.ijse.dep10.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.app.db.DBConnection;
import lk.ijse.dep10.app.model.Customer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

public class DataScene1ViewController {

    @FXML
    private Button btnBeanArrayDS;

    @FXML
    private Button btnBeanCollectionDS;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TextField txtSearch;
    private JasperReport jasperReport;


    public void initialize() {
        loadCustomer();
        txtSearch.textProperty().addListener(c -> loadCustomer());

        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));


        try {
            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/report/customer-report.jrxml"));

            jasperReport = JasperCompileManager.compileReport(design);


        } catch (JRException e) {
            throw new RuntimeException(e);
        }


    }

    public void loadCustomer()  {
        Connection connection = DBConnection.getInstance().getConnection();
        ObservableList<Customer> customerList = tblCustomer.getItems();
        customerList.clear();


        PreparedStatement stm = null;
        ResultSet resultSet = null;
        try {
            stm = connection.prepareStatement("SELECT *FROM Customer WHERE id LIKE ? OR name LIKE ? OR address LIKE ?");
            stm.setString(1,"%"+ txtSearch.getText()+"%");
            stm.setString(2, "%"+ txtSearch.getText()+"%");
            stm.setString(3, "%"+ txtSearch.getText()+"%");
            resultSet = stm.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        while (true) {
            try {
                if (!resultSet.next()) break;
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);

                Customer customer = new Customer(id, name, address);
                customerList.add(customer);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @FXML
    void btnBeanArrayDSOnAction(ActionEvent event) throws JRException {
        ObservableList<Customer> customerList = tblCustomer.getItems();
        Customer[] customers = customerList.toArray(new Customer[0]);


        HashMap<String, Object> reportParams = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(customers);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParams, dataSource);
        JasperViewer.viewReport(jasperPrint);


    }

    @FXML
    void btnBeanCollectionDSOnAction(ActionEvent event) throws JRException {
        ObservableList<Customer> customerList = tblCustomer.getItems();
        HashMap<String, Object> reportParam = new HashMap<>();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customerList);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParam, dataSource);
        JasperViewer.viewReport(jasperPrint);

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}

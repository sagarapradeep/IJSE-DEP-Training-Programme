package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.dep10.app.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

public class MainSceneController {

    public Button btnGenerateBarcode;
    public Button btnReportWithImages;
    @FXML
    private Button btnFinalReport;

    @FXML
    private Button btnReportParameters;

    @FXML
    private Button btnDataSource1;

    @FXML
    private Button btnDataSource2;

    @FXML
    void btnFinalReportOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Final report");
        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/FinalScene.fxml")).load()));
        stage.initModality(Modality.WINDOW_MODAL);

        stage.initOwner(btnDataSource1.getScene().getWindow());
        stage.setMaximized(true);

        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void btnReportParametersOnAction(ActionEvent event) throws IOException {

        Stage stage = new Stage();

        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/ReportParamView.fxml")).load()));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Jasper Scene with parameters");
        stage.initOwner(btnDataSource1.getScene().getWindow());
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();

    }

    @FXML
    void btnDataSource1OnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/DataScene1View.fxml")).load()));
        stage.setTitle("Collection DS vs Array DS");

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnDataSource1.getScene().getWindow());
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();

    }

    @FXML
    void btnDataSource2OnAction(ActionEvent event) throws JRException {
        JasperDesign jasperDesign = JRXmlLoader.load(this.getClass().getResourceAsStream("/report/customer-report-db.jrxml"));

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        HashMap<String, Object> reportParam = new HashMap<>();
        Connection dataSource = DBConnection.getInstance().getConnection();


        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParam, dataSource);
        JasperViewer.viewReport(jasperPrint);


    }

    public void btnGenerateBarcodeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/GenerateBarcodeView.fxml")).load()));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Barcode Generator");
        stage.initOwner(btnDataSource1.getScene().getWindow());
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void btnReportWithImagesOnAction(ActionEvent actionEvent) throws JRException {
        JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/report/report-with-image.jrxml"));

        JasperReport jasperReport = JasperCompileManager.compileReport(design);


        HashMap<String, Object> reportParam = new HashMap<>();
        JREmptyDataSource dataSource = new JREmptyDataSource(1);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParam, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
    }
}

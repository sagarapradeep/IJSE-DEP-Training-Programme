package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.Printer;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.util.HashMap;

public class MainViewController {

    private JasperPrint jasperPrint;

    public Button btnPrintReport;
    public Button btnExportReport;
    @FXML
    private Button btnShowReports;

    public void initialize() {

        try {
            JasperDesign jasperDesign = JRXmlLoader.load(this.getClass().getResourceAsStream("/report/hello-jasper.jrxml"));

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            HashMap<String, Object> reportParam = new HashMap<>();
            JREmptyDataSource dataSource = new JREmptyDataSource(5);


            jasperPrint = JasperFillManager.fillReport(jasperReport, reportParam, dataSource);

        } catch (JRException e) {
            e.printStackTrace();

        }


    }

    @FXML
    void btnShowReportsOnAction(ActionEvent event)  {


        /*Display report*/

        JasperViewer.viewReport(jasperPrint, false);
    }

    public void btnPrintReportOnAction(ActionEvent actionEvent) {

        Printer defaultPrinter = Printer.getDefaultPrinter();
        if (defaultPrinter == null) {
            new Alert(Alert.AlertType.ERROR, "No default printer has configured!").showAndWait();
            return;
        }

        try {
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public void btnExportReportOnAction(ActionEvent actionEvent) throws JRException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML File(*.xml)", "*.xml"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML File(*.html)", "*.html"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File(*.pdf)", "*.pdf"));

        File file = fileChooser.showSaveDialog(btnExportReport.getScene().getWindow());
        if (file == null) {
            return;
        }
        String selectedExtension = fileChooser.getSelectedExtensionFilter().getExtensions().get(0);


        switch (selectedExtension) {
            case "*.xml":
                JasperExportManager.exportReportToXmlFile(jasperPrint, file.getAbsolutePath()+".xml", true);
                break;

            case "*.html":
                JasperExportManager.exportReportToHtmlFile(jasperPrint, file.getAbsolutePath() + ".html");
                break;

            case "*.pdf":
                JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath() + ".pdf");
                break;
        }

    }
}

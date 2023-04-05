package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public class ReportParamController {

    @FXML
    private Button btnShowReport;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtTotal;

    @FXML
    private TextField txtUsername;
    private JasperReport jasperReport;

    public void initialize() throws JRException {

        JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/report/report-with-param.jrxml"));

        jasperReport = JasperCompileManager.compileReport(design);
    }

    @FXML
    void btnShowReportOnAction(ActionEvent event) throws JRException {
        String userName = txtUsername.getText();
        userName = userName.isBlank() ? "No user name selected" : userName;

        LocalDate date = txtDate.getValue();
        BigDecimal total = txtTotal.getText().isBlank() ? null : new BigDecimal(txtTotal.getText());


        HashMap<String, Object> reportParam = new HashMap<>();
        reportParam.put("username", userName);
        reportParam.put("date", date);
        reportParam.put("total", total);

        JREmptyDataSource dataSource = new JREmptyDataSource(1);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParam, dataSource);
        JasperViewer.viewReport(jasperPrint);

    }

}

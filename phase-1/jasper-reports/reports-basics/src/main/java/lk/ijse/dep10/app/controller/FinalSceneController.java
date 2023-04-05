package lk.ijse.dep10.app.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import lk.ijse.dep10.app.db.DBConnection;
import lk.ijse.dep10.app.model.Student;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.HashMap;

public class FinalSceneController {

    public TextField txtId;
    public ImageView imgBarcode;
    @FXML
    private Button btnBrows;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnPrintReport;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnSave;

    @FXML
    private ImageView imgPicture;

    @FXML
    private TableView<Student> tbl;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSearch;

    public void initialize() {

        tbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("displayId"));
        tbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("profilePicture"));
        tbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("contact"));

        tbl.getColumns().get(0).setStyle("-fx-alignment: Center");
        tbl.getColumns().get(1).setStyle("-fx-alignment: Center");
        tbl.getColumns().get(2).setStyle("-fx-alignment: Center");
        tbl.getColumns().get(3).setStyle("-fx-alignment: Center");
        tbl.getColumns().get(4).setStyle("-fx-alignment: Center");

        loadStudent();


        btnSave.setDefaultButton(true);

        btnClear.setDisable(true);
        btnPrintReport.setDisable(true);
        btnDelete.setDisable(true);
        Platform.runLater(txtName::requestFocus);

        imgPicture.imageProperty().addListener((ov, prev, image) -> {
            btnClear.setDisable(image == null);
        });

        tbl.getSelectionModel().selectedItemProperty().addListener((pv, ov, current) -> {
            btnPrintReport.setDisable(current == null);
            btnDelete.setDisable(current == null);

            if (current == null) {
                return;
            }

            txtId.setText(current.getId() + "");
            txtName.setText(current.getName());
            txtAddress.setText(current.getAddress());
            txtContact.setText(current.getContact());
            imgPicture.setImage(current.getPicture());

            generateBarcode(current.getDisplayId().replace("S-", ""));


        });

        txtSearch.textProperty().addListener(c->{
            loadStudent();

        });

    }

    private void loadStudent() {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM Student WHERE id LIKE ? OR name LIKE ? OR address LIKE ? OR contact LIKE ?");
            String query = "%" + txtSearch.getText() + "%";

            for (int i = 1; i < 5; i++) {
                preparedStatement.setString(i, query);
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<Student> studentList = tbl.getItems();
            studentList.clear();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String contact = resultSet.getString(4);
                byte[] picture = resultSet.getBytes(5);
                Image image = new Image(new ByteArrayInputStream(picture));

                Student student = new Student(id, name, address, contact, image);
                studentList.add(student);
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private BufferedImage generateBarcode(String id) {
        try {
            Barcode barcode = BarcodeFactory.createEAN13(id);
            barcode.setBarWidth(1);
            barcode.setResolution(100);
            barcode.setFont(new Font("ubuntu", Font.PLAIN, 10));

            BufferedImage image = BarcodeImageHandler.getImage(barcode);

            WritableImage fxImage = SwingFXUtils.toFXImage(image, null);
            imgBarcode.setFitHeight(70);
            imgBarcode.setImage(fxImage);

            return image;


        } catch (BarcodeException | OutputException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        txtId.clear();
        txtId.setText("Generated Id");
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        imgPicture.setImage(null);
        imgBarcode.setImage(null);
        tbl.getSelectionModel().clearSelection();
        txtSearch.clear();

    }

    @FXML
    void btnBrowsOnAction(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "Pictures"));
        fileChooser.setTitle("Select Profile Picture");


        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*jpeg", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(btnClear.getScene().getWindow());

        if (file == null) return;

        Image image = new Image(file.toURI().toURL().toString());
        imgPicture.setImage(image);

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        imgPicture.setImage(null);


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (!isDataValid()) return;

        Student student = new Student(null, txtName.getText(), txtAddress.getText(), txtContact.getText(), imgPicture.getImage());

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT *FROM Student WHERE contact=?");
            stm.setString(1, txtContact.getText());
            if (stm.executeQuery().next()) {
                txtContact.requestFocus();
                txtContact.selectAll();
                return;
            }

            PreparedStatement stmSave = connection.prepareStatement("INSERT INTO Student ( name, address, contact, picture) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            stmSave.setString(1, student.getName());
            stmSave.setString(2, student.getAddress());
            stmSave.setString(3, student.getContact());
            stmSave.setBytes(4, student.getPictureByte());

            stmSave.executeUpdate();
            ResultSet generatedKeys = stmSave.getGeneratedKeys();
            generatedKeys.next();

            int newStudentId = generatedKeys.getInt(1);
            System.out.println(newStudentId);
            student.setId(newStudentId);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        tbl.getItems().add(student);
        btnNew.fire();

    }


    private boolean isDataValid() {
        boolean dataValid = true;

        if (imgPicture.getImage() == null) {
            btnBrows.requestFocus();
            dataValid = false;
        }

        if (!txtContact.getText().matches("\\d{3}-\\d{7}")) {
            txtContact.selectAll();
            txtContact.requestFocus();
        }

        if (!txtAddress.getText().matches("[A-Za-z]{3,}")) {
            txtAddress.selectAll();
            txtAddress.requestFocus();
            dataValid = false;
        }

        if (!txtName.getText().matches("[A-Za-z]+")) {
            txtName.selectAll();
            txtName.requestFocus();
            dataValid = false;
        }
        return dataValid;

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        Student selectedStudent = tbl.getSelectionModel().getSelectedItem();
        ObservableList<Student> studentList = tbl.getItems();

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement stmDelete = connection.prepareStatement("DELETE FROM Student WHERE id=?");
            stmDelete.setInt(1, selectedStudent.getId());
            stmDelete.executeUpdate();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete student!").showAndWait();
            throw new RuntimeException(e);
        }


        studentList.remove(selectedStudent);
        if (studentList.isEmpty()) btnNew.fire();
    }

    @FXML
    void tblOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnDelete.fire();

    }

    @FXML
    void btnPrintReportOnAction(ActionEvent event) throws JRException {

        JasperDesign jasperDesign = JRXmlLoader.load(this.getClass().getResourceAsStream("/report/student-id-card.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        HashMap<String, Object> reportParam = new HashMap<>();
        Connection dataSource = DBConnection.getInstance().getConnection();

        Student selectedStudent = tbl.getSelectionModel().getSelectedItem();

        reportParam.put("id", selectedStudent.getId());
        reportParam.put("barcode", selectedStudent.getDisplayId().replace("S-", ""));

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParam, dataSource);
        JasperViewer.viewReport(jasperPrint);


    }

    @FXML
    void btnReportOnAction(ActionEvent event) {

    }

}

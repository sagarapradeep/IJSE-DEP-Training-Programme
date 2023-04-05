package lk.ijse.dep10.app.controller;

import com.mysql.cj.jdbc.Blob;
import javafx.application.Platform;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import lk.ijse.dep10.app.db.DBConnection;
import lk.ijse.dep10.app.model.Student;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.*;

public class StudentViewController {


    public Button btnNewStudent;
    @FXML
    private Button btnBrows;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private ImageView imgProfilePic;

    @FXML
    private TableView<Student> tblStudents;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    public void initialize() {
        Platform.runLater(btnNewStudent::fire);

        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        loadAllStudents();

        tblStudents.getSelectionModel().selectedItemProperty().addListener((pv, value, current) -> {
            if (current == null) return;
            btnDelete.setDisable(false);
            txtID.setText((current.getId() + ""));
            txtName.setText(current.getName());
            txtAddress.setText(current.getAddress());

            try {
                Image image = null;
                if (current.getPicture() == null) {
                    image = new Image("/img/No_Image_Available.jpg");
                } else {
                    image = new Image(current.getPicture().getBinaryStream());
                    btnClear.setDisable(false);

                }
                imgProfilePic.setImage(image);


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });

    }

    private void loadAllStudents() {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM ProfilePicture WHERE student_id=?");
            ResultSet resultSet = statement.executeQuery("SELECT *FROM Student");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                Blob picture = null;
                preparedStatement.setInt(1, id);
                ResultSet resultSet1 = preparedStatement.executeQuery();
                if (resultSet1.next()) {
                    picture = (Blob) resultSet1.getBlob(2);
                }

                Student student = new Student(id, name, address, picture);
                tblStudents.getItems().add(student);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load Students, Try again!").showAndWait();
            Platform.exit();
        }
    }

    @FXML
    void btnBrowsOnAction(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpeg", "*.jpg", "*.png", "*.gif", "*.bmp"));
        fileChooser.setTitle("Select the student picture");
        File file = fileChooser.showSaveDialog(btnBrows.getScene().getWindow());
        if (file != null) {
            imgProfilePic.setImage(new Image(file.toURI().toURL().toString()));
            btnClear.setDisable(false);
        } else {
            imgProfilePic.setImage(new Image("/img/No_Image_Available.jpg"));
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        imgProfilePic.setImage(new Image("/img/No_Image_Available.jpg"));

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Student selectedStudent = tblStudents.getSelectionModel().getSelectedItem();
        int id = selectedStudent.getId();


        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            String sqlPicture = "DELETE FROM ProfilePicture WHERE student_id=%s ";
            sqlPicture = String.format(sqlPicture, id);
            statement.executeUpdate(sqlPicture);

            String sqlStudent = "DELETE FROM Student WHERE id=%s ";
            sqlStudent = String.format(sqlStudent, id);
            statement.executeUpdate(sqlStudent);

            tblStudents.getItems().remove(selectedStudent);
            tblStudents.refresh();
            btnNewStudent.fire();




        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "failed to delete the student, try again").showAndWait();
        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


    }

    @FXML
    void btnSave(ActionEvent event) {
        if (!isDataValid()) return;

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.
                    prepareStatement("INSERT INTO Student (name, address) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, txtName.getText());
            stm.setString(2, txtAddress.getText());
            stm.executeUpdate();

            ResultSet generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            int id = generatedKeys.getInt(1);
            Student newStudent = new Student(id,
                    txtName.getText(), txtAddress.getText(), null);

            if (!btnClear.isDisable()) {
                PreparedStatement stm2 = connection.prepareStatement
                        ("INSERT INTO ProfilePicture (student_id, picture) VALUES (?, ?)");
                stm2.setInt(1, id);
                // javafx.image => byte[] <-> Blob
                Image image = imgProfilePic.getImage();    // I have a javafx.image here

                /* 1. Convert JavaFX Image to a BufferedImage */
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);

                /* 2. Create a BAOS to store bytes of the BufferedImage */
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                /* 3. Let's store all the bytes of the BufferedImage in the BAOS */
                ImageIO.write(bufferedImage, "png", bos);

                byte[] bytes = bos.toByteArray();

                java.sql.Blob picture = new SerialBlob(bytes);

                stm2.setBlob(2, picture);
                stm2.executeUpdate();
                newStudent.setPicture(picture);




            }
            connection.commit();
            tblStudents.getItems().add(newStudent);
            btnNewStudent.fire();
        } catch (Throwable e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to save the student").show();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isDataValid() {
        boolean dataValid = true;
        if (!txtAddress.getText().matches("[A-Za-z]{5,}")) {
            txtAddress.requestFocus();
            txtAddress.selectAll();
            dataValid = false;
        }

        if (!txtName.getText().matches("[A-Za-z]{3,}")) {
            txtName.requestFocus();
            txtName.selectAll();
            dataValid = false;
        }


        return dataValid;
    }

    @FXML
    void tblStudentsOnKeyReleased(KeyEvent event) {

    }

    public void btnNewStudentOnAction(ActionEvent actionEvent) {
        txtID.setText("Generated Id");
        txtName.clear();
        txtAddress.clear();
        btnClear.fire();
        btnClear.setDisable(true);
        btnDelete.setDisable(true);
        tblStudents.getSelectionModel().clearSelection();
        txtName.requestFocus();

    }
}

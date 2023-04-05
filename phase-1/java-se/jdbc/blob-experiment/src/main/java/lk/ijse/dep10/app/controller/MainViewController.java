package lk.ijse.dep10.app.controller;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import lk.ijse.dep10.app.db.DBConnection;
import lk.ijse.dep10.app.util.Item;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.sql.*;

public class MainViewController {

    @FXML
    private Button btnBrows;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewItem;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ImageView imgPreview;

    @FXML
    private TableView<Item> tblItems;

    @FXML
    private TextField txtBPrice;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtItemDescription;

    @FXML
    private TextField txtProfit;

    @FXML
    private TextField txtSPrice;

    @FXML
    private TextField txtStock;

    public void initialize() {

        Platform.runLater(btnNewItem::fire);

        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        tblItems.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("profit"));
        tblItems.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("stock"));

        loadAllData();

        tblItems.getSelectionModel().selectedItemProperty().addListener((pv,value,current)->{
            if(current==null) return;
            txtItemCode.setText(current.getItemCode() + "");
            txtItemDescription.setText(current.getDescription());
            txtBPrice.setText(current.getBuyingPrice() + "");
            txtSPrice.setText(current.getSellingPrice() + "");
            txtStock.setText(current.getStock() + "");
            txtProfit.setText(current.getProfit() + "");

            Image image = null;
            if (current.getPreview() == null) {
                image = new Image("/img/No_Image_Available.jpg");
            } else {
                try {
                    image = new Image(current.getPreview().getBinaryStream());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                btnRemove.setDisable(false);
            }
            imgPreview.setImage(image);
            btnDelete.setDisable(false);

        });




    }

    private void loadAllData() {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement stm = connection.createStatement();
            String sql = "SELECT *FROM Items";
            ResultSet resultSet = stm.executeQuery(sql);

            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT *FROM Preview WHERE item_code=?");

            while (resultSet.next()) {
                int itemCode = resultSet.getInt(1);
                String description = resultSet.getString(2);
                BigDecimal buyingPrice = resultSet.getBigDecimal(3);
                BigDecimal sellingPrice = resultSet.getBigDecimal(4);
                int stock = resultSet.getInt(5);


                preparedStatement.setInt(1, itemCode);
                ResultSet resultSet1 = preparedStatement.executeQuery();
                Blob preview = null;

                if (resultSet1.next()) {
                    preview = resultSet1.getBlob(2);

                }
                BigDecimal profit = sellingPrice.subtract(buyingPrice).multiply(BigDecimal.valueOf(stock));
                Item item = new Item(itemCode, description, buyingPrice, sellingPrice, profit, stock, preview);
                tblItems.getItems().add(item);


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnBrowsOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpeg", "*.jpg", "*.png", "*.gif", "*.bmp"));
        File file = fileChooser.showOpenDialog(btnBrows.getScene().getWindow());

        if (file != null) {
            try {
                imgPreview.setImage(new Image(file.toURI().toURL().toString()));
                btnRemove.setDisable(false);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }else {
            imgPreview.setImage(new Image("/img/No_Image_Available.jpg"));
        }

    }

    @FXML
    void btnDeleteOnACtion(ActionEvent event) {
        if(tblItems.getSelectionModel().getSelectedItem()==null) return;
        Item selectedItem = tblItems.getSelectionModel().getSelectedItem();

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            if (selectedItem.getPreview() != null) {
                String sql = "DELETE FROM Preview WHERE item_code=%s";
                sql = String.format(sql, selectedItem.getItemCode());
                statement.executeUpdate(sql);

            }

            String sql = "DELETE FROM Items WHERE code=%s ";
            sql = String.format(sql, selectedItem.getItemCode());
            statement.executeUpdate(sql);

            tblItems.getItems().remove(selectedItem);
            tblItems.refresh();
            btnNewItem.fire();



        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @FXML
    void btnNewItemOnAction(ActionEvent event) {
        txtItemCode.setText("Generated Id");
        txtItemDescription.clear();
        txtBPrice.clear();
        txtSPrice.clear();
        txtStock.clear();
        txtProfit.clear();
        imgPreview.setImage(new Image("/img/No_Image_Available.jpg"));
        tblItems.getSelectionModel().clearSelection();
        txtItemDescription.requestFocus();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        if(imgPreview.getImage()==null)return;
        imgPreview.setImage(new Image("/img/No_Image_Available.jpg"));
        btnRemove.setDisable(true);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if(!isDataValid()) return;

        String description = txtItemDescription.getText();

        BigDecimal sBPrice = new BigDecimal(txtBPrice.getText());
        BigDecimal bPrice = sBPrice;

        BigDecimal sSPrice = new BigDecimal(txtSPrice.getText());
        BigDecimal sPrice = sSPrice;

        int stock = Integer.parseInt(txtStock.getText());

        BigDecimal profit = (sPrice.subtract(bPrice)).multiply(BigDecimal.valueOf(stock));
        txtProfit.setText(profit.toString());




        Connection connection = DBConnection.getInstance().getConnection();
        try {


            PreparedStatement stmItem = connection.prepareStatement
                    ("INSERT INTO Items(description, buying_price, selling_price, stock) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            connection.setAutoCommit(false);

            stmItem.setString(1, description);
            stmItem.setBigDecimal(2, bPrice);
            stmItem.setBigDecimal(3, sPrice);
            stmItem.setInt(4, stock);

            stmItem.executeUpdate();

            ResultSet generatedKeys = stmItem.getGeneratedKeys();
            System.out.println("item code");
            generatedKeys.next();
            int code = generatedKeys.getInt(1);

            Item newItem = new Item(code, description, bPrice, sBPrice, profit, stock, null);


            if (!btnRemove.isDisable()) {
                PreparedStatement stm2 = connection.prepareStatement
                        ("INSERT INTO Preview(item_code, preview) VALUES (?, ?)");
                stm2.setInt(1, code);
                // javafx.image => byte[] <-> Blob
                Image image = imgPreview.getImage();    // I have a javafx.image here

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
                newItem.setPreview(picture);



            }
            System.out.println(newItem);
            tblItems.getItems().add(newItem);
            btnNewItem.fire();

        } catch (Throwable throwable) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }






    }

    private boolean isDataValid() {
        boolean dataValid = true;

        if (!txtStock.getText().matches("\\d+")) {
            txtStock.requestFocus();
            txtStock.selectAll();
            dataValid = false;
        }
        if ((!txtSPrice.getText().matches("\\d+([.]?\\d+)?"))) {
            txtSPrice.selectAll();
            txtSPrice.requestFocus();
            dataValid = false;
        }

        if (!txtBPrice.getText().matches("\\d+([.]?\\d+)?")) {
            txtBPrice.selectAll();
            txtBPrice.requestFocus();
            dataValid = false;
        }

        if (!txtItemDescription.getText().matches("[A-Za-z]{3,}")) {
            dataValid = false;
            txtItemDescription.requestFocus();
            txtItemDescription.selectAll();
        }


        return dataValid;
    }

}

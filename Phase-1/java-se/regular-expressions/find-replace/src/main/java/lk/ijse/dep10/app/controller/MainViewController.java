package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.dep10.app.controller.util.SearchResult;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainViewController {

    public TextArea txtEditor;
    public CheckBox chkMatchCase;
    @FXML
    private Button btnDown;

    @FXML
    private Button btnReplaceAll;

    @FXML
    private Button btnReplace;

    @FXML
    private Button btnUp;


    @FXML
    private Label lblNumOfSelection;

    @FXML
    private TextField txtFind;

    @FXML
    private TextField txtReplace;


    private ArrayList<SearchResult> searchResults = new ArrayList<>();
    private int pos = 0;

    public void initialize() {

        txtFind.requestFocus();
        txtFind.textProperty().addListener((value,previous,current)->{

            findResultCount();


        });

        txtEditor.textProperty().addListener((value,previous,current)->{
            findResultCount();

        });
    }

    private void findResultCount() {

        searchResults.clear();
        pos = 0;

        Pattern pattern = Pattern.compile(txtFind.getText());
        Matcher matcher = pattern.matcher(txtEditor.getText());

        while (matcher.find()) {
            System.out.println("While");
            int start = matcher.start();
            int end = matcher.end();
            SearchResult result = new SearchResult(start, end);
            searchResults.add(result);
        }
        System.out.println(searchResults.size());
        lblNumOfSelection.setText("Result: " + searchResults.size());

        select();



    }

    private void select() {
        if(searchResults.isEmpty()) return;
        SearchResult searchResult = searchResults.get(pos);
        txtEditor.selectRange(searchResult.getStart(), searchResult.getEnd());
        lblNumOfSelection.setText("Result: " + pos + 1);
    }

    @FXML
    void btnDownOnAction(ActionEvent event) {
        ++pos;
        if (pos == searchResults.size()) {
            pos = -1;
            return;
        }
        select();



    }

    @FXML
    void btnReplaceAllOnAction(ActionEvent event) {

    }

    @FXML
    void btnReplaceOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpOnAction(ActionEvent event) {
        --pos;
        if (pos < 0) {
            pos = searchResults.size();
            return;
        }
        select();


    }

    public void chkMatchCaseOnAction(ActionEvent actionEvent) {
    }
}

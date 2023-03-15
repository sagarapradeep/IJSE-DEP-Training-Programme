package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.dep10.app.controller.util.SearchResult;

import java.sql.SQLOutput;
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
        chkMatchCase.setSelected(true);
        txtFind.requestFocus();
        txtFind.textProperty().addListener((value,previous,current)->{
            if (txtFind.getText().isEmpty()||txtFind.getText().isBlank()) {
                lblNumOfSelection.setText("Result: 0");

                return;
            }
            lblNumOfSelection.setText("Result: 0");
            findResultCount();


        });

        txtEditor.textProperty().addListener((value,previous,current)->{
            findResultCount();

        });
    }

    private void findResultCount() {

        searchResults.clear();
        pos = 0;

        Pattern pattern;
        if (!chkMatchCase.isSelected()) {
            pattern = Pattern.compile(txtFind.getText(), Pattern.CASE_INSENSITIVE);
        }
        else {
            pattern = Pattern.compile(txtFind.getText());

        }
        Matcher matcher = pattern.matcher(txtEditor.getText());


        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            SearchResult result = new SearchResult(start, end);
            searchResults.add(result);
        }

        lblNumOfSelection.setText("Result: " + searchResults.size());



    }

    private void select() {
        if(searchResults.isEmpty()) return;
        SearchResult searchResult = searchResults.get(pos-1);
        txtEditor.selectRange(searchResult.getStart(), searchResult.getEnd());
        lblNumOfSelection.setText("Result: " + (pos));
    }

    @FXML
    void btnDownOnAction(ActionEvent event) {
        ++pos;
        if (pos == searchResults.size()+1) {
            pos = -1;
            return;
        }
        if(pos==0) ++pos;
        select();



    }
    @FXML
    void btnUpOnAction(ActionEvent event) {

        --pos;
        System.out.println(pos);
        if (pos <= 0) {
            pos = searchResults.size()+1;
            return;
        }
        select();


    }

    @FXML
    void btnReplaceAllOnAction(ActionEvent event) {

        if(txtReplace.getText().isEmpty()) return;

        String replaceAllText = txtEditor.getText();
        replaceAllText = replaceAllText.replaceAll(txtFind.getText(), txtReplace.getText());
        txtEditor.setText(replaceAllText);

    }

    @FXML
    void btnReplaceOnAction(ActionEvent event) {
        if(txtReplace.getText().isEmpty()) return;
        String replacedText = txtEditor.getText();
        replacedText = replacedText.replaceFirst(txtFind.getText(), txtReplace.getText());

        txtEditor.setText(replacedText);

    }

    @FXML


    public void chkMatchCaseOnAction(ActionEvent actionEvent) {
        System.out.println(chkMatchCase.isSelected());

    }
}

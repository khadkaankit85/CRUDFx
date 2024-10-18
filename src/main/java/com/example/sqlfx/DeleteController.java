package com.example.sqlfx;

import com.example.DAO.DAO;
import com.example.model.University;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class DeleteController {

    public TextField idField;
    public Label deletePageLabel;
    HelloController sceneSwitcher;

    @FXML
    private TableView<University> myTable;
    @FXML
    private TableColumn<University, Integer> idCol;
    @FXML
    private TableColumn<University, String> nameCol;
    @FXML
    private TableColumn<University, Integer> rankCol;
    @FXML
    private TableColumn<University, String> locationCol;



    public  DeleteController(){
         this.sceneSwitcher=new HelloController();
    }

    public void onCreate(ActionEvent actionEvent) {
sceneSwitcher.changeSceneToAnother("hello-view.fxml",deletePageLabel);
    }

    public void onUpdate(ActionEvent actionEvent) {
        sceneSwitcher.changeSceneToAnother("update-view.fxml",deletePageLabel);
    }

    public void onRead() throws SQLException {
        sceneSwitcher.fillTable(myTable,idCol,nameCol,rankCol,locationCol);

    }

    public void onDelete(ActionEvent actionEvent) throws SQLException {
        int Id= parseInt(idField.getText());

        DAO conn =new DAO();
        conn.deleteUniversity(Id);
        conn.closeConnection();

//        refresh the table
        onRead();

    }
}

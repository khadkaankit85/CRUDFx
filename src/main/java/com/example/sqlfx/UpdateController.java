package com.example.sqlfx;

import com.example.DAO.DAO;
import com.example.model.University;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class UpdateController {


    public Label updatePageLabel;
    HelloController sceneSwitcher;
    @FXML
    private Label crudPageLabel;

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

    public TextField nameField;
    public TextField rankField;
    public TextField locationField;
    public TextField idField;


    public UpdateController(){
        this.sceneSwitcher=new HelloController();
    }

    public void onCreate(ActionEvent actionEvent) {
        sceneSwitcher.changeSceneToAnother("update-view.fxml",updatePageLabel);
    }

    public void onUpdate(ActionEvent actionEvent) throws SQLException {
        String name=nameField.getText();
        String rank=rankField.getText();
        String location=locationField.getText();
        int Id;
      try {
           Id= parseInt(idField.getText());
      }
      catch (Exception e){
          System.out.println("Not a num so id is now 100");
          Id=100;
      }

        University myUni=new University(Id,name,parseInt(rank),location);

       DAO conn =new DAO();

       conn.updateUniversity(myUni);
       conn.closeConnection();

//       to reload the page
onRead();


    }

    public void onRead() throws SQLException {
       sceneSwitcher.fillTable(myTable,idCol,nameCol,rankCol,locationCol);
    }

    public void onDelete(ActionEvent actionEvent) {
        sceneSwitcher.changeSceneToAnother("delete-view.fxml",updatePageLabel);
    }
}

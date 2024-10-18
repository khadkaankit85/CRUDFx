package com.example.sqlfx;

import com.example.model.University;
import com.example.DAO.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class HelloController {

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

//    input fields


    public void  onRead() throws SQLException {
        fillTable(myTable,idCol,nameCol,rankCol,locationCol);
    }

    public void fillTable( TableView<University> myTable,TableColumn<University, Integer> idCol,
     TableColumn<University, String> nameCol, TableColumn<University, Integer> rankCol,
     TableColumn<University, String> locationCol) throws SQLException {
        // Set cell value factories
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        rankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        ObservableList<University> universityList = FXCollections.observableArrayList();

        DAO dao = new DAO();
        try {
            ResultSet resultSet = dao.readUniversities();

            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int rank = resultSet.getInt("rank");
                String location = resultSet.getString("location");

                // Create a University object and add it to the list
                University university = new University(id,name, rank, location);
                universityList.add(university);
            }
            // Set the items in the TableView
            myTable.setItems(universityList);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }



    public void changeSceneToAnother(String fxmlName) {
        try {
            Parent secondScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlName)));
            Stage secondStage = new Stage();
            secondStage.setTitle("Haha");
            secondStage.setScene(new Scene(secondScene));
            secondStage.setFullScreen(true);


            secondStage.show();
        } catch (IOException e) {
            System.out.println("Error loading scene: " + e.getMessage());
        }
    }

    public void onCreate() {
        changeSceneToAnother("update-view.fxml");
    }

    public void onUpdate() {
        changeSceneToAnother("update-view.fxml");
    }

    public void onDelete() {
        changeSceneToAnother("delete-view.fxml");
    }
}

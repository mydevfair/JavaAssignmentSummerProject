package CraftyCake.java.View;

import CraftyCake.java.Assets.Utils;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import CraftyCake.java.Model.Employee;
import CraftyCake.java.Controller.Team;

import java.io.IOException;
import java.sql.SQLException;

public class AllEmployeesScreenController {
    private final Stage thisStage;

    private Team team;

    @FXML
    private TableView<Employee> tblEmployees;

    private Utils utils = new Utils();

    public AllEmployeesScreenController () throws SQLException{
        thisStage = new Stage();
        this.team = new Team();

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AllEmployeesScreen.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("All Employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showStage(){
        thisStage.show();
    }
    @FXML
    private void initialize() {

        TableColumn<Employee, String> colName = new TableColumn<>("Name");
        colName.setMinWidth(200);
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, Double> colCakes = new TableColumn<>("Cakes Covered");
        colCakes.setMinWidth(200);
        colCakes.setCellValueFactory(new PropertyValueFactory<>("cakesCovered"));



        this.tblEmployees.setItems(team.getTeamAsOAL());
        this.tblEmployees.getColumns().addAll(colName, colCakes);

    }
}

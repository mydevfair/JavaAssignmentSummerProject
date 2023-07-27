package CraftyCake.java.View;

import CraftyCake.java.Assets.Utils;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import CraftyCake.java.Model.Employee;
import CraftyCake.java.Controller.Team;


import java.io.IOException;
import java.sql.SQLException;

public class AllEmployeesScreenController {
    private final Stage thisStage;

    private Team team;

    @FXML
    private TableView<Employee> tblEmployees;

    @FXML
    Label lblTotalCakesCovered, lblTotalWages;


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
        colCakes.setCellValueFactory(new PropertyValueFactory<>("cakesMade"));

        TableColumn<Employee, String> colWages = new TableColumn<>("Wages");
        colWages.setMinWidth(200);
        colWages.setCellValueFactory(
                cellData -> {
                    Employee employee = cellData.getValue();
                    return new SimpleStringProperty(Utils.getMoney(employee.getWage()));

        });

        TableColumn<Employee, String> colAddCakes = new TableColumn<>("+ Cakes");
        colAddCakes.setMinWidth(100);
        colAddCakes.setCellFactory(TextFieldTableCell.forTableColumn());
        colAddCakes.setOnEditCommit(
                event-> {
                    try {
                        Employee employee = getSelectedEmployeeFromTable(event);
                        //update that employee using the addCakes method with the new value
                        employee.addCakesMade(Integer.parseInt(event.getNewValue()));
                        //reflect the changes in the GUI
                        team.updateEmployee(employee);
                        tblEmployees.refresh();
                    } catch (Exception e) {
                        utils.drawAlert(e.getMessage(), "ERROR!!!!", Alert.AlertType.WARNING);
                    }
                }
        );

        TableColumn<Employee, String> colMinusCakes = new TableColumn<>("- Cakes");
        colMinusCakes.setMinWidth(100);
        colMinusCakes.setCellFactory(TextFieldTableCell.forTableColumn());
        colMinusCakes.setOnEditCommit(
                event-> {
                    try {
                        //get the value entered into text field
                        String value = String.valueOf(event.getNewValue());
                        //convert the entered text ti an int
                        Integer v = Integer.parseInt(value);
                        Employee employee = getSelectedEmployeeFromTable(event);
                        //update that employee using the addCakes method with the new value
                        System.out.println(employee.getCakesMade());
                        employee.setErrorCakes(v);
                        team.updateEmployee(employee);
                        //reflect the changes in the GUI
                        tblEmployees.refresh();
                    } catch (Exception e) {
                        utils.drawAlert(e.getMessage(), "ERROR!!!!", Alert.AlertType.WARNING);
                    }
                }
        );

        this.tblEmployees.setEditable(true);

        this.tblEmployees.setItems(team.getTeamAsOAL());
        this.tblEmployees.getColumns().addAll(colName, colCakes, colWages, colAddCakes, colMinusCakes);

        this.lblTotalCakesCovered.setText(String.valueOf(team.getTeamTotalCakes()));
        this.lblTotalWages.setText(String.valueOf(Utils.getMoney(team.getTeamTotalWages())));

    }
    public Employee getSelectedEmployeeFromTable(TableColumn.CellEditEvent event){
        //get the employee from the current row selected
        int selectedRow = event.getTablePosition().getRow();
        Employee employee = (Employee) event.getTableView().getItems().get(selectedRow);
        return employee;
    }
}

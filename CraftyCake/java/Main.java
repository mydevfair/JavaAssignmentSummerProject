package CraftyCake.java;

import CraftyCake.java.Assets.Utils;
import CraftyCake.java.Controller.Team;
import CraftyCake.java.View.AllEmployeesScreenController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    //stage comes from the Application interface
    public void start(Stage stage) throws Exception {
        // Create the first controller, which loads AllEmployeesScreen.fxml within its own constructor
        AllEmployeesScreenController allEmployeesScreenController = new AllEmployeesScreenController();
        // Show the new stage
        allEmployeesScreenController.showStage();
    }
}

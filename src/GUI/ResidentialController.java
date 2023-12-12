package GUI;

import Data.ProjectModelManager;
import Model.ResidentialProject;
import Model.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ResidentialController
{
    @FXML private Button save;

    // Form states
    @FXML private TextField name;
    @FXML private ChoiceBox status;
    @FXML private TextField size;
    @FXML private TextField timeline;
    @FXML private TextField budget;
    @FXML private TextField materialExpenses;
    @FXML private TextField numberOfRooms;
    @FXML private TextField numberOfBathrooms;
    @FXML private TextField numberOfKitchens;
    @FXML private TextField roomsWithPlumbing;
    @FXML private TextField manHoursUsed;
    @FXML private TextField expectedTotalHours;
    @FXML private TextField expenses;

    private TabPane tabPane;
    private ProjectModelManager projectModelManager;

    public void init(ProjectModelManager projectModelManager, TabPane tabPane)
    {
        this.projectModelManager = projectModelManager;
        this.tabPane = tabPane;
    }

    public void submitHandler(ActionEvent event) throws IOException {
        if (event.getSource() == save)
        {
            submitForm();
        }

        tabPane.getSelectionModel().select(0); // The index tab
    }

    public void submitForm()
    {
        var name = this.name.getText();
        var status = this.status.getValue() == null ? "Ongoing" : this.status.getValue().toString();
        var size = Double.parseDouble(this.size.getText());
        var timeline = Integer.parseInt(this.timeline.getText());
        var budget = Double.parseDouble(this.budget.getText());
        var materialExpenses = Double.parseDouble(this.materialExpenses.getText());
        var numberOfRooms = Integer.parseInt(this.numberOfRooms.getText());
        var numberOfBathrooms = Integer.parseInt(this.numberOfBathrooms.getText());
        var numberOfKitchens = Integer.parseInt(this.numberOfKitchens.getText());
        var roomsWithPlumbing = Integer.parseInt(this.roomsWithPlumbing.getText());
        var manHoursUsed = Double.parseDouble(this.manHoursUsed.getText());
        var expectedTotalHours = Double.parseDouble(this.expectedTotalHours.getText());
        var expenses = Double.parseDouble(this.expenses.getText());

        var newProject = new ResidentialProject(
                timeline,
                budget,
                name,
            new Resource(
                materialExpenses,
                manHoursUsed,
                expectedTotalHours,
                expenses
            ),
                status,
                projectModelManager.getAllProjects().getProjects().size(),
                size,
                numberOfRooms,
                numberOfKitchens,
                numberOfBathrooms,
                roomsWithPlumbing
        );

        var currentProjects = projectModelManager.getAllProjects();
        currentProjects.addProject(newProject);
        projectModelManager.saveProjects(currentProjects);

        // Showing that the form was submitted successfully
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation");
        a.setContentText("The project has been saved!");
        a.showAndWait();
        resetValues();
    }

    public void resetValues()
    {
        name.setText("");
        status.setValue("Ongoing");
        timeline.setText("");
        size.setText("");
        budget.setText("");
        materialExpenses.setText("");
        numberOfRooms.setText("");
        numberOfBathrooms.setText("");
        numberOfKitchens.setText("");
        roomsWithPlumbing.setText("");
        manHoursUsed.setText("");
        expectedTotalHours.setText("");
        expenses.setText("");
    }
}

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

/**
 * The class that is used to manage actions in the residential tab
 * @author Group 2
 * @version 1.0
 */
public class ResidentialController
{
    @FXML private Button save;

    private int id;

    // Form states
    @FXML private TextField name;
    @FXML private ChoiceBox status;
    @FXML private TextField size;
    @FXML private TextField timeline;
    @FXML private TextField budget;
    @FXML private TextField materialExpenses;
    @FXML private TextField numberOfFloors;
    @FXML private TextField numberOfBathrooms;
    @FXML private TextField numberOfKitchens;
    @FXML private TextField roomsWithPlumbing;
    @FXML private TextField manHoursUsed;
    @FXML private TextField expectedTotalHours;
    @FXML private TextField expenses;

    private TabPane tabPane;
    private ProjectModelManager projectModelManager;
    private boolean isEdit;

    /**
     * Initializer of the tab
     * @param projectModelManager the project model manager
     * @param tabPane the tab
     */
    public void init(ProjectModelManager projectModelManager, TabPane tabPane)
    {
        this.projectModelManager = projectModelManager;
        this.tabPane = tabPane;
    }

    /**
     * The method used to handle the save button
     * @param event the event the method will act upon ("save")
     */
    public void submitHandler(ActionEvent event) throws IOException {
        if (event.getSource() == save)
        {
            try {
                submitForm();
            } catch (Exception e) {
                // The error from the controller is shown and we catch it here so we don't block the app
                // We don't return because the user is not done with the form
                return;
            }
        }

        tabPane.getSelectionModel().select(0); // The index tab
    }

    /**
     * Method used to submit the data user inputs and check it
     */
    public void submitForm()
    {
        var name = this.name.getText();
        var status = this.status.getValue() == null ? "Ongoing" : this.status.getValue().toString();
        var size = Double.parseDouble(this.size.getText());
        var timeline = Integer.parseInt(this.timeline.getText());
        var budget = Double.parseDouble(this.budget.getText());
        var materialExpenses = Double.parseDouble(this.materialExpenses.getText());
        var numberOfFloors = Integer.parseInt(this.numberOfFloors.getText());
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
            id != -1 ? id : projectModelManager.getAllProjects().getProjects().size(),
                size,
                numberOfFloors,
                numberOfKitchens,
                numberOfBathrooms,
                roomsWithPlumbing
        );

        var isEdit = this.id != -1;
        if (isEdit) {
            projectModelManager.updateProject(newProject);
        } else {
            var currentProjects = projectModelManager.getAllProjects();
            currentProjects.addProject(newProject);
            projectModelManager.saveProjects(currentProjects);
        }

        // Showing that the form was submitted successfully
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation");
        a.setContentText("The project has been saved!");
        a.showAndWait();
        resetValues();
    }

    /**
     * Method use to reset to base values
     */
    public void resetValues()
    {
        this.id = -1;
        name.setText("");
        status.setValue("Ongoing");
        timeline.setText("");
        size.setText("");
        budget.setText("");
        materialExpenses.setText("");
        numberOfFloors.setText("");
        numberOfBathrooms.setText("");
        numberOfKitchens.setText("");
        roomsWithPlumbing.setText("");
        manHoursUsed.setText("");
        expectedTotalHours.setText("");
        expenses.setText("");
    }

    /**
     * Method used to edit the data of a project specified by id
     * @param id the id of the desired project
     */
    public void edit(int id) {
        var project = (ResidentialProject)projectModelManager.getById(id);

        if (project == null) {
            return;
        }

        this.id = id;
        name.setText(project.getName());
        status.setValue(project.getStatus());
        size.setText(String.valueOf(project.getSize()));
        timeline.setText(String.valueOf(project.getTimeline()));
        budget.setText(String.valueOf(project.getBudget()));
        materialExpenses.setText(String.valueOf(project.getMaterialExpenses()));
        numberOfFloors.setText(String.valueOf(project.getNumberOfFloors()));
        numberOfBathrooms.setText(String.valueOf(project.getNumberOfBathrooms()));
        numberOfKitchens.setText(String.valueOf(project.getNumberOfKitchens()));
        roomsWithPlumbing.setText(String.valueOf(project.getRoomsWithPlumbing()));
        manHoursUsed.setText(String.valueOf(project.getManHours()));
        expectedTotalHours.setText(String.valueOf(project.getExpectedTotalHours()));
        expenses.setText(String.valueOf(project.getExpenses()));
    }
}

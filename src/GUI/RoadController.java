package GUI;

import Data.ProjectModelManager;
import Model.Resource;
import Model.RoadProject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RoadController
{
    @FXML private Button save;

    private int id;

    // Form states
    @FXML private TextField name;
    @FXML private ChoiceBox status;
    @FXML private TextField length;
    @FXML private TextField width;
    @FXML private TextField timeline;
    @FXML private TextField budget;
    @FXML private TextField materialExpenses;
    @FXML private TextField manHoursUsed;
    @FXML private TextField expectedTotalHours;
    @FXML private TextField expenses;
    @FXML private TextField numberOfBridges;
    @FXML private TextField environmentalChallenges;

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

    public void submitForm()
    {
        var timeline = Integer.parseInt(this.timeline.getText());
        var budget = Double.parseDouble(this.budget.getText());
        var name = this.name.getText();
        var status = this.status.getValue() == null ? "Ongoing" : this.status.getValue().toString();
        var length = Double.parseDouble(this.length.getText());
        var width = Double.parseDouble(this.width.getText());
        var numberOfBridges = Integer.parseInt(this.numberOfBridges.getText());
        var environmentalChallenges = Integer.parseInt(this.environmentalChallenges.getText());
        var materialExpenses = Double.parseDouble(this.materialExpenses.getText());
        var manHoursUsed = Double.parseDouble(this.manHoursUsed.getText());
        var expectedTotalHours = Double.parseDouble(this.expectedTotalHours.getText());
        var expenses = Double.parseDouble(this.expenses.getText());

        var newProject = new RoadProject(
            timeline,
            budget,
            name,
            status,
            new Resource(materialExpenses, manHoursUsed, expectedTotalHours, expenses),
            id != -1 ? id : projectModelManager.getAllProjects().getProjects().size(),
            length,
            width,
            numberOfBridges,
            environmentalChallenges
        );

        var isEdit = id != -1;
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

    public void resetValues()
    {
        id = -1;
        name.setText("");
        status.setValue(null);
        length.setText("");
        width.setText("");
        timeline.setText("");
        budget.setText("");
        materialExpenses.setText("");
        manHoursUsed.setText("");
        expectedTotalHours.setText("");
        expenses.setText("");
        numberOfBridges.setText("");
        environmentalChallenges.setText("");
    }

    public void edit(int id)
    {
        var project = (RoadProject) projectModelManager.getById(id);
        if (project == null)
        {
            return;
        }

        this.id = id;
        name.setText(project.getName());
        status.setValue(project.getStatus());
        length.setText(String.valueOf(project.getLength()));
        width.setText(String.valueOf(project.getWidth()));
        timeline.setText(String.valueOf(project.getTimeline()));
        budget.setText(String.valueOf(project.getBudget()));
        materialExpenses.setText(String.valueOf(project.getMaterialExpenses()));
        manHoursUsed.setText(String.valueOf(project.getManHours()));
        expectedTotalHours.setText(String.valueOf(project.getExpectedTotalHours()));
        expenses.setText(String.valueOf(project.getExpenses()));
        numberOfBridges.setText(String.valueOf(project.getNumberOfBridges()));
        environmentalChallenges.setText(String.valueOf(project.getEnvironmentalChallenges()));
    }
}

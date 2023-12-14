package GUI;

import Data.ProjectModelManager;
import Model.CommercialProject;
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

public class CommercialController
{
    @FXML
    private Button save;

    private int id;

    // Form states
    @FXML private TextField name;
    @FXML private ChoiceBox status;
    @FXML private TextField intendedUse;
    @FXML private TextField materialExpenses;
    @FXML private TextField manHoursUsed;
    @FXML private TextField expectedTotalHours;
    @FXML private TextField expenses;
    @FXML private TextField numberOfFloors;
    @FXML private TextField timeline;
    @FXML private TextField budget;
    @FXML private TextField size;

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
        var name = this.name.getText();
        var status = this.status.getValue() == null ? "Ongoing" : this.status.getValue().toString();
        var size = this.size.getText();
        var timeline = this.timeline.getText();
        var budget = this.budget.getText();
        var intendedUse = this.intendedUse.getText();
        var materialExpenses = this.materialExpenses.getText();
        var manHoursUsed = this.manHoursUsed.getText();
        var expectedTotalHours = this.expectedTotalHours.getText();
        var expenses = this.expenses.getText();
        var numberOfFloors = this.numberOfFloors.getText();
        
        var newProject = new CommercialProject(
            Integer.parseInt(timeline),
            Double.parseDouble(budget),
            name,
            status,
            new Resource(
                Double.parseDouble(materialExpenses),
                Double.parseDouble(manHoursUsed),
                Double.parseDouble(expectedTotalHours),
                Double.parseDouble(expenses)),
            id != -1 ? id : projectModelManager.getAllProjects().getProjects().size(),
            Double.parseDouble(size),
            Integer.parseInt(numberOfFloors),
            intendedUse
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

    public void resetValues()
    {
        this.id = -1;
        name.setText("");
        status.setValue("Ongoing");
        size.setText("");
        timeline.setText("");
        budget.setText("");
        intendedUse.setText("");
        materialExpenses.setText("");
        manHoursUsed.setText("");
        expectedTotalHours.setText("");
        expenses.setText("");
        numberOfFloors.setText("");
    }

    public void edit(int id) {
        var project = (CommercialProject)projectModelManager.getById(id);

        if (project == null) {
            return;
        }

        this.id = id;
        name.setText(project.getName());
        status.setValue(project.getStatus());
        size.setText(String.valueOf(project.getSize()));
        timeline.setText(String.valueOf(project.getTimeline()));
        budget.setText(String.valueOf(project.getBudget()));
        intendedUse.setText(project.getIntendedUse());
        materialExpenses.setText(String.valueOf(project.getMaterialExpenses()));
        manHoursUsed.setText(String.valueOf(project.getManHours()));
        expectedTotalHours.setText(String.valueOf(project.getExpectedTotalHours()));
        expenses.setText(String.valueOf(project.getExpenses()));
        numberOfFloors.setText(String.valueOf(project.getNumberOfFloors()));
    }
}

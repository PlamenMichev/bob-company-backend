package GUI;

import Data.ProjectModelManager;
import Model.CommercialProject;
import Model.IndustrialProject;
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

public class IndustrialController
{
    @FXML private Button save;

    private int id;

    @FXML private TextField name;
    @FXML private ChoiceBox status;
    @FXML private TextField timeline;
    @FXML private TextField size;
    @FXML private TextField budget;
    @FXML private TextField buildingType;
    @FXML private TextField materialExpenses;
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
        var size = Integer.parseInt(this.size.getText());
        var timeline = Integer.parseInt(this.timeline.getText());
        var budget = Double.parseDouble(this.budget.getText());
        var materialExpenses = Double.parseDouble(this.materialExpenses.getText());
        var manHoursUsed = Double.parseDouble(this.manHoursUsed.getText());
        var expectedTotalHours = Double.parseDouble(this.expectedTotalHours.getText());
        var expenses = Double.parseDouble(this.expenses.getText());
        var buildingType = this.buildingType.getText();

        var isEdit = this.id != -1;
        if (!isEdit) {
            this.id = projectModelManager.getAllProjects().getProjects().size();
        }

        var newProject = new IndustrialProject(
            timeline, budget, name, status, new Resource(materialExpenses, manHoursUsed, expectedTotalHours, expenses), this.id, size, buildingType
        );

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
        status.setValue("Ongoing");
        timeline.setText("");
        size.setText("");
        budget.setText("");
        buildingType.setText("");
        materialExpenses.setText("");
        manHoursUsed.setText("");
        expectedTotalHours.setText("");
        expenses.setText("");
    }

    public void edit(int id) {
        var project = (IndustrialProject)projectModelManager.getById(id);

        if (project == null) {
            return;
        }

        this.id = id;
        name.setText(project.getName());
        status.setValue(project.getStatus());
        timeline.setText(String.valueOf(project.getTimeline()));
        size.setText(String.valueOf(project.getSize()));
        budget.setText(String.valueOf(project.getBudget()));
        buildingType.setText(project.getBuildingType());
        materialExpenses.setText(String.valueOf(project.getMaterialExpenses()));
        manHoursUsed.setText(String.valueOf(project.getManHours()));
        expectedTotalHours.setText(String.valueOf(project.getExpectedTotalHours()));
        expenses.setText(String.valueOf(project.getExpenses()));
    }
}

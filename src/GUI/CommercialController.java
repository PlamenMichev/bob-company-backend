package GUI;

import Data.ProjectModelManager;
import Model.CommercialProject;
import Model.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CommercialController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button save;

    // Form states
    @FXML private TextField name;
    @FXML private ChoiceBox status;
    @FXML private TextField size;
    @FXML private TextField intendedUse;
    @FXML private TextField materialExpenses;
    @FXML private TextField manHoursUsed;
    @FXML private TextField expectedTotalHours;
    @FXML private TextField expenses;
    @FXML private TextField numberOfFloors;
    @FXML private TextField timeline;
    @FXML private TextField budget;

    private ProjectModelManager projectModelManager;

    public void init(ProjectModelManager projectModelManager)
    {
        this.projectModelManager = projectModelManager;
    }

    public void switchToIndex(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Index.fxml")));
        if (event.getSource() == save)
        {
            submitForm();
        }

        stage = (Stage)(save.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
            1,
            Double.parseDouble(size),
            Integer.parseInt(numberOfFloors),
            intendedUse
        );

        var currentProjects = projectModelManager.getAllProjects();
        currentProjects.addProject(newProject);
        projectModelManager.saveProjects(currentProjects);

        // Showing that the form was submitted successfully
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation");
        a.setContentText("The project has been saved!");
        a.showAndWait();
    }
}

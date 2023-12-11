package GUI;

import Data.ProjectModelManager;
import Model.ConstructionProject;
import Model.RoadProject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class IndexController
{
    @FXML private CommercialController commercialController;

    @FXML private Button edit;
    @FXML private MenuButton add;
    @FXML private MenuItem residential;
    @FXML private MenuItem commercial;
    @FXML private MenuItem industrial;
    @FXML private MenuItem road;

    // Table View
    @FXML private TableView<ConstructionProject> projectList;
    @FXML private TableColumn<ConstructionProject, String> name;
    @FXML private TableColumn<ConstructionProject, String> type;
    @FXML private TableColumn<ConstructionProject, Double> budget;
    @FXML private TableColumn<ConstructionProject, Integer> timeline;


    private Stage stage;
    private Scene scene;
    private Parent root;

    private ProjectModelManager modelManager;

    public void initialize()
    {
        name.setCellValueFactory(new PropertyValueFactory<ConstructionProject, String>("name"));
        type.setCellValueFactory(new PropertyValueFactory<ConstructionProject, String>("type"));
        budget.setCellValueFactory(new PropertyValueFactory<ConstructionProject, Double>("budget"));
        timeline.setCellValueFactory(new PropertyValueFactory<ConstructionProject, Integer>("timeline"));

        modelManager = new ProjectModelManager("projects.bin");
        updateProjects();
        commercialController.init(modelManager);
    }

    private void updateProjects()
    {
        var projects = modelManager.getAllProjects();
        var projectsForTableViewFormat = FXCollections.observableArrayList(projects.getProjects());

        this.projectList.setItems(projectsForTableViewFormat);
    }

    public void switchToResidential(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Residential.fxml")));
        stage = (Stage) (edit.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCommercial(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Commercial.fxml")));
        stage = (Stage)(edit.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToIndustrial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Industrial.fxml")));
        stage = (Stage)(edit.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRoad(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Road.fxml")));
        stage = (Stage)(edit.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStatistics(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Statistics.fxml")));
        stage = (Stage) (edit.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

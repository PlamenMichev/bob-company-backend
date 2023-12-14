package GUI;

import Data.ProjectModelManager;
import Model.ConstructionProject;

import Model.RoadProject;
import Utils.Sortings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class ProjectsListController
{

  // Table View
  @FXML private TableView<ConstructionProject> projectList;
  @FXML private TableColumn<ConstructionProject, String> name;
  @FXML private TableColumn<ConstructionProject, String> type;
  @FXML private TableColumn<ConstructionProject, Double> budget;
  @FXML private TableColumn<ConstructionProject, Integer> timeline;

  @FXML private MenuButton sortButton;
  @FXML private Button editButton;
  @FXML private Button deleteButton;

  private ProjectModelManager modelManager;
  private FormPickerController formPickerController;
  private TabPane globalTabPane;

  public void init(ProjectModelManager modelManager, FormPickerController formPickerController, TabPane globalTabPane)
  {
    this.formPickerController = formPickerController;
    this.globalTabPane = globalTabPane;

    name.setCellValueFactory(new PropertyValueFactory<ConstructionProject, String>("name"));
    type.setCellValueFactory(new PropertyValueFactory<ConstructionProject, String>("type"));
    budget.setCellValueFactory(new PropertyValueFactory<ConstructionProject, Double>("budget"));
    timeline.setCellValueFactory(new PropertyValueFactory<ConstructionProject, Integer>("timeline"));

    editButton.setDisable(true);
    deleteButton.setDisable(true);

    // add event handles
    projectList.setOnMouseClicked(event -> {
      var clickedButton = event.getButton();
      if(clickedButton == MouseButton.PRIMARY) {
        var selectedProject = projectList.getSelectionModel().getSelectedItem();
        if (selectedProject != null) {
          editButton.setDisable(false);
          deleteButton.setDisable(false);
        }
      }
    });

    this.modelManager = modelManager;
    updateProjects();
  }

  public void reset()
  {
    if (modelManager != null)
    {
      updateProjects();
    }
  }

  private void updateProjects()
  {
    var projects = modelManager.getAllProjects();
    var projectsForTableViewFormat = FXCollections.observableArrayList(projects.getProjects());

    this.projectList.setItems(projectsForTableViewFormat);
  }

  public void actionButtonHandler(ActionEvent event) throws IOException
  {
    if (event.getSource() == deleteButton)
    {
      deleteProject();

      // Showing that the deletion was successful
      Alert a = new Alert(Alert.AlertType.CONFIRMATION);
      a.setTitle("Confirmation");
      a.setContentText("The project has been deleted!");
      a.showAndWait();
      updateProjects();
    } else if (event.getSource() == editButton)
    {
      var selectedProject = projectList.getSelectionModel().getSelectedItem();
      globalTabPane.getSelectionModel().select(1); // The forms tab
      formPickerController.editProject(selectedProject.getId(), selectedProject.getType());
    }
  }

  private void deleteProject()
  {
    var selectedProject = projectList.getSelectionModel().getSelectedItem();
    if (selectedProject != null)
    {
      modelManager.removeProject(selectedProject);
    }
  }

  public void sortByName(Event event)
  {
    var sortedList = modelManager.getAllProjects().getProjects();
    Sortings.SortAscendingOnName(sortedList, 0, modelManager.getAllProjects().size() - 1);

    var projectsForTableViewFormat = FXCollections.observableArrayList(sortedList);
    this.projectList.setItems(projectsForTableViewFormat);

    sortButton.setText("Name");
  }

  public void sortByType(Event event)
  {
    var sortedList = modelManager.getAllProjects().getProjects();
    Sortings.SortAscendingOnType(sortedList, 0, sortedList.size() - 1);

    var projectsForTableViewFormat = FXCollections.observableArrayList(sortedList);
    this.projectList.setItems(projectsForTableViewFormat);

    sortButton.setText("Project type");
  }

  public void sortByBudget(Event event)
  {
    var sortedList = modelManager.getAllProjects().getProjects();
    Sortings.SortAscendingOnBudget(sortedList, 0, sortedList.size() - 1);

    var projectsForTableViewFormat = FXCollections.observableArrayList(sortedList);
    this.projectList.setItems(projectsForTableViewFormat);

    sortButton.setText("Budget");
  }

  public void sortByTimeline(Event event)
  {
    var sortedList = modelManager.getAllProjects().getProjects();
    Sortings.SortAscendingOnTimeline(sortedList, 0, sortedList.size() - 1);

    var projectsForTableViewFormat = FXCollections.observableArrayList(sortedList);
    this.projectList.setItems(projectsForTableViewFormat);

    sortButton.setText("Timeline");
  }
}

package GUI;

import Data.ProjectModelManager;
import Model.ConstructionProject;

import Model.RoadProject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ProjectsListController
{

  // Table View
  @FXML private TableView<ConstructionProject> projectList;
  @FXML private TableColumn<ConstructionProject, String> name;
  @FXML private TableColumn<ConstructionProject, String> type;
  @FXML private TableColumn<ConstructionProject, Double> budget;
  @FXML private TableColumn<ConstructionProject, Integer> timeline;

  private ProjectModelManager modelManager;

  public void initialize()
  {
    name.setCellValueFactory(new PropertyValueFactory<ConstructionProject, String>("name"));
    type.setCellValueFactory(new PropertyValueFactory<ConstructionProject, String>("type"));
    budget.setCellValueFactory(new PropertyValueFactory<ConstructionProject, Double>("budget"));
    timeline.setCellValueFactory(new PropertyValueFactory<ConstructionProject, Integer>("timeline"));

    modelManager = new ProjectModelManager("projects.bin");
    updateProjects();
  }

  private void updateProjects()
  {
    var projects = modelManager.getAllProjects();
    var projectsForTableViewFormat = FXCollections.observableArrayList(projects.getProjects());

    this.projectList.setItems(projectsForTableViewFormat);
  }
}

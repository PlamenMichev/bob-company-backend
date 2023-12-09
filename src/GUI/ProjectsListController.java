package GUI;

import Model.ConstructionProject;
import java.net.URL;
import java.util.ResourceBundle;

import Model.RoadProjects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ProjectsListController
{
  @FXML private TableView<ConstructionProject> projectList;
  @FXML private TableColumn<ConstructionProject, Integer> id;
  @FXML private TableColumn<ConstructionProject, String> name;

  public void initialize()
  {
    var project = new RoadProjects(1, 2.0, "plamen", "done", null, 1, 2.0, 2.0);

    ObservableList<ConstructionProject> projects = FXCollections.observableArrayList();
    projects.add(project);

    id.setCellValueFactory(new PropertyValueFactory<ConstructionProject, Integer>("id"));
    name.setCellValueFactory(new PropertyValueFactory<ConstructionProject, String>("name"));
    this.projectList.setItems(projects);
  }
}

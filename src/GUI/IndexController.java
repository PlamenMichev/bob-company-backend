package GUI;

import Data.ProjectModelManager;
import Model.ConstructionProject;
import Model.RoadProject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

/**
 * The class that is used to manage actions in the index tab
 * @author Group 2
 * @version 1.0
 */
public class IndexController
{
    @FXML private ProjectsListController projectsListController;
    @FXML private FormPickerController formPickerController;
    @FXML private StatisticsController statisticsController;

    @FXML private TabPane tabPane;
    @FXML private Tab allProjectsTab;
    @FXML private Tab formPickerTab;
    @FXML private Tab statisticsTab;

    /**
     * Initializer of the index
     */
    public void initialize()
    {
        var modelManager = new ProjectModelManager("projects.bin");
        this.projectsListController.init(modelManager, formPickerController, tabPane);
        this.formPickerController.init(modelManager, this.tabPane);
        this.statisticsController.init(modelManager);

    }

    /**
     * Method used to change between tabs
     * @param event the event the function will act upon
     */
    public void tabChanged(Event event)
    {
        if (allProjectsTab.isSelected())
        {
            projectsListController.reset();
        } else if (formPickerTab.isSelected())
        {
            formPickerController.resetValues();
        } else if (statisticsTab.isSelected())
        {
            statisticsController.updateStatistics();
        }
    }
}

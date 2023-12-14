package GUI;

import Data.ProjectModelManager;
import Model.ConstructionProject;
import Model.Statistic;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The class that is used to manage actions in the statistics tab
 * @author Group 2
 * @version 1.0
 */
public class StatisticsController
{

    // Table View
    @FXML private TableView<Statistic> tableView;
    @FXML private TableColumn<Statistic, String> projectType;
    @FXML private TableColumn<Statistic, Double> materialExpenses;
    @FXML private TableColumn<Statistic, Double> manHoursUsed;
    @FXML private TableColumn<Statistic, Double> expectedTotalHours;
    @FXML private TableColumn<Statistic, Double> expenses;

    private ProjectModelManager projectModelManager;

    /**
     * Initializer of the tab
     * @param projectModelManager the project model manager
     */
    public void init(ProjectModelManager projectModelManager)
    {
        this.projectModelManager = projectModelManager;
        projectType.setCellValueFactory(new PropertyValueFactory<Statistic, String>("projectType"));
        materialExpenses.setCellValueFactory(new PropertyValueFactory<Statistic, Double>("materialExpenses"));
        manHoursUsed.setCellValueFactory(new PropertyValueFactory<Statistic, Double>("manHoursUsed"));
        expectedTotalHours.setCellValueFactory(new PropertyValueFactory<Statistic, Double>("expectedTotalHours"));
        expenses.setCellValueFactory(new PropertyValueFactory<Statistic, Double>("expenses"));

        updateStatistics();
    }

    /**
     * Method used to update the statistics
     */
    public void updateStatistics()
    {
        var commercialStatistics = projectModelManager.getStatistics("commercial");
        var residentialStatistics = projectModelManager.getStatistics("residential");
        var industrialStatistics = projectModelManager.getStatistics("industrial");
        var roadStatistics = projectModelManager.getStatistics("road");

        tableView.setItems(FXCollections.observableArrayList(commercialStatistics, residentialStatistics, industrialStatistics, roadStatistics));
    }
}

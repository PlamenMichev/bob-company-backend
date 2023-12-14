package GUI;

import Data.ProjectModelManager;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * The class that is used to display the tabs for projects
 * @author Group 2
 * @version 1.0
 */
public class FormPickerController
{
  @FXML private CommercialController commercialController;
  @FXML private IndustrialController industrialController;
  @FXML private ResidentialController residentialController;
  @FXML private RoadController roadController;

  @FXML private TabPane tabPane;
  @FXML private Tab commercialTab;
  @FXML private Tab industrialTab;
  @FXML private Tab residentialTab;
  @FXML private Tab roadTab;

  /**
   * Initializer of the tab
   * @param modelManager  the project model manager
   * @param tabPane the tab
   */
  public void init(ProjectModelManager modelManager, TabPane tabPane)
  {
    this.commercialController.init(modelManager, tabPane);
    this.industrialController.init(modelManager, tabPane);
    this.residentialController.init(modelManager, tabPane);
    this.roadController.init(modelManager, tabPane);
  }

  /**
   * Method used to restore all the tabs to default values
   */
  public void resetValues()
  {
    commercialController.resetValues();
    industrialController.resetValues();
    residentialController.resetValues();
    roadController.resetValues();
  }

  /**
   * Method used to change between the four tabs
   * @param event the event upon which the method acts
   */
  public void tabChanged(Event event)
  {
    if (commercialTab.isSelected())
    {
      commercialController.resetValues();
    } else if (industrialTab.isSelected())
    {
      industrialController.resetValues();
    } else if (residentialTab.isSelected())
    {
      residentialController.resetValues();
    } else if (roadTab.isSelected())
    {
      roadController.resetValues();
    }
  }

  /**
   * Method used to enter the edit tab
   * @param id the id of the project to be edited
   * @param type the type of the project to be edited
   */
  public void editProject(int id, String type)
  {
    if (type == null)
    {
      return;
    }

    if (type.equalsIgnoreCase("Commercial"))
    {
      tabPane.getSelectionModel().select(commercialTab);
      commercialController.edit(id);
    } else if (type.equalsIgnoreCase("Industrial"))
    {
      tabPane.getSelectionModel().select(industrialTab);
      industrialController.edit(id);
    } else if (type.equalsIgnoreCase("Residential"))
    {
      tabPane.getSelectionModel().select(residentialTab);
      residentialController.edit(id);
    } else if (type.equalsIgnoreCase("Road"))
    {
      tabPane.getSelectionModel().select(roadTab);
      roadController.edit(id);
    }
  }
}

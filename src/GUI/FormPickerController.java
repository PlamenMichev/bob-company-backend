package GUI;

import Data.ProjectModelManager;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

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

  public void init(ProjectModelManager modelManager, TabPane tabPane)
  {
    // TODO: initialize other controllers
    this.commercialController.init(modelManager, tabPane);
    this.industrialController.init(modelManager, tabPane);
    this.residentialController.init(modelManager, tabPane);
    this.roadController.init(modelManager, tabPane);
  }

  public void resetValues()
  {
    commercialController.resetValues();
    industrialController.resetValues();
    residentialController.resetValues();
    roadController.resetValues();
  }

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
}

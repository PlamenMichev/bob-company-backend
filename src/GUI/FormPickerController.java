package GUI;

import Data.ProjectModelManager;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class FormPickerController
{
  @FXML private CommercialController commercialController;

  @FXML private TabPane tabPane;
  @FXML private Tab commercialTab;

  public void init(ProjectModelManager modelManager, TabPane tabPane)
  {
    // TODO: initialize other controllers
    this.commercialController.init(modelManager, tabPane);
  }

  public void resetValues()
  {
    commercialController.resetValues();
  }

  public void tabChanged(Event event)
  {
    if (commercialTab.isSelected())
    {
      commercialController.resetValues();
    }
  }
}

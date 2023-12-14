package GUI;
import Data.ProjectModelManager;
import Utils.FileHandler;
import javafx.application.Application;

public class AppLauncher
{
    public static void main(String[] args) throws Exception
    {
        Application.launch(ConstructionCompanyGUIFXML.class);

        // Generate XML file for the website
        var modelManager = new ProjectModelManager("projects.bin");
        var listForWebsite = modelManager.getAllProjects();
        FileHandler.writeToXmlFile("projects.xml", listForWebsite);
    }
}

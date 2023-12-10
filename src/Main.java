import Data.ProjectModelManager;
import Model.CommercialProject;
import Model.Resource;
import parser.ParserException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParserException
    {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }

        var projectModelManager = new ProjectModelManager("projects.bin");
        var projects = projectModelManager.getAllProjects();
        System.out.println("1 " + projects.size());
        projects.addProject(
            new CommercialProject(10, 2.0, "name", "status", new Resource(0, 0, 0, 0), 1, 2000,"house"));
        projectModelManager.saveProjects(projects);
        System.out.println("2 " + projects.size());
    }
}
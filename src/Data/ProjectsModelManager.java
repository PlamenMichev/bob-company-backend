package Data;

import Model.ConstructionProject;
import Model.ProjectList;
import Model.ResidentialProject;
import parser.ParserException;
import parser.XmlJsonParser;

import java.util.ArrayList;

public class ProjectsModelManager
{
  public ArrayList<ResidentialProject> GetAllProjects() throws ParserException
  {
    XmlJsonParser parser = new XmlJsonParser();
    var simpleName = ProjectList.class.getSimpleName();
    System.out.println("simpleName = " + simpleName);
    ProjectList list = parser.fromXml("src/Data/Files/Projects.xml", ProjectList.class);
//    System.out.println("list=\n" + list);

//    File file = parser.toXml(list, "cdList.xml");
//    System.out.println("Generated file: " + file.getAbsolutePath());
    return new ArrayList<>();
  }
}

package Data;

import Model.ProjectList;
import Model.ResidentialProject;
import Utils.FileHandler;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectModelManager
{
  private String fileName;

  public ProjectModelManager(String fileName)
  {
    this.fileName = fileName;
  }


  public ProjectList getAllProjects()
  {
    var allProjects = new ProjectList();

    try
    {
      allProjects = (ProjectList) FileHandler.readFromBinaryFile(fileName);

      // This is the case when the file is empty
      if (allProjects == null)
      {
        allProjects = new ProjectList();
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }

    return allProjects;
  }

  public void saveProjects(ProjectList projects)
  {
    try
    {
      FileHandler.writeToBinaryFile(fileName, projects);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

}

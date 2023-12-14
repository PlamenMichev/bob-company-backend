package Data;

import Model.ConstructionProject;
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

  public void removeProject(ConstructionProject project)
  {
    var allProjects = getAllProjects();
    allProjects.removeProject(project);
    saveProjects(allProjects);
  }

  public ConstructionProject getById(int id)
  {
    var allProjects = getAllProjects().getProjects();
    var result = allProjects.stream()
      .filter((project) -> project.getId() == id)
      .findFirst().orElse(null);

    return result;
  }

  public void updateProject(ConstructionProject project)
  {
    var allProjects = getAllProjects();
    var existingProject = getById(project.getId()); // We need the old object so the index of works with the .equals method
    var indexOfProject = allProjects.getProjects().indexOf(existingProject);

    System.out.println(indexOfProject);
    if (indexOfProject != -1)
    {
      allProjects.getProjects().set(indexOfProject, project);
      saveProjects(allProjects);
    }
  }
}

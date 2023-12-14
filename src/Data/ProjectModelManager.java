package Data;

import Model.ConstructionProject;
import Model.ProjectList;
import Model.ResidentialProject;
import Model.Statistic;
import Utils.FileHandler;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;

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

  public Statistic getStatistics(String projecectType)
  {
    var allProjects = getAllProjects().getProjects();
    var projects = allProjects.stream()
      .filter((project) -> project.getType().equalsIgnoreCase(projecectType) && project.getStatus().equalsIgnoreCase("finished")).toList();

    // Find the average of the material expenses from all the projects
    var materialExpenses = projects.stream()
      .mapToDouble(ConstructionProject::getMaterialExpenses)
      .average().orElse(0);

    var manHoursUsed = projects.stream()
      .mapToDouble(ConstructionProject::getManHours)
      .average().orElse(0);

    var expectedTotalHours = projects.stream()
      .mapToDouble(ConstructionProject::getExpectedTotalHours)
      .average().orElse(0);

    var expenses = projects.stream()
      .mapToDouble(ConstructionProject::getExpenses)
      .average().orElse(0);

    return new Statistic(projecectType, materialExpenses, manHoursUsed, expectedTotalHours, expenses);
  }
}

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

/**
 * The class that is used to get information from the file and save information into it
 * @author Group 2
 * @version 1.0
 */
public class ProjectModelManager
{
  private String fileName;

  /**
   * Constructor for ProjectModelManager class
   * @param fileName the name of the file in use
   */
  public ProjectModelManager(String fileName)
  {
    this.fileName = fileName;
  }


  /**
   * Method used to get all projects from the file
   * @return allProjects list of all projects
   */
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

  /**
   * Method used to store the current list of projects into the file
   * @param projects the current list of projects
   */
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

  /**
   * Method used to remove a specific project from the file
   * @param project the project to be removed
   */
  public void removeProject(ConstructionProject project)
  {
    var allProjects = getAllProjects();
    allProjects.removeProject(project);
    saveProjects(allProjects);
  }

  /**
   * Function used to get a construction project by id
   * @param id the id of the desired construction project
   * @return result the desired project
   */
  public ConstructionProject getById(int id)
  {
    var allProjects = getAllProjects().getProjects();
    var result = allProjects.stream()
      .filter((project) -> project.getId() == id)
      .findFirst().orElse(null);

    return result;
  }

  /**
   * Method used to change the information about one project
   * @param project the project that will be modified
   */
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

  /**
   * Method used to get the statistics about finished projects
   * @param projectType the type of the project the statistics will be made about
   * @return the statistics object needed
   */
  public Statistic getStatistics(String projectType)
  {
    var allProjects = getAllProjects().getProjects();
    var projects = allProjects.stream()
      .filter((project) -> project.getType().equalsIgnoreCase(projectType) && project.getStatus().equalsIgnoreCase("finished")).toList();

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

    return new Statistic(projectType, materialExpenses, manHoursUsed, expectedTotalHours, expenses);
  }
}

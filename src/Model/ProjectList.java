package Model;

import java.util.ArrayList;

public class ProjectList
{
  private ArrayList<ConstructionProject> projects;

  public ProjectList()
  {
    projects = new ArrayList<>();
  }

  public void addProject(ConstructionProject project)
  {
    projects.add(project);
  }

  public void removeProject(ConstructionProject project)
  {
    projects.remove(project);
  }

  public ArrayList<ConstructionProject> getProjects()
  {
    return projects;
  }

  public void setProjects(ArrayList<ConstructionProject> projects)
  {
    this.projects = projects;
  }
}

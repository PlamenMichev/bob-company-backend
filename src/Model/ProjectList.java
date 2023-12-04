package Model;

import java.util.ArrayList;

public class ProjectList
{
  private ArrayList<ResidentialProject> residentialProjects;

  public ProjectList()
  {
    residentialProjects = new ArrayList<>();
  }

  public void addProject(ResidentialProject project)
  {
    residentialProjects.add(project);
  }

  public void removeProject(ResidentialProject project)
  {
    residentialProjects.remove(project);
  }

  public ArrayList<ResidentialProject> getProjects()
  {
    return residentialProjects;
  }

  public void setProjects(ArrayList<ResidentialProject> projects)
  {
    this.residentialProjects = projects;
  }
}

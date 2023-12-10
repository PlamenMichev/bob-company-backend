package Model;
import Utils.Sortings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The class that manages the list of projects
 * @author Group 2
 * @version 1.0
 */
public class ProjectList implements Serializable
{
    ArrayList<ConstructionProject> projects;

    /**
     * Constructor for ProjectList class
     */
    public ProjectList()
    {
        projects = new ArrayList<>();
    }

    /**
     * Method used to add a project to the list
     * @param constructionProject the construction project that has to be added to the list
     */
    public void addProject(ConstructionProject constructionProject)
    {
        projects.add(constructionProject);
    }

    /**
     * Method used to remove a project from the list
     * @param constructionProject the construction project that has to be removed from the list
     */
    public void removeProject(ConstructionProject constructionProject)
    {
        projects.remove(constructionProject);
    }

    /**
     * Method used to sort the list ascending by name
     */
    public void SortAOnName()
    {
        Sortings.SortAscendingOnName(projects, 0, projects.size());
    }

    /**
     * Method used to sort the list descending by name
     */
    public void SortDOnName()
    {
        Sortings.SortAscendingOnName(projects, 0, projects.size());
        Collections.reverse(projects);
    }

    public int size()
    {
        return projects.size();
    }
}

package Model;
import Utils.Sortings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

    public ArrayList<ConstructionProject> getProjects()
    {
        return projects;
    }

    /**
     * Method used to sort the list ascending by name
     */
    public void sortAOnName()
    {
        Sortings.SortAscendingOnName(projects, 0, projects.size());
    }

    /**
     * Method used to sort the list descending by name
     */
    public void sortDOnName()
    {
        sortAOnName();
        Collections.reverse(projects);
    }

    /**
     * Method used to sort the list ascending by type
     */
    public void sortAOnType()
    {
        Sortings.SortAscendingOnType(projects, 0, projects.size());
    }

    /**
     * Method used to sort the list descending by type
     */
    public void sortDOnType()
    {
        sortAOnType();
        Collections.reverse(projects);
    }

    /**
     * Method used to sort the list ascending by budget
     */
    public void sortAOnBudget()
    {
        Sortings.SortAscendingOnBudget(projects, 0, projects.size());
    }

    /**
     * Method used to sort the list descending by budget
     */
    public void sortDOnBudget()
    {
        sortAOnBudget();
        Collections.reverse(projects);
    }

    /**
     * Method used to sort the list ascending by timeline
     */
    public void sortAOnTimeline()
    {
        Sortings.SortAscendingOnTimeline(projects, 0, projects.size());
    }

    /**
     * Method used to sort the list descending by timeline
     */
    public void sortDOnTimeline()
    {
        sortAOnTimeline();
        Collections.reverse(projects);
    }
    /**
     * Method that calculates the average of material expenses for the
     * finished projects of the specified project type
     * @param type the type of project we want to calculate the average on
     * @return total (the desired average)
     */
    public double materialExpensesAverage(String type)
    {
        double total = 0;
        for(int i = 0; i < projects.size(); i++)
        {
            if(projects.get(i).getType().equals(type) &&
                projects.get(i).getStatus().equals("finished"))
                    total += projects.get(i).getMaterialExpenses();
        }
        return total;
    }

    /**
     * Method that calculates the average of man-hours used for the
     * finished projects of the specified project type
     * @param type the type of project we want to calculate the average on
     * @return total (the desired average)
     */
    public double manHoursAverage(String type)
    {
        double total = 0;
        for(int i = 0; i < projects.size(); i++)
        {
            if(projects.get(i).getType().equals(type) &&
                    projects.get(i).getStatus().equals("finished"))
                        total += projects.get(i).getManHours();
        }
        return total;
    }

    /**
     * Method that calculates the average of expected total hours for the
     * finished projects of the specified project type
     * @param type the type of project we want to calculate the average on
     * @return total (the desired average)
     */
    public double expectedTotalHoursAverage(String type)
    {
        double total = 0;
        for(int i = 0; i < projects.size(); i++)
        {
            if(projects.get(i).getType().equals(type) &&
                    projects.get(i).getStatus().equals("finished"))
                        total += projects.get(i).getExpectedTotalHours();
        }
        return total;
    }

    /**
     * Method that calculates the average of expenses for the
     * finished projects of the specified project type
     * @param type the type of project we want to calculate the average on
     * @return total (the desired average)
     */
    public double expensesAverage(String type)
    {
        double total = 0;
        for(int i = 0; i < projects.size(); i++)
        {
            if(projects.get(i).getType().equals(type) &&
                    projects.get(i).getStatus().equals("finished"))
                        total += projects.get(i).getExpenses();
        }
        return total;
    }

    public int size()
    {
        return projects.size();
    }
}

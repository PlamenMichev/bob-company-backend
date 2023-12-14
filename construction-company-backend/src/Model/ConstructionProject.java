package Model;

import Utils.EmptyStringFieldException;
import Utils.InvalidValueException;

import java.io.Serializable;

/**
 * Abstract class for the overall layout of the projects
 * @author Group 2
 * @version 1.0
 */
public abstract class ConstructionProject implements Serializable
{
    private int timeline;
    private double budget;
    private String type;
    private String name;
    private String status;
    private Resource resource;
    private int id;

    /**
     * Constructor for construction projects
     * @param timeline expected timeline for project
     * @param budget expected budget for project
     * @param type the type of the project
     * @param name the name of the project
     * @param status the status of the project
     * @param resource the resources needed for the project
     * @param id the id of the project
     */
    public ConstructionProject(int timeline, double budget, String type,
                               String name,String status, Resource resource, int id)
    {
        if(type.equals("residential") && (timeline < 6 || timeline > 12) ||
            type.equals("commercial") && (timeline < 12 || timeline > 24) ||
            type.equals("industrial") && (timeline < 24 || timeline > 36) ||
            type.equals("road") && (timeline < 12 || timeline > 24)) throw new InvalidValueException();
        if(type.equals("residential") && (budget < 100000 || budget > 500000) ||
                type.equals("commercial") && (budget < 500000 || budget > 2000000) ||
                type.equals("industrial") && (budget < 2000000 || budget > 10000000) ||
                type.equals("road") && (budget < 1000000 || budget > 5000000)) throw new InvalidValueException();
        if(type == null) throw new InvalidValueException();
        if(name.charAt(0) < 'A' ||
            name.charAt(0) > 'z') throw new InvalidValueException();
        if(name == null) throw new EmptyStringFieldException();

        this.timeline = timeline;
        this.budget = budget;
        this.type = type;
        this.name = name;
        this.status=status;
        this.resource=resource;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    /**
     * Getter function for timeline
     * @return timeline
     */
    public  int getTimeline() {
        return timeline;
    }

    /**
     * Getter function for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter function for type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter function for budget
     * @return budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Setter function for budget
     * @param budget new value for budget
     */
    public void setBudget(double budget) {
        if(budget < 0) throw new InvalidValueException();
        this.budget = budget;
    }

    /**
     * Setter function for timeline
     * @param timeline new value for timeline
     */
    public void setTimeline(int timeline) {
        if(timeline < 0) throw new InvalidValueException();
        this.timeline = timeline;
    }

    /**
     * Getter function for status
     * @return status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Setter function for status
     * @param status new value for status
     */
    public void setStatus(String status)
    {
        this.status=status;
    }

    /**
     * Getter function for materialExpenses
     * @return materialExpenses
     */
    public double getMaterialExpenses()
    {
        return resource.getMaterialExpenses();
    }

    /**
     * Getter function for manHours
     * @return manHours
     */
    public double getManHours()
    {
        return resource.getManHours();
    }

    /**
     * Getter function for expectedTotalHours
     * @return expectedTotalHours
     */
    public double getExpectedTotalHours()
    {
        return resource.getExpectedTotalHours();
    }

    /**
     * Getter function for expenses
     * @return expenses
     */
    public double getExpenses()
    {
        return resource.getExpenses();
    }

    /**
     * Overriding method "equals" for comparing 2 construction project objects
     * @param obj object that is compared to this object
     * @return true if the objects equal each other, false otherwise
     */
    public boolean equals(Object obj)
    {
        if(obj == null || getClass() != obj.getClass())
            return false;
        ConstructionProject constructionProject = (ConstructionProject) obj;
        return budget == constructionProject.budget &&
                timeline == constructionProject.timeline &&
                name.equals(constructionProject.name) &&
                type.equals(constructionProject.type);
    }

    /**
     * Overriding method "toString" for the construction project objects
     * @return the values in the fields of this class as strings
     */
    public String toString()
    {
        return "Name: " + name +
                ", Type: " + type +
                ", Budget: " + budget +
                ", Timeline: " + timeline;
    }
}

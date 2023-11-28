package Model;

public abstract class ConstructionProject
{
    private int timeline;
    private double budget;
    private String type;
    private String name;
    private Resource resource;

    public ConstructionProject()
    {
        this.timeline = 0;
        this.budget = 0;
        this.type = "";
        this.name = "";
    }

    public ConstructionProject(int timeline, double budget, String type, String name, Resource resource)
    {
        this.timeline = timeline;
        this.budget = budget;
        this.type = type;
        this.name = name;
    }

    public int getTimeline() {
        return timeline;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setTimeline(int timeline) {
        this.timeline = timeline;
    }

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

    public String toString()
    {
        return "Name: " + name +
                ", Type: " + type +
                ", Budget: " + budget +
                ", Timeline: " + timeline;
    }
}

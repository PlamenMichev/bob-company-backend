package Model;

public abstract class ConstructionProject
{
    private int timeline;
    private double budget;
    private String type;
    private String name;
    private String status;
    private Resource resource;
    private int id;
    public ConstructionProject(int timeline, double budget, String type, String name,String status, Resource resource, int id)
    {
        this.timeline = timeline;
        this.budget = budget;
        this.type = type;
        this.name = name;
        this.status=status;
        this.resource=resource;
        this.id=id;
    }

    public  int getTimeline() {
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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status=status;
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

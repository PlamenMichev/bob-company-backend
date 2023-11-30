package Model;

public class RoadProjects extends ConstructionProject
{
  private double lenght;
  private double width;
  private int numberOfBridges;
  private int environmentalChallanges;

  public RoadProjects(int timeline, double budget, String type, String name, String status,Resource resource , int id, double lenght, double width, int numberOfBridges, int environmentalChallanges)
  {
    super(timeline, budget,"road", name, status, resource, id);
    this.lenght=lenght;
    this.width=width;
    this.numberOfBridges=numberOfBridges;
    this.environmentalChallanges=environmentalChallanges;

  }
  public RoadProjects(int timeline, double budget,String type, String name, String status,Resource resource , int id, double lenght, double width)
  {
    super(18, budget, "road", name, status, resource, id);
    this.lenght=lenght;
    this.width=width;
    numberOfBridges=0;
    environmentalChallanges=0;
  }

  public double getLenght()
  {
    return lenght;
  }
  public double getWidth()
  {
    return width;
  }

  public int getNumberOfBridges()
  {
    return numberOfBridges;
  }

  public int getEnvironmentalChallanges()
  {
    return environmentalChallanges;
  }

  public void setLenght(double lenght)
  {
    this.lenght=lenght;
  }

  public void setWidth(double width)
  {
    this.width=width;
  }

  public void setNumberOfBridges(int numberOfBridges)
  {
    this.numberOfBridges=numberOfBridges;
  }

  public void setEnvironmentalChallanges(int environmentalChallanges)
  {
    this.environmentalChallanges=environmentalChallanges;
  }

  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
    return false;

    RoadProjects other=(RoadProjects) obj;

    return super.equals(other) && lenght==other.lenght && width==other.width && numberOfBridges==other.numberOfBridges && environmentalChallanges==other.environmentalChallanges;

  }

  public String toString()
  {
    return super.toString()+" "+lenght+" "+width+" "+numberOfBridges+" "+environmentalChallanges;
  }
}

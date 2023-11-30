package Model;

public class CommercialProject extends ConstructionProject
{
  private double size;
  private int numberOfFloors;
  private String intendedUse;


  public CommercialProject(int timeline, double budget,String type, String name, String status,Resource resource , int id, double size, int numberOfFloors, String intendedUse)
  {
    super(timeline, budget, "commercial", name,status,resource, id);
    this.size=size;
    this.numberOfFloors=numberOfFloors;
    this.intendedUse=intendedUse;
  }

  public CommercialProject(int timeline, double budget,String type, String name, String status,Resource resource , int id, double size, String intendedUse){
    super(18, budget, "commercial", name, status, resource, id);
    this.size=size;
    numberOfFloors=1;
    this.intendedUse=intendedUse;
  }

  public double getSize()
  {
    return size;
  }

  public int getNumberOfFloors()
  {
    return numberOfFloors;
  }

  public void setNumberOfFloors(int numberOfFloors)
  {
    this.numberOfFloors=numberOfFloors;
  }

  public String getIntendedUse()
  {
    return intendedUse;
  }

  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
      return false;

    CommercialProject other=(CommercialProject) obj;

    return super.equals(other) && size==other.size && numberOfFloors==other.numberOfFloors && intendedUse.equals(other.intendedUse);

  }

  public String toString()
  {
    return super.toString()+" "+size+" "+numberOfFloors+" "+intendedUse;
  }

}

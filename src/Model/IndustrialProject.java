package Model;

public class IndustrialProject extends ConstructionProject
{
  private double size;
  private String buildingType;

  public IndustrialProject(int timeline, double budget,String type, String name, String status,Resource resource , int id, double size, String buildingType)
  {
    super(timeline, budget, "industial", name, status, resource, id);
    this.size=size;
    this.buildingType=buildingType;
  }

  public IndustrialProject(int timeline, double budget,String type, String name, String status,Resource resource , int id, double size)
  {
    super(30, budget, "industial", name, status, resource ,id);
    this.size=size;
    buildingType="warehouse";
  }

  public double getSize()
  {
    return size;
  }

  public String getBuildingType()
  {
    return buildingType;
  }

  public void setSize(double size)
  {
    this.size=size;
  }

  public void setBuildingType(String buildingType)
  {
    this.buildingType=buildingType;
  }

  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
    return false;

    IndustrialProject other=(IndustrialProject) obj;

    return super.equals(other) && size==other.size && buildingType.equals(other.buildingType);
  }


  public String toString()
  {
    return super.toString()+" "+size+" "+buildingType;
  }




}

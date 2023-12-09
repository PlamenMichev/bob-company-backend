package Model;

import Util.EmptyStringFieldException;
import Util.InvalidValueException;

/**
 * The class that stores data about industrial projects
 * @author Group 2
 * @version 1.0
 */
public class IndustrialProject extends ConstructionProject
{
  private double size;
  private String buildingType;

  /**
   * Constructor for IndustrialProject class that requires all fields to be given
   * @param timeline expected timeline for project
   * @param budget expected budget for project
   * @param name the name of the project
   * @param status the status of the project
   * @param resource the resources needed for the project
   * @param id the id of the project
   * @param size the size of the project
   * @param buildingType the type of the building
   */
  public IndustrialProject(int timeline, double budget, String name,
                           String status,Resource resource , int id,
                           double size, String buildingType)
  {
    super(timeline, budget, "industrial", name, status, resource, id);
    if(size < 0) throw new InvalidValueException();
    if(buildingType.charAt(0) < 'A' ||
      buildingType.charAt(0) > 'z') throw new InvalidValueException();
    if(buildingType == null) throw new EmptyStringFieldException();
    this.size=size;
    this.buildingType=buildingType;
  }

  /**
   * Constructor for IndustrialProject class that fills the default values when possible
   * @param timeline expected timeline for project
   * @param budget expected budget for project
   * @param name the name of the project
   * @param status the status of the project
   * @param resource the resources needed for the project
   * @param id the id of the project
   * @param size the size of the project
   */
  public IndustrialProject(int timeline, double budget, String name,
                           String status,Resource resource , int id, double size)
  {
    super(30, budget, "industrial", name, status, resource ,id);
    if(size < 0) throw new InvalidValueException();
    this.size=size;
    buildingType="warehouse";
  }

  /**
   * Getter function for size
   * @return size
   */
  public double getSize()
  {
    return size;
  }

  /**
   * Getter function for buildingType
   * @return buildingType
   */
  public String getBuildingType()
  {
    return buildingType;
  }

  /**
   * Setter function for size
   * @param size new value for size
   */
  public void setSize(double size)
  {
    if(size < 0) throw new InvalidValueException();
    this.size=size;
  }

  /**
   * Setter function for buildingType
   * @param buildingType new value for buildingType
   */
  public void setBuildingType(String buildingType)
  {
    if(buildingType.charAt(0) < 'A' ||
            buildingType.charAt(0) > 'z') throw new InvalidValueException();
    if(buildingType == null) throw new EmptyStringFieldException();
    this.buildingType=buildingType;
  }

  /**
   * Overriding method "equals" for comparing 2 industrial project objects
   * @param obj object that is compared to this object
   * @return true if the objects equal each other, false otherwise
   */
  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass()) return false;

    IndustrialProject other=(IndustrialProject) obj;

    return super.equals(other) &&
            size==other.size &&
            buildingType.equals(other.buildingType);
  }

  /**
   * Overriding method "toString" for the industrial project objects
   * @return the values in the fields of this class as strings
   */
  public String toString()
  {
    return super.toString()+" "+size+" "+buildingType;
  }




}

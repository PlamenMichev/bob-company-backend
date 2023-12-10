package Model;

import Utils.EmptyStringFieldException;
import Utils.InvalidValueException;

/**
 * The class that stores data for construction projects
 * @author Group 2
 * @version 1.0
 */
public class CommercialProject extends ConstructionProject
{
  private double size;
  private int numberOfFloors;
  private String intendedUse;

  /**
   * Constructor for CommercialProject class that requires all fields to be given
   * @param timeline expected timeline for project
   * @param budget expected budget for project
   * @param name the name of the project
   * @param status the status of the project
   * @param resource the resources needed for the project
   * @param id the id of the project
   * @param size the size of the project
   * @param numberOfFloors the number of floors of the building
   * @param intendedUse the intended use of the building
   */
  public CommercialProject(int timeline, double budget, String name,
                           String status,Resource resource , int id,
                           double size, int numberOfFloors, String intendedUse)
  {
    super(timeline, budget, "commercial", name,status,resource, id);
    if(size < 0) throw new InvalidValueException();
    if (numberOfFloors < 1) throw new InvalidValueException();
    if(intendedUse.charAt(0) < 'A' ||
      intendedUse.charAt(0) > 'z') throw new InvalidValueException();
    if(intendedUse == null) throw new EmptyStringFieldException();
    this.size=size;
    this.numberOfFloors=numberOfFloors;
    this.intendedUse=intendedUse;
  }

  /**
   * Constructor for CommercialProject class that fills the default values when possible
   * @param timeline expected timeline for project
   * @param budget expected budget for project
   * @param name the name of the project
   * @param status the status of the project
   * @param resource the resources needed for the project
   * @param id the id of the project
   * @param size the size of the project
   * @param intendedUse the intended use of the building
   */
  public CommercialProject(int timeline, double budget, String name,
                           String status,Resource resource , int id,
                           double size, String intendedUse){
    super(18, budget, "commercial", name, status, resource, id);
    if(size < 0) throw new InvalidValueException();
    if(intendedUse.charAt(0) < 'A' ||
            intendedUse.charAt(0) > 'z') throw new InvalidValueException();
    if(intendedUse == null) throw new EmptyStringFieldException();
    this.size=size;
    numberOfFloors=1;
    this.intendedUse=intendedUse;
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
   * Getter function for numberOfFloors
   * @return numberOfFloors
   */
  public int getNumberOfFloors()
  {
    return numberOfFloors;
  }

  /**
   * Setter function for numberOfFloors
   * @param numberOfFloors new value for numberOfFloors
   */
  public void setNumberOfFloors(int numberOfFloors)
  {
    if(numberOfFloors < 1) throw new InvalidValueException();
    this.numberOfFloors=numberOfFloors;
  }

  /**
   * Getter function for intendedUse
   * @return intendedUse
   */
  public String getIntendedUse()
  {
    return intendedUse;
  }

  /**
   * Overriding method "equals" for comparing 2 commercial project objects
   * @param obj object that is compared to this object
   * @return true if the objects equal each other, false otherwise
   */
  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
      return false;

    CommercialProject other=(CommercialProject) obj;

    return super.equals(other) &&
            size==other.size &&
            numberOfFloors==other.numberOfFloors &&
            intendedUse.equals(other.intendedUse);

  }

  /**
   * Overriding method "toString" for the commercial project objects
   * @return the values in the fields of this class as strings
   */
  public String toString()
  {
    return super.toString()+" "+size+" "+numberOfFloors+" "+intendedUse;
  }

}

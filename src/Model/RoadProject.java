package Model;

import Utils.InvalidValueException;

/**
 * The class that stores data for road projects
 * @author Group 2
 * @version 1.0
 */
public class RoadProject extends ConstructionProject
{
  private double length;
  private double width;
  private int numberOfBridges;
  private int environmentalChallenges;

  /**
   * Constructor for RoadProject class that requires all fields to be given
   * @param timeline expected timeline for project
   * @param budget expected budget for project
   * @param name the name of the project
   * @param status the status of the project
   * @param resource the resources needed for the project
   * @param id the id of the project
   * @param length the length of the road
   * @param width the width of the road
   * @param numberOfBridges the number of bridges along the road
   * @param environmentalChallenges the number of environmental
   */
  public RoadProject(int timeline, double budget, String name, String status,Resource resource ,
                      int id, double length, double width, int numberOfBridges, int environmentalChallenges)
  {
    super(timeline, budget,"road", name, status, resource, id);
    if(length < 0) throw new InvalidValueException();
    if(width < 0) throw new InvalidValueException();
    if(numberOfBridges < 0) throw new InvalidValueException();
    if(environmentalChallenges < 0) throw new InvalidValueException();
    this.length =length;
    this.width=width;
    this.numberOfBridges=numberOfBridges;
    this.environmentalChallenges =environmentalChallenges;

  }

  /**
   * Constructor for RoadProject class that fills the default values when possible
   * @param timeline expected timeline for project
   * @param budget expected budget for project
   * @param name the name of the project
   * @param status the status of the project
   * @param resource the resources needed for the project
   * @param id the id of the project
   * @param length the length of the road
   * @param width the width of the road
   */
  public RoadProject(int timeline, double budget, String name, String status,Resource resource ,
                      int id, double length, double width)
  {
    super(18, budget, "road", name, status, resource, id);
    if(length < 0) throw new InvalidValueException();
    if(width < 0) throw new InvalidValueException();
    this.length =length;
    this.width=width;
    numberOfBridges=0;
    environmentalChallenges =0;
  }

  /**
   * Getter function for length
   * @return length
   */
  public double getLength()
  {
    return length;
  }

  /**
   * Getter method for width
   * @return width
   */
  public double getWidth()
  {
    return width;
  }

  /**
   * Getter method for numberOfBridges
   * @return numberOfBridges
   */
  public int getNumberOfBridges()
  {
    return numberOfBridges;
  }

  /**
   * Getter method for environmentalChallenges
   * @return environmentalChallenges
   */
  public int getEnvironmentalChallenges()
  {
    return environmentalChallenges;
  }

  /**
   * Setter method for length
   * @param length new value dor length
   */
  public void setLength(double length)
  {
    if (length < 0) throw new InvalidValueException();
    this.length = length;
  }

  /**
   * Setter method for width
   * @param width new value for width
   */
  public void setWidth(double width)
  {
    if (width < 0) throw new InvalidValueException();
    this.width=width;
  }

  /**
   * Setter method for numberOfBridges
   * @param numberOfBridges new value for numberOfBridges
   */
  public void setNumberOfBridges(int numberOfBridges)
  {
    if (numberOfBridges < 0) throw new InvalidValueException();
    this.numberOfBridges=numberOfBridges;
  }

  /**
   * Setter method for environmentalChallenges
   * @param environmentalChallenges new value for environmentalChallenges
   */
  public void setEnvironmentalChallenges(int environmentalChallenges)
  {
    if(environmentalChallenges < 0) throw new InvalidValueException();
    this.environmentalChallenges = environmentalChallenges;
  }

  /**
   * Overriding method "equals" for comparing 2 road project objects
   * @param obj object that is compared to this object
   * @return true if the objects equal each other, false otherwise
   */
  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass()) return false;

    RoadProject other=(RoadProject) obj;

    return super.equals(other) &&
            length ==other.length &&
            width==other.width &&
            numberOfBridges==other.numberOfBridges &&
            environmentalChallenges ==other.environmentalChallenges;

  }

  /**
   * Overriding method "toString" for the road project objects
   * @return the values in the fields of this class as strings
   */
  public String toString()
  {
    return super.toString() + " " +
            length + " " +
            width + " " +
            numberOfBridges + " " +
            environmentalChallenges;
  }
}

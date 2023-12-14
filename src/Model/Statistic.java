package Model;

/**
 * The class that stores data for statistics
 * @author Group 2
 * @version 1.0
 */
public class Statistic
{
  private String projectType;
  private Double materialExpenses;
  private Double manHoursUsed;
  private Double expectedTotalHours;
  private Double expenses;

  /**
   * Constructor for Statistics class
   * @param projectType the type of the project
   * @param materialExpenses the material expenses average
   * @param manHoursUsed the man-hours used average
   * @param expectedTotalHours the expected total hours average
   * @param expenses the expenses average
   */
  public Statistic(String projectType, Double materialExpenses, Double manHoursUsed, Double expectedTotalHours, Double expenses)
  {
    this.projectType = projectType;
    this.materialExpenses = materialExpenses;
    this.manHoursUsed = manHoursUsed;
    this.expectedTotalHours = expectedTotalHours;
    this.expenses = expenses;
  }

  /**
   * Getter function for project type
   * @return the type of the project
   */
  public String getProjectType()
  {
    return projectType;
  }

  /**
   * Setter function for project type
   * @param projectType the type of the project
   */
  public void setProjectType(String projectType)
  {
    this.projectType = projectType;
  }

  /**
   * Getter function for material expenses
   * @return the average of material expenses
   */
  public Double getMaterialExpenses()
  {
    return materialExpenses;
  }

  /**
   * Setter function for material expenses
   * @param materialExpenses the average of material expenses
   */
  public void setMaterialExpenses(Double materialExpenses)
  {
    this.materialExpenses = materialExpenses;
  }

  /**
   * Getter function for man-hour used
   * @return the average of man-hours used
   */
  public Double getManHoursUsed()
  {
    return manHoursUsed;
  }

  /**
   * Setter function for man-hour used
   * @param manHoursUsed the average of man-hours used
   */
  public void setManHoursUsed(Double manHoursUsed)
  {
    this.manHoursUsed = manHoursUsed;
  }

  /**
   * Getter function for expected total hours
   * @return the average of expected total hours
   */
  public Double getExpectedTotalHours()
  {
    return expectedTotalHours;
  }

  /**
   * Setter function for expected total hours
   * @param expectedTotalHours the average of expected total hours
   */
  public void setExpectedTotalHours(Double expectedTotalHours)
  {
    this.expectedTotalHours = expectedTotalHours;
  }

  /**
   * Getter function for expenses
   * @return the average of expenses
   */
  public Double getExpenses()
  {
    return expenses;
  }

  /**
   * Setter function for expenses
   * @param expenses the average of expenses
   */
  public void setExpenses(Double expenses)
  {
    this.expenses = expenses;
  }
}

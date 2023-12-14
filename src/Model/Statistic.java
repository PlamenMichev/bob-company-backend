package Model;

public class Statistic
{
  private String projectType;
  private Double materialExpenses;
  private Double manHoursUsed;
  private Double expectedTotalHours;
  private Double expenses;

  public Statistic(String projectType, Double materialExpenses, Double manHoursUsed, Double expectedTotalHours, Double expenses)
  {
    this.projectType = projectType;
    this.materialExpenses = materialExpenses;
    this.manHoursUsed = manHoursUsed;
    this.expectedTotalHours = expectedTotalHours;
    this.expenses = expenses;
  }

  public String getProjectType()
  {
    return projectType;
  }

  public void setProjectType(String projectType)
  {
    this.projectType = projectType;
  }

  public Double getMaterialExpenses()
  {
    return materialExpenses;
  }

  public void setMaterialExpenses(Double materialExpenses)
  {
    this.materialExpenses = materialExpenses;
  }

  public Double getManHoursUsed()
  {
    return manHoursUsed;
  }

  public void setManHoursUsed(Double manHoursUsed)
  {
    this.manHoursUsed = manHoursUsed;
  }

  public Double getExpectedTotalHours()
  {
    return expectedTotalHours;
  }

  public void setExpectedTotalHours(Double expectedTotalHours)
  {
    this.expectedTotalHours = expectedTotalHours;
  }

  public Double getExpenses()
  {
    return expenses;
  }

  public void setExpenses(Double expenses)
  {
    this.expenses = expenses;
  }
}

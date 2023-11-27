package Model;

public class Resource
{
    private double materialExpenses;
    private double manHours;
    private double expectedTotalHours;
    private double expenses;
    public Resource(double materialExpenses, double manHours, double expectedTotalHours, double expenses)
    {
        this.materialExpenses = materialExpenses;
        this.manHours = manHours;
        this.expectedTotalHours = expectedTotalHours;
        this.expenses = expenses;
    }

    public void setMaterialExpenses(double materialExpenses) {
        this.materialExpenses = materialExpenses;
    }

    public double getMaterialExpenses() {
        return materialExpenses;
    }

    public void setManHours(double manHours) {
        this.manHours = manHours;
    }

    public double getManHours() {
        return manHours;
    }

    public void setExpectedTotalHours(double expectedTotalHours) {
        this.expectedTotalHours = expectedTotalHours;
    }

    public double getExpectedTotalHours() {
        return expectedTotalHours;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getExpenses() {
        return expenses;
    }
     public boolean equals(Object obj)
     {
         if(obj == null || obj.getClass() != getClass())
             return false;
         Resource resource = (Resource) obj;
         return materialExpenses == resource.materialExpenses &&
                 manHours == resource.manHours &&
                 expectedTotalHours == resource.expectedTotalHours &&
                 expenses == resource.expenses;
     }
     public String toString()
     {
         return "Material expenses: " + materialExpenses +
                 ", Man hours: " + manHours +
                 ", Expected total hours: " + expectedTotalHours +
                 ", Expenses: " + expenses;
     }
}

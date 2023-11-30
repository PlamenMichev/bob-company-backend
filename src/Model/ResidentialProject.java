package Model;

public class ResidentialProject extends ConstructionProject
{
    private double size;
    private int numberOfFloors;
    private int numberOfKitchens;
    private int numberOfBathrooms;
    private int roomsWithPlumbing;

    public ResidentialProject(int timeline, double budget,String type, String name,Resource resource, String status, int id , double size, int numberOfFloors, int numberOfKitchens
                                , int numberOfBathrooms, int roomsWithPlumbing)
    {
        super(timeline, budget, "residential", name,status, resource, id);
        this.size = size;
        this.numberOfFloors = numberOfFloors;
        this.numberOfKitchens = numberOfKitchens;
        this.numberOfBathrooms = numberOfBathrooms;
        this.roomsWithPlumbing = roomsWithPlumbing;

    }
    public ResidentialProject( int timeline, double budget, String type, String name, String status,Resource resource , int id, double size)
    {
        super(9, budget, "Residential", name,status, resource, id);
        this.size = size;
        this.numberOfFloors = 1;
        this.numberOfKitchens = 1;
        this.numberOfBathrooms = 1;
        this.roomsWithPlumbing = 1;


    }

    public double getSize() {
        return size;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfKitchens() {
        return numberOfKitchens;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public int getRoomsWithPlumbing() {
        return roomsWithPlumbing;
    }

    public String getStatus() {
        return status;
    }

    public boolean equals(Object obj)
    {
        if(obj == null || obj.getClass() != getClass())
            return false;

        ResidentialProject residentialProject = (ResidentialProject) obj;

        return super.equals(residentialProject) &&
                size == residentialProject.size &&
                numberOfFloors == residentialProject.numberOfFloors &&
                numberOfKitchens == residentialProject.numberOfKitchens &&
                numberOfBathrooms == residentialProject.numberOfBathrooms &&
                roomsWithPlumbing == residentialProject.roomsWithPlumbing &&
                status.equals(residentialProject.status);
    }

    public String toString()
    {
        return super.toString() +
                "\n Size: " + size +
                ", Number of floors: " + numberOfFloors +
                ", Number of kitchens: " + numberOfKitchens +
                ", Number of bathrooms: " + numberOfBathrooms +
                ", Number of rooms with plumbing: " + roomsWithPlumbing +
                ", Status: " + status;
    }
}

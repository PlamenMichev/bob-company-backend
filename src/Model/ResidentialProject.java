package Model;

import Util.InvalidValueException;

/**
 * The class that stores data for residential projects
 * @author Group 2
 * @version 1.0
 */
public class ResidentialProject extends ConstructionProject
{
    private double size;
    private int numberOfFloors;
    private int numberOfKitchens;
    private int numberOfBathrooms;
    private int roomsWithPlumbing;

    /**
     * Constructor for ResidentialProject class that requires all fields to be given
     * @param timeline expected timeline for project
     * @param budget expected budget for project
     * @param name the name of the project
     * @param resource the resources needed for the project
     * @param status the status of the project
     * @param id the id of the project
     * @param size the size of the project
     * @param numberOfFloors the number of floors of the building
     * @param numberOfKitchens the number of kitchens of the building
     * @param numberOfBathrooms the number of bathrooms of the building
     * @param roomsWithPlumbing the number of rooms with plumbing in the building
     */
    public ResidentialProject(int timeline, double budget, String name,Resource resource,
                              String status, int id , double size, int numberOfFloors, int numberOfKitchens,
                              int numberOfBathrooms, int roomsWithPlumbing)
    {
        super(timeline, budget, "residential", name,status, resource, id);
        if(size < 0) throw new InvalidValueException();
        if(numberOfFloors < 1) throw new InvalidValueException();
        if(numberOfKitchens < 1) throw new InvalidValueException();
        if(numberOfBathrooms < 1) throw new InvalidValueException();
        if(roomsWithPlumbing < 1) throw new InvalidValueException();
        this.size = size;
        this.numberOfFloors = numberOfFloors;
        this.numberOfKitchens = numberOfKitchens;
        this.numberOfBathrooms = numberOfBathrooms;
        this.roomsWithPlumbing = roomsWithPlumbing;

    }

    /**
     * Constructor for ResidentialProject class that fills the default values when possible
     * @param timeline expected timeline for project
     * @param budget expected budget for project
     * @param name the name of the project
     * @param status the status of the project
     * @param resource the resources needed for the project
     * @param id the id of the project
     * @param size the size of the project
     */
    public ResidentialProject( int timeline, double budget, String name,
                               String status,Resource resource , int id, double size)
    {
        super(9, budget, "Residential", name,status, resource, id);
        if(size < 0) throw new InvalidValueException();
        this.size = size;
        this.numberOfFloors = 1;
        this.numberOfKitchens = 1;
        this.numberOfBathrooms = 1;
        this.roomsWithPlumbing = 1;


    }

    /**
     * Getter function for size
     * @return size
     */
    public double getSize() {
        return size;
    }

    /**
     * Getter function for numberOfFloors
     * @return numberOfFloors
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Getter function for numberOfKitchens
     * @return numberOfKitchens
     */
    public int getNumberOfKitchens() {
        return numberOfKitchens;
    }

    /**
     * Getter function for numberOfBathrooms
     * @return numberOfBathrooms
     */
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    /**
     * Getter function for roomsWithPlumbing
     * @return roomsWithPlumbing
     */
    public int getRoomsWithPlumbing() {
        return roomsWithPlumbing;
    }

    /**
     * Overriding method "equals" for comparing 2 residential project objects
     * @param obj object that is compared to this object
     * @return true if the objects equal each other, false otherwise
     */
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
                roomsWithPlumbing == residentialProject.roomsWithPlumbing;
    }

    /**
     * Overriding method "toString" for the residential project objects
     * @return the values in the fields of this class as strings
     */
    public String toString()
    {
        return super.toString() +
                "\n Size: " + size +
                ", Number of floors: " + numberOfFloors +
                ", Number of kitchens: " + numberOfKitchens +
                ", Number of bathrooms: " + numberOfBathrooms +
                ", Number of rooms with plumbing: " + roomsWithPlumbing;
    }
}

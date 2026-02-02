/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author wakingstardust
 */
public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String vin;
    private int mileage;
    private Owner owner;
    private ArrayList<Service> services;
    
    public Vehicle() {
        services = new ArrayList<>();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        services.add(service);
    }
    
    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}

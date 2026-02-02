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
public class VehicleDirectory {
    private ArrayList<Vehicle> vehicles;
    
    public VehicleDirectory() {
        this.vehicles = new ArrayList<Vehicle>();
    }
    
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    
    public Vehicle addVehicle() {
        Vehicle v = new Vehicle();
        vehicles.add(v);
        return v;
    }
    
    public void deleteVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
    
    public Vehicle searchVehicle(String vin) {
        for (Vehicle v : vehicles) {
            if (v.getVin().contains(vin)) {
                return v;
            }
        }
        return null;
    }
}

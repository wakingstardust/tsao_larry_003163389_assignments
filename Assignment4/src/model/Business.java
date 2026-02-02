/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author wakingstardust
 */
public class Business {
    private String name;
    private VehicleDirectory vehicleDirectory;
    private ServiceCatalog serviceCatalog;
    
    public Business() {
        this.vehicleDirectory = new VehicleDirectory();
        this.serviceCatalog = new ServiceCatalog();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleDirectory getVehicleDirectory() {
        return vehicleDirectory;
    }

    public ServiceCatalog getServiceCatalog() {
        return serviceCatalog;
    }
    
}

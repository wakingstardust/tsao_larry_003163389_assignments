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
public class ServiceCatalog {
    private ArrayList<Service> services;
    
    public ServiceCatalog() {
        this.services = new ArrayList<Service>();
    }
    
    public ArrayList<Service> getServices() {
        return services;
    }
    
    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }
    
    public Service addService() {
        Service s = new Service();
        services.add(s);
        return s;
    }
    
    public void deleteService(Service service) {
        services.remove(service);
    }
    
    public Service searchService(String serviceName) {
        for (Service s : services) {
            if (s.getServiceName().contains(serviceName)) {
                return s;
            }
        }
        return null;
    }
}

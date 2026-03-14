/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness.Supplier;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.ProductManagement.Product;
import java.util.ArrayList;

/**
 *
 * @author wakingstardust
 */
public class SupplierSummary {
    
    Supplier supplier;
    int totalSales;
    int distinctCustomerCount;
    double loyaltyScore;
    double avgSpendingPerCustomer;
    double top5SalesScore;
    
    
    public String getSupplierName() {
        return supplier.getName();
    }

    public int getTotalSales() {
        return totalSales;
    }

    public double getLoyaltyScore() {
        return loyaltyScore;
    }

    public double getAvgSpendingPerCustomer() {
        return avgSpendingPerCustomer;
    }

    public double getTop5SalesScore() {
        return top5SalesScore;
    }
    
}

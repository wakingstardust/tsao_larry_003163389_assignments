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
    
    public SupplierSummary(Supplier s, ArrayList<CustomerProfile> allCustomers) {
        supplier = s;

        // Step 1: get this supplier's product list
        ArrayList<Product> supplierProducts = supplier.getProductCatalog().getProductList();

        // Step 2: calculate total sales by looping all products
        totalSales = 0;
        for (Product p : supplierProducts) {
            totalSales = totalSales + p.getSalesVolume();
        }

        // Step 3: find distinct customers and their spending on this supplier
        // We build a parallel list of spending amounts, one entry per distinct customer
        ArrayList<CustomerProfile> distinctCustomers = new ArrayList();
        ArrayList<Integer> spendingPerCustomer = new ArrayList();

        for (CustomerProfile cp : allCustomers) {
            int spendingForThisCustomer = 0;

            for (Order o : cp.getOrders()) {
                for (OrderItem oi : o.getOrderItems()) {
                    if (supplierProducts.contains(oi.getSelectedProduct())) {
                        spendingForThisCustomer = spendingForThisCustomer + oi.getOrderItemTotal();
                    }
                }
            }

            if (spendingForThisCustomer > 0) {
                distinctCustomers.add(cp);
                spendingPerCustomer.add(spendingForThisCustomer);
            }
        }

        distinctCustomerCount = distinctCustomers.size();

        // Step 4: loyalty score
        loyaltyScore = (double) distinctCustomerCount / allCustomers.size();

        // Step 5: average spending per customer
        if (distinctCustomerCount > 0) {
            avgSpendingPerCustomer = (double) totalSales / distinctCustomerCount;
        } else {
            avgSpendingPerCustomer = 0;
        }

        // Step 6: top 5 sales score
        // Sort spendingPerCustomer high to low using a simple loop swap
        for (int i = 0; i < spendingPerCustomer.size(); i++) {
            for (int j = i + 1; j < spendingPerCustomer.size(); j++) {
                if (spendingPerCustomer.get(j) > spendingPerCustomer.get(i)) {
                    int temp = spendingPerCustomer.get(i);
                    spendingPerCustomer.set(i, spendingPerCustomer.get(j));
                    spendingPerCustomer.set(j, temp);
                }
            }
        }

        // Add up the top 5 (or fewer if less than 5 distinct customers exist)
        int top5Total = 0;
        int limit = Math.min(5, spendingPerCustomer.size());
        for (int i = 0; i < limit; i++) {
            top5Total = top5Total + spendingPerCustomer.get(i);
        }

        if (totalSales > 0) {
            top5SalesScore = (double) top5Total / totalSales;
        } else {
            top5SalesScore = 0;
        }
    }
    
    
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

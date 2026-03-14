/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CustomersReport {
    ArrayList<CustomerSummary> customerlist;
    
    public CustomersReport(){
        customerlist = new ArrayList();
    }

    public void addCustomerSummary(CustomerSummary cs){
        customerlist.add(cs);
    }

    public ArrayList<CustomerSummary> getSortedList(){
        for (int i = 0; i < customerlist.size(); i++){
            for (int j = i + 1; j < customerlist.size(); j++){
                if (customerlist.get(j).getTotalSales() > customerlist.get(i).getTotalSales()){
                    CustomerSummary temp = customerlist.get(i);
                    customerlist.set(i, customerlist.get(j));
                    customerlist.set(j, temp);
                }
            }
        }
        return customerlist;
    }
}

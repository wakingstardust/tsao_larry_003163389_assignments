/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness.Supplier;

import java.util.ArrayList;


/**
 *
 * @author wakingstardust
 */
public class SupplierReport {
    
    ArrayList<SupplierSummary> supplierlist;

    public SupplierReport() {
        supplierlist = new ArrayList();
    }

    public void addSupplierSummary(SupplierSummary ss) {
        supplierlist.add(ss);
    }

    public ArrayList<SupplierSummary> getSupplierList() {
        return supplierlist;
    }
    
}

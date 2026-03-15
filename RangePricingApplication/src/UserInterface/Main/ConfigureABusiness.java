/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Xerox");

        PersonDirectory persondirectory = business.getPersonDirectory();
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");

        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);

        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua1 = uadirectory.newUserAccount(salespersonprofile, "Sales", "XXXX");
        UserAccount ua2 = uadirectory.newUserAccount(marketingpersonprofile0, "Marketing", "XXXX");

        CustomerDirectory customerdirectory = business.getCustomerDirectory();
        ArrayList<CustomerProfile> allCustomers = new ArrayList();
        for (int i = 1; i <= 300; i++) {
            Person person = persondirectory.newPerson("Customer " + i);
            CustomerProfile cp = customerdirectory.newCustomerProfile(person);
            allCustomers.add(cp);
        }

        SupplierDirectory supplierdirectory = business.getSupplierDirectory();
        ArrayList<Product> allProducts = new ArrayList();

        for (int i = 1; i <= 50; i++) {
            Supplier supplier = supplierdirectory.newSupplier("Supplier " + i);

            if (i <= 30) {
                ProductCatalog catalog = supplier.getProductCatalog();
                for (int j = 1; j <= 50; j++) {
                    String productName = "Product " + i + "-" + j;
                    int floorPrice = 1000 + (int)(Math.random() * 1000);
                    int ceilingPrice = floorPrice + 1000 + (int)(Math.random() * 2000);
                    int targetPrice = floorPrice + (int)((ceilingPrice - floorPrice) / 2);
                    Product p = catalog.newProduct(productName, floorPrice, ceilingPrice, targetPrice);
                    allProducts.add(p);
                }
            }
        }

        MasterOrderList masterorderlist = business.getMasterOrderList();

        for (CustomerProfile cp : allCustomers) {
            int numberOfOrders = 1 + (int)(Math.random() * 3);
            for (int o = 0; o < numberOfOrders; o++) {
                Order order = masterorderlist.newOrder(cp, salespersonprofile);
                int numberOfItems = 1 + (int)(Math.random() * 10);
                for (int k = 0; k < numberOfItems; k++) {
                    Product p = allProducts.get((int)(Math.random() * allProducts.size()));
                    int actualPrice = p.getFloorPrice() + (int)(Math.random() * (p.getCeilingPrice() - p.getFloorPrice()));
                    order.newOrderItem(p, actualPrice, 1);
                }
            }
        }

        return business;
    }
}

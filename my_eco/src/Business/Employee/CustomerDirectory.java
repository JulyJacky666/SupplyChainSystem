/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author amber
 */
public class CustomerDirectory {
    private ArrayList<Customer> customers;
    
    public CustomerDirectory() {
        customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerDict() {
        return customers;
    }
    
    public Customer addCustomer() {
        Customer s = new Customer();
        customers.add(s);
        return s;
    }
    
    public void removeCustomer(Customer s) {
        customers.remove(s);
    }
    
    public Customer searchAirliners(String keyWord) {
        for(Customer s : customers) {
            if(keyWord.equals(s.getName())) {
                return s;
            }
        }
        return null;
    }
}

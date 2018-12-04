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
    private ArrayList<Customer> CustomerDict;
    
    public CustomerDirectory() {
        CustomerDict = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerDict() {
        return CustomerDict;
    }
    
    public Customer addCustomer() {
        Customer s = new Customer();
        CustomerDict.add(s);
        return s;
    }
    
    public void removeCustomer(Customer s) {
        CustomerDict.remove(s);
    }
    
    public Customer searchAirliners(String keyWord) {
        for(Customer s : CustomerDict) {
            if(keyWord.equals(s.getName())) {
                return s;
            }
        }
        return null;
    }
}

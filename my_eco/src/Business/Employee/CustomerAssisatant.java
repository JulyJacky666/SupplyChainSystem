/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author keweiji
 */
public class CustomerAssisatant extends Employee{
    private ArrayList<Customer> servedCustomer;
    private int servedcounts;
        public CustomerAssisatant(String name){
        super(name, 2);
        this.servedCustomer = new ArrayList<Customer>();
        servedcounts=0;
    }

    public int getServedcounts() {
        return servedcounts;
    }

    public void setServedcounts(int servedcounts) {
        this.servedcounts = servedcounts;
    }
        

    public ArrayList<Customer> getServedCustomer() {
        return servedCustomer;
    }

    public void setServedCustomer(ArrayList<Customer> servedCustomer) {
        this.servedCustomer = servedCustomer;
    }
    
}

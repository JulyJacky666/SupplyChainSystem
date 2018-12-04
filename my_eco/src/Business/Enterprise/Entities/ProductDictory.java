/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Employee.Customer;
import java.util.ArrayList;

/**
 *
 * @author amber
 */
public class ProductDictory {
    private ArrayList<Product> productsDict;
    
    public ProductDictory() {
        productsDict = new ArrayList<Product>();
    }

    public ArrayList<Product> getProductsDict() {
        return productsDict;
    }
    
    public Product addProduct() {
        Product p = new Product();
        productsDict.add(p);
        return p;
    }
    
    public void removeProduct(Product p) {
        productsDict.remove(p);
    }
    
}

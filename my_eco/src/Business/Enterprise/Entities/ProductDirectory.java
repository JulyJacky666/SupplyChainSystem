/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Employee.Customer;
import java.util.ArrayList;
import Business.Enterprise.Entities.MaterialDirectory;
/**
 *
 * @author amber
 */
public class ProductDirectory {
    private ArrayList<Product> productsDict;
    
    public ProductDirectory() {
        productsDict = new ArrayList<Product>();
//        productsDict.add(new Product(Product.ProductType.Bike,  materialDirectory));
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

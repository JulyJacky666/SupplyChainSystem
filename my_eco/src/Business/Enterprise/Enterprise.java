/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Entities.Factory;
import Business.Enterprise.Entities.ProductDictory;
import Business.Enterprise.Entities.Warehouse;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author maibenben
 */
public abstract class Enterprise extends Organization{
    
     private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private Warehouse warehouse ;
    private EmployeeDirectory topemployeeDirectory;
    private ProductDictory productDictory;

    public ProductDictory getProductDictory() {
        return productDictory;
    }

    public void setProductDictory(ProductDictory productDictory) {
        this.productDictory = productDictory;
    }

        public Enterprise(String name,EnterpriseType type){
        super(name);
        this.enterpriseType=type;
        organizationDirectory=new OrganizationDirectory();
        warehouse=new Warehouse("");
        topemployeeDirectory =new EmployeeDirectory();
        productDictory = new ProductDictory();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    public enum EnterpriseType{
        SalesEnterprise("Sales Enterprise"),
        SupplierEnterprise("Supplier Enterprise"),
        ManufactureEnterprise("Manufacture Enterprise");
        
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
        return value;
    }
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public EmployeeDirectory getTopemployeeDirectory() {
        return topemployeeDirectory;
    }

    public void setTopemployeeDirectory(EmployeeDirectory topemployeeDirectory) {
        this.topemployeeDirectory = topemployeeDirectory;
    }
    

    
}

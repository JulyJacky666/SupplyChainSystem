/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Area.Area;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author maibenben
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Area> areaList;
    private HashMap<ManufactureEnterprise,String> allManufactureEnterprises; //String only record which area this enterprise belongs to
    private HashMap<SalesEnterprise,String> allSalesEnterprises;
    private HashMap<SupplierEnterprise,String> allSupplierEnterprises; 

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public Area createAndAddArea() {
        Area area = new Area();
        areaList.add(area);
        return area;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    private EcoSystem() {
        super(null);
        areaList = new ArrayList<Area>();
        allManufactureEnterprises = new HashMap<ManufactureEnterprise,String>();
        allSalesEnterprises = new HashMap<SalesEnterprise,String>();
        allSupplierEnterprises = new HashMap<SupplierEnterprise,String>();
    }

//    public ArrayList<Area> getAreaList() {
//        return areaList;
//    }
//
//    public void setAreaList(ArrayList<Area> areaList) {
//        this.areaList = areaList;
//    }

    public HashMap<ManufactureEnterprise, String> getAllManufactureEnterprises() {
        return allManufactureEnterprises;
    }

    public void setAllManufactureEnterprises(HashMap<ManufactureEnterprise, String> allManufactureEnterprises) {
        this.allManufactureEnterprises = allManufactureEnterprises;
    }

    public HashMap<SalesEnterprise, String> getAllSalesEnterprises() {
        return allSalesEnterprises;
    }

    public void setAllSalesEnterprises(HashMap<SalesEnterprise, String> allSalesEnterprises) {
        this.allSalesEnterprises = allSalesEnterprises;
    }

    public HashMap<SupplierEnterprise, String> getAllSupplierEnterprises() {
        return allSupplierEnterprises;
    }

    public void setAllSupplierEnterprises(HashMap<SupplierEnterprise, String> allSupplierEnterprises) {
        this.allSupplierEnterprises = allSupplierEnterprises;
    }
    
    

    public ArrayList<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(ArrayList<Area> arealist) {
        this.areaList = arealist;
    }

    public boolean checkIfUserIsUnique(String userName) {
        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            return false;
        }
        for (Area area : areaList) {

        }
        return true;
    }
}

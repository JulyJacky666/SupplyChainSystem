/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Area.Area;
import Business.Enterprise.Entities.ManufactureTask;
import Business.Enterprise.Entities.MaterialDirectory;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

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
    private MaterialDirectory materialDirectory;

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
        materialDirectory = new MaterialDirectory();
//        flushall();
    }
    
    
        public void flushall() {
        //flush the system every 10 seconds
        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flushManufacturetask();
                System.out.println("20s");
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

    }
        
        

    public void flushManufacturetask() {
        
    for(ManufactureEnterprise manufactureEnterprise:this.allManufactureEnterprises.keySet()){
                for (ManufactureTask task : manufactureEnterprise.getManufactureTasksdirectory()) {
            if (task.getCompleted() == false && task.getTimeremains() > 0) {
                long diff = new Date().getTime() - task.getCreatedtimeDate().getTime();
                if (TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS) == 1) {
                    task.setHasexperincedDays(task.getHasexperincedDays() + 1);
                    task.calculateTimeRemains();
                }
//            System.out.println("seconds: " + TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS));
            }
        }
    }

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

    public MaterialDirectory getMaterialDirectory() {
        return materialDirectory;
    }

    public void setMaterialDirectory(MaterialDirectory materialDirectory) {
        this.materialDirectory = materialDirectory;
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

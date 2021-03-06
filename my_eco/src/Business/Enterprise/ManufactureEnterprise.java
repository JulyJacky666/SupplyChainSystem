/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Entities.Buyorder;
import Business.Enterprise.Entities.Factory;
import Business.Enterprise.Entities.ManufactureTask;
import Business.Enterprise.Entities.Material;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.SalesOrder;
import Business.Role.Role;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

/**
 *
 * @author keweiji
 */
public class ManufactureEnterprise extends Enterprise {

    private ArrayList<SalesOrder> receivedOrders;
    private ArrayList<ManufactureTask> manufactureTasksdirectory;
    private ArrayList<Buyorder> buyOrdersdirectory;
    private Factory factory;
    private HashMap<Material, Integer> todomaterialHashMap;
    private ArrayList<ManufactureTask> needMaterialTasks;
    private HashMap<Product, Integer> returnedProductHashMap;
    private int delivertime;

    public ManufactureEnterprise(String name) {
        super(name, EnterpriseType.ManufactureEnterprise);
        this.factory = new Factory();
        receivedOrders = new ArrayList<SalesOrder>();
        todomaterialHashMap = new HashMap<Material, Integer>();
        manufactureTasksdirectory = new ArrayList<ManufactureTask>();
        buyOrdersdirectory = new ArrayList<Buyorder>();
        delivertime = (int) (Math.random() * 4 + 1);
        needMaterialTasks = new ArrayList<ManufactureTask>();
        returnedProductHashMap = new HashMap<Product, Integer>();
//        flushall();
    }

    public ArrayList<SalesOrder> getReceivedOrders() {
        return receivedOrders;
    }

    public void setReceivedOrders(ArrayList<SalesOrder> receivedOrders) {
        this.receivedOrders = receivedOrders;
    }

    public HashMap<Material, Integer> getTodomaterialHashMap() {
        return todomaterialHashMap;
    }

    public HashMap<Product, Integer> getReturnedProductHashMap() {
        return returnedProductHashMap;
    }

    public void setReturnedProductHashMap(HashMap<Product, Integer> returnedProductHashMap) {
        this.returnedProductHashMap = returnedProductHashMap;
    }
    

    public void setTodomaterialHashMap(HashMap<Material, Integer> todomaterialHashMap) {
        this.todomaterialHashMap = todomaterialHashMap;
    }

    public ArrayList<ManufactureTask> getManufactureTasksdirectory() {
        return manufactureTasksdirectory;
    }

    public ArrayList<ManufactureTask> getNeedMaterialTasks() {
        return needMaterialTasks;
    }

    public void setNeedMaterialTasks(ArrayList<ManufactureTask> needMaterialTasks) {
        this.needMaterialTasks = needMaterialTasks;
    }

    public void setManufactureTasksdirectory(ArrayList<ManufactureTask> manufactureTasksdirectory) {
        this.manufactureTasksdirectory = manufactureTasksdirectory;
    }

    public int getDelivertime() {
        return delivertime;
    }

    public void setDelivertime(int delivertime) {
        this.delivertime = delivertime;
    }

    public void addManufactureTask(SalesOrder salesorder) {
        HashMap<Product, Integer> warehouseProduct = this.getWarehouse().getAvaliableProductsHashMap();
        HashMap<Product, Integer> orderItems = salesorder.getItems();
        HashMap<Product, Integer> tasks = new HashMap<Product, Integer>();

        for (Product product : orderItems.keySet()) {
            if (warehouseProduct.containsKey(product)) {

                if (orderItems.get(product) < warehouseProduct.get(product)) {
                    tasks.put(product, orderItems.get(product));
                } else {
                    tasks.put(product, orderItems.get(product) - warehouseProduct.get(product));
                }
            } else {
                tasks.put(product, orderItems.get(product));
            }

        }

        for (Product product : tasks.keySet()) {
            ManufactureTask manufactureTask = new ManufactureTask(tasks.get(product), product);
            this.manufactureTasksdirectory.add(manufactureTask);
            manufactureTask.setTaskid((int)(Math.random()*1000));
        }
    }

    public void flushall() {
        //flush the system every 20 seconds
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
        for (ManufactureTask task : this.manufactureTasksdirectory) {
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

    public ArrayList<Buyorder> getBuyOrdersdirectory() {
        return buyOrdersdirectory;
    }

    public void setBuyOrdersdirectory(ArrayList<Buyorder> buyOrdersdirectory) {
        this.buyOrdersdirectory = buyOrdersdirectory;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}

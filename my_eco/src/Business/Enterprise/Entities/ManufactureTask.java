/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Employee.Worker;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author keweiji
 */
public class ManufactureTask {
    
    private static  int taskcounts=1;
    private  int taskid;
    private int counts;
    private int orderid;
    private ArrayList<Worker> menTakePartIn;
    private Product product;
    private Boolean excuted;
    private Boolean completed;
    private int hasexperincedDays;
    private double timeremains;
    private Date createdtimeDate;
    
    
    public ManufactureTask(int counts, Product product){
        this.taskid=taskcounts;
        this.counts = counts;
        this.product = product;
        this.excuted = false;
        this.completed = false;
        this.hasexperincedDays = 0;
        this.timeremains = Integer.MAX_VALUE;
        this.createdtimeDate = null;
        this.menTakePartIn = new ArrayList<Worker>();
        taskcounts++;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }
    
    public double calculateTimeRemains(){
        double totaltime = this.product.getAssembletime() * this.getCounts() / this.getMenTakePartIn().size();
        double remains = totaltime - this.hasexperincedDays;
        this.setTimeremains(remains);
        return remains;
    }
    public double getTimeremains() {
        return timeremains;
    }

    public void setTimeremains(double timeremains) {
        this.timeremains = timeremains;
    }
    

    public int getHasexperincedDays() {
        return hasexperincedDays;
    }

    public void setHasexperincedDays(int hasexperincedDays) {
        this.hasexperincedDays = hasexperincedDays;
    }
    
    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getStatus() {
        return excuted;
    }

    public void setStatus(Boolean status) {
        this.excuted = status;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public ArrayList<Worker> getMenTakePartIn() {
        return menTakePartIn;
    }

    public void setMenTakePartIn(ArrayList<Worker> menTakePartIn) {
        this.menTakePartIn = menTakePartIn;
    }
    

    public Boolean getExcuted() {
        return excuted;
    }

    public void setExcuted(Boolean excuted) {
        this.excuted = excuted;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedtimeDate() {
        return createdtimeDate;
    }

    public void setCreatedtimeDate(Date createdtimeDate) {
        this.createdtimeDate = createdtimeDate;
    }
    
    
    @Override
    public String toString(){
        return String.valueOf(this.getOrderid());
    }
    
    
}

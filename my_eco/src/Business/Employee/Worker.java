/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Enterprise.Entities.LeaveRequest;
import Business.Enterprise.Entities.ManufactureTask;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.jar.Attributes;

/**
 *
 * @author maibenben
 */
public class Worker extends Employee {

//    public Worker(String name, 1){
//
//    }
//    private HashMap<Integer,>
    private ArrayList<ManufactureTask> taskList;
    private ArrayList<LeaveRequest> leaverequestsList;
    private int absensetime=Integer.MAX_VALUE;
    private int returnTime = 0;
    private boolean  isOnVacation;
    private boolean workable;
    private Date offstartDate;

    public Worker(String name) {
        super(name, 6);
        taskList = new ArrayList<ManufactureTask>();
        leaverequestsList = new ArrayList<LeaveRequest>();
        workable = true;
        isOnVacation=false;
    }

    public ArrayList<LeaveRequest> getLeaverequestsList() {
        return leaverequestsList;
    }

    public void setLeaverequestsList(ArrayList<LeaveRequest> leaverequestsList) {
        this.leaverequestsList = leaverequestsList;
    }

    public boolean isWorkable() {
        return workable;
    }

    public void setWorkable(boolean workable) {
        this.workable = workable;
    }

    public ArrayList<ManufactureTask> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<ManufactureTask> taskList) {
        this.taskList = taskList;
    }

    public boolean isIsOnVacation() {
        return isOnVacation;
    }

    public void setIsOnVacation(boolean isOnVacation) {
        this.isOnVacation = isOnVacation;
    }

    public Date getOffstartDate() {
        return offstartDate;
    }

    public void setOffstartDate(Date offstartDate) {
        this.offstartDate = offstartDate;
    }
    

    public int getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(int absense) {
        this.returnTime = absense;
    }

    public void offworkdays(int num) {
        this.setReturnTime(returnTime + num);
    }

    public int getAbsensetime() {
        return absensetime;
    }

    public void setAbsensetime(int absensetime) {
        this.absensetime = absensetime;
    }
    

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }

}

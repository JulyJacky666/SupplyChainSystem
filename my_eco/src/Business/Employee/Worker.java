/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Enterprise.Entities.LeaveRequest;
import Business.Enterprise.Entities.ManufactureTask;
import java.util.ArrayList;
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
    private int absense = 0;
    private boolean workable;

    public Worker(String name) {
        super(name, 4);
        taskList = new ArrayList<ManufactureTask>();
        leaverequestsList = new ArrayList<LeaveRequest>();
        workable = true;
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

    public int getAbsense() {
        return absense;
    }

    public void setAbsense(int absense) {
        this.absense = absense;
    }

    public void offworkdays(int num) {
        this.setAbsense(absense + num);
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }

}

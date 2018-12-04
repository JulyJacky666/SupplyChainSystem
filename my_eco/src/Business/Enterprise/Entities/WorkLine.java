/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Employee.Employee;
import Business.Employee.Worker;
import java.util.ArrayList;

/**
 *
 * @author maibenben
 */
public class WorkLine {
//    private String name;
    private int linenumber;
    private int capcity;
    private ArrayList<Worker> workersArrayList;
    
    public WorkLine(int number ){
        this.linenumber=number;
//        this.name = name;
        this.capcity = 3;
        this.workersArrayList = new ArrayList<Worker>();         
    }

    public int getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(int linenumber) {
        this.linenumber = linenumber;
    }

    public int getCapcity() {
        return capcity;
    }

    public void setCapcity(int capcity) {
        this.capcity = capcity;
    }

    public ArrayList<Worker> getWorkersArrayList() {
        return workersArrayList;
    }

    public void setWorkersArrayList(ArrayList<Worker> workersArrayList) {
        this.workersArrayList = workersArrayList;
    }
    
    
    public void addworker(Worker Worker){
        if(this.workersArrayList.size()<this.capcity){
            this.workersArrayList.add(Worker);
        }
    }
    @Override
    public String toString(){
        return "line "+String.valueOf(this.getLinenumber());
    }
    
}

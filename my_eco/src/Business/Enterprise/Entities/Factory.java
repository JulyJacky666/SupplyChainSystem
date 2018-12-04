/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import java.util.ArrayList;

/**
 *
 * @author keweiji
 */
public class Factory {
    private String name;
    private ArrayList<WorkLine> worklines;
    
    public Factory(){
        this.name = "";
        this.worklines = new ArrayList<WorkLine> ();
        adddefaultline();
    }
    
    public void adddefaultline(){
        for(int i =0; i<=2;i++){
            WorkLine line = new WorkLine(i);
            worklines.add(line);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WorkLine> getWorklines() {
        return worklines;
    }

    public void setWorklines(ArrayList<WorkLine> worklines) {
        this.worklines = worklines;
    }
    

}

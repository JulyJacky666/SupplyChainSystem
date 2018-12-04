/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Role.Role;

/**
 *
 * @author maibenben
 */
public  abstract class Employee {

    private String name;
    private int id;
    private static int count = 1;
    private int rolenumber;
//    public abstract  int role;

    public Employee(String name, int rolenumber) {
        this.name = name;
        this.rolenumber = rolenumber;
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }

    public int getRolenumber() {
        return rolenumber;
    }

    public void setRolenumber(int rolenumber) {
        this.rolenumber = rolenumber;
    }
    
    public String getHardRole(){
        int rolenumber= this.getRolenumber();
        String hardroleString="";
        switch(rolenumber){
            case 4:
                hardroleString="Worker";
                break;
                
            case 5:
                hardroleString="Manu. Director";
                break;
                
            case 6:
                hardroleString="Sales&Buy Director";
                break;
            case 3:
                hardroleString="Buyer";
                break;
                
            case 2:
                hardroleString="Salesman";
                break;
        }
        return hardroleString;
    }
    
    
        public String getHardOrg(){
        int rolenumber= this.getRolenumber();
        String hardorgString="";
        if(rolenumber ==4 || rolenumber ==5){
            hardorgString="Manufacture";
        }else{
             hardorgString="Buys&Sales";
        }
//        switch(rolenumber){
//            case 4  | 5:
//                hardorgString="Manufacture";
//                break;
//            case 3 & 2:
//                hardorgString="Buys&Sales";
//                break;
//        }
        return hardorgString;
    }

    @Override
    public String toString() {
        return name;
    }

}

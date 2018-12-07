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
public abstract class Employee {

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

    public String getHardRole() {
        int rolenumber = this.getRolenumber();
        String hardroleString = "";
        switch (rolenumber) {
            case 2:
                hardroleString = "Customer Assistant";
                break;
            case 3:
                hardroleString = "Customer Service Director";
                break;
            case 4:
                hardroleString = "Sales Man";
                break;
            case 5:
                hardroleString = "Sales Organization Director";
                break;
            case 6:
                hardroleString = "Worker";
                break;
            case 7:
                hardroleString = "Production Director";
                break;
            case 8:
                hardroleString = "Buyer";
                break;
            case 9:
                hardroleString = "Purchase Director";
                break;
            case 10:
                hardroleString = "Warehouse Keeper";
                break;
            case 11:
                hardroleString = "Warehouse Director";
                break;
            case 12:
                hardroleString = "Driver";
                break;
            case 13:
                hardroleString = "Delivery Director";
                break;

        }
        return hardroleString;
    }

    public String getHardOrg() {
        int rolenumber = this.getRolenumber();
        String hardorgString = "";
        if (rolenumber == 2 || rolenumber == 3) {
            hardorgString = "Customer Service";
        }
        if (rolenumber == 4 || rolenumber == 5) {
            hardorgString = "Sales Organization";
        }
        if (rolenumber == 6 || rolenumber == 7) {
            hardorgString = "Production Organization";
        }
        if (rolenumber == 8 || rolenumber == 9) {
            hardorgString = "Purchase Organization";
        }
        if (rolenumber == 10 || rolenumber == 11) {
            hardorgString = "Warehouse Organization";
        }
        if (rolenumber == 12 || rolenumber == 13) {
            hardorgString = "Delivery Organization";
        }
        return hardorgString;
    }

    @Override
    public String toString() {
        return name;
    }

}

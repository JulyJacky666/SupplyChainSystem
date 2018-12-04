/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author maibenben
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(String name, int rolenumber) {
        Employee employee = null;
        switch (rolenumber) {
            case 1:
                employee = new Manager(name);
                break;
            case 2:
                employee = new Salesman(name);
                break;
            case 3:
                employee = new Buyer(name);
                break;

            case 4:
                employee = new Worker(name);
                break;

            case 5:
                employee = new ManufactureDirector(name);
                break;
            case 6:
                employee  = new SalesAndBuyDirector(name);
                break;

        }

        employeeList.add(employee);
        return employee;

//        Employee employee = new Employee(name, rolenumber);
//        employee.setName(name);
//        employeeList.add(employee);
//        return employee;
    }

    public ArrayList<Worker> getworkerArrayList() {
        ArrayList<Worker> workers = new ArrayList<Worker>();
        ArrayList<Employee> employees = this.getEmployeeList();
        if (!employees.isEmpty()) {
            for (Employee e : employees) {
                if (e instanceof  Worker) {
                    workers.add((Worker) e);
                }
            }
        }

        return workers;
    }

    public ArrayList<Buyer> getbuyerArrayList() {
        ArrayList<Buyer> buyers = new ArrayList<Buyer>();
        for (Employee e : this.getEmployeeList()) {
            if (e.getRolenumber() == 3) {
                buyers.add((Buyer) e);
            }
        }
        return buyers;
    }

    public ArrayList<Salesman> getsalesmanArrayList() {
        ArrayList<Salesman> salesmen = new ArrayList<Salesman>();
        for (Employee e : this.getEmployeeList()) {
            if (e.getRolenumber() == 2) {
                salesmen.add((Salesman) e);
            }
        }
        return salesmen;
    }

    public ArrayList<Employee> getmanagerArrayList() {
        ArrayList<Employee> maganers = new ArrayList<Employee>();
        for (Employee e : this.getEmployeeList()) {
            if (e.getRolenumber() == 1) {
                maganers.add(e);
            }
        }
        return maganers;
    }

}

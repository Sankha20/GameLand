/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;


public class Employee extends Person{

    int job;
    int sales;
    String id;
    
    public Employee(String name) {
        super(name);
        this.job = job;
        this.sales = sales;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getJob() {
        return job;
    }

    public int getSales() {
        return sales;
    }
    
}

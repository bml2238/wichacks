package mechanics;

import java.util.ArrayList;
import java.util.Map;

public class Business {
    private int employeenumber;//can just use employees.size();
    private int businessFunds;
    private int level;
    private int lvllimit;
    private int exp;
    private double genderratio;
    private ArrayList<Employee> employees;

    public Business()
    {
        this.employees = new ArrayList<>();
    }

    public enum action
    {
        HIRE,
        FIRE,
        ADVERTISE,
        VIEW,
        GETINVESTMENTS
    }

    public void payEmployee()
    {
        for(Employee e: employees)
        {
            businessFunds -= e.getSalary();
        }
    }

    public void workEmployees()
    {
        for(Employee e: employees)
        {
            businessFunds += e.getSatisfaction() * e.getWorkpoints();
            exp += 10;
        }
    }

    public void hireEmployee(Employee emp)
    {
        employees.add(emp);
        businessFunds -= emp.getSalary();
        calculateRatio();
    }

    public void fireEmployee(Employee emp)
    {
        employees.remove(emp);
    }

    public void advertise()
    {
        exp += 200;
    }

    public void changeBusinessFunds(int amount){
        this.businessFunds += amount;
    }

    public void lvlup()
    {
        if(exp % lvllimit == 0)
        {
            this.level++;
            lvllimit += 1000;
            exp = 0;
        }
    }

    public int getLevel()
    {
        return this.level;
    }

    public void calculateRatio()
    {
        double females = 0.0;
        for(Employee e: employees)
        {
            if(e.getGender().equals("female"))
            {
                females++;
            }
        }
        this.genderratio = females/employees.size();
    }

    public double getRatio()
    {
        return genderratio;
    }


}

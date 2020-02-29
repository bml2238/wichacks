package game;

import java.util.ArrayList;

public class Employee {
    private String name;
    private int satisfaction = 50;
    private String desc;
    private int rating;
    private int salary;
    private int workpoints;
    private static ArrayList<String> situations;

    public Employee(String name, int salary, String desc, int rating, int workpoints)
    {
        this.name = name;
        this.salary = salary;
        this.desc = desc;
        this.rating = rating;
        this.workpoints = workpoints;
    }

    public String getName()
    {
        return this.name;
    }

    public int getSatisfaction()
    {
        return this.satisfaction;
    }

    public String getDesc()
    {
        return this.desc;
    }

    public int getSalary()
    {
        return this.salary;
    }

    public int getWorkpoints()
    {
        return this.workpoints;
    }

    public void changeSatisfaction(int changeby)
    {
        this.satisfaction += changeby;
    }
}

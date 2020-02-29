package game;

import java.util.ArrayList;

public class Employee {
    private String name;
    private int satisfaction;
    private String desc;
    private int rating;
    private int salary;
    private int workpoints;
    private static ArrayList<String> situations;

    public Employee(String name, int sat)
    {
        this.name = name;
        this.satisfaction = sat;
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
}

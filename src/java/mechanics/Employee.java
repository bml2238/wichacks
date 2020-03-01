package mechanics;

import java.util.ArrayList;

public class Employee {
    private String name = "Name";
    private int satisfaction = 50;
    private String desc = "desc";
    private int rating;
    private int salary;
    private int workPoints;
    //private static ArrayList<String> situations;
    private String gender = "female";
    private int age;
    private int level = 1;

    public Employee(String name, String gender, String desc, int level)
    {
        this.name = name;
        this.gender = gender;
        this.desc = desc;
        this.level = level;
        this.age = (int)(Math.random()*((30 - 20) + 1))*level;
        this.salary = (int)(Math.random()*((1000 - 300) + 1))*level;
        this.rating = (int)(Math.random()*((10 - 1) + 1));
        this.workPoints = (int)(Math.random()*((1000 - 300) + 1));
    }

    public String getName()
    {
        return this.name;
    }

    public String getGender()
    {
        return this.gender;
    }

    public int getSatisfaction()
    {
        return this.satisfaction;
    }

    public String getDesc()
    {
        return this.desc;
    }

    public int getAge()
    { return this.age;
    }

    public int getSalary()
    {
        return this.salary;
    }

    public int getWorkPoints()
    {
        return this.workPoints;
    }

    public void changeSatisfaction(int changeby)
    {
        this.satisfaction += changeby;
    }
}

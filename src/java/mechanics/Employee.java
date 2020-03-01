package mechanics;

import java.util.ArrayList;

public class Employee {
    private String name;
    private int satisfaction = 50;
    private String desc;
    private int rating;
    private int salary;
    private int workpoints;
    private static ArrayList<String> situations;
    private String gender;
    private int age;

    public Employee(String name, String gender, String desc, int level)
    {
        this.gender = gender;
        this.name = name;
        this.age = (int)(Math.random()*((30 - 20) + 1))*level;
        this.salary = (int)(Math.random()*((1000 - 300) + 1))*level;
        this.desc = desc;
        this.rating = (int)(Math.random()*((10 - 1) + 1));
        this.workpoints = (int)(Math.random()*((1000 - 300) + 1));
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

    public int getWorkpoints()
    {
        return this.workpoints;
    }

    public void changeSatisfaction(int changeby)
    {
        this.satisfaction += changeby;
    }
}

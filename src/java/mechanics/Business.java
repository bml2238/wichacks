package mechanics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Business {
    private Scanner takenames;
    private int businessFunds;
    private int level;
    private int lvllimit;
    private int exp;
    private double genderratio;
    private ArrayList<Employee> employees;
    private ArrayList<Employee> allpossible;
    private Type type;

    public Business(Business.Type type)
    {
        this.employees = new ArrayList<>();
        this.type = type;
    }

    public enum Type
    {
        TECHNOLOGY,
        ARTIST,
        POLITICIAN
    }

    public enum action
    {
        HIRE,
        FIRE,
        ADVERTISE,
        VIEW,
        GET_INVESTMENTS,
        TIME_PASSES
    }

    public void buildAllPossibleEmployees() throws FileNotFoundException {
            if(level > 3)
            {
                this.takenames = new Scanner(new File("data/employeeslvl5.txt"));
            }
            else
            {
                this.takenames = new Scanner(new File("data/employeeslvl1.txt"));
            }

            while(takenames.hasNextLine()) {
                String[] fulldata = takenames.nextLine().split(".", 4);
                String[] namegender = fulldata[0].split("\n");
                String[] desc = fulldata[1].split("\n");
                for(String ng: namegender)
                {
                    String name = ng.split("-")[0];
                    String gender = ng.split("-")[1];
                    String des = desc[(int)(Math.random()*((5-1) + 1))];
                    Employee e = new Employee(name, gender, des, Integer.parseInt(fulldata[3]));
                    allpossible.add(e);
                }
            }
    }

    public double payEmployee()
    {
        double payroll = 0;
        for(Employee e: employees)
        {
            payroll += e.getSalary();
            businessFunds -= e.getSalary();
        }
        return payroll;
    }

    public double workEmployees(Player player)
    {
        for(Employee e: employees)
        {
            businessFunds += e.getSatisfaction() * e.getWorkPoints();
            exp += 10;
        }
        double profit = businessFunds*0.03;
        player.changeMoney(profit);
        return profit;
    }

    public void hireEmployee(Employee emp)
    {
        employees.add(emp);
        businessFunds -= emp.getSalary();
        calculateRatio();
    }

    public void lookAtHires()
    {
        int employeelimit = 3 + (level/2);
        for(int employeeshere = 0; employeeshere < employeelimit; employeeshere++) {
            allpossible.get((int) (Math.random() * ((allpossible.size()-0) + 1)));
        }
    }

    public void fireEmployee(Employee emp)
    {
        employees.remove(emp);
        calculateRatio();
    }

    public void advertise()
    {
        businessFunds-=200;
        exp += 200;
    }

    public void changeBusinessFunds(int amount){
        this.businessFunds += amount;
    }

    public void getFunding(Player player)
    {
        if(player.isConfidentEnough(70))
        {
            businessFunds += 2000*level;
            exp += 500;
        }
    }

    public void lvlup() throws FileNotFoundException {
        if(exp >= lvllimit)
        {
            this.level++;
            lvllimit += 1000;
            exp = 0;
        }
        buildAllPossibleEmployees();
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

    public ArrayList<String> viewBusiness()
    {
        String levelreport = "Business Level: " + this.getLevel();
        String businessfundsreport = "Business Funds: " + this.businessFunds;
        String ratioreport = "Female Employee Ratio: " + this.getRatio();
        String employeeinfo = "";
        for(Employee e: employees)
        {
            employeeinfo += "" + e.getName()
                    + "Description: " + e.getDesc()
                        + "Age: " + e.getAge()
                            + "Gender" + e.getGender()
                                + "Satisfaction: " + e.getSatisfaction()
                                    + "Salary: " + e.getSalary()
                                        + "Work Points: " + e.getWorkPoints();
        }
        ArrayList<String> stats = new ArrayList<>();
        stats.add(levelreport);
        stats.add(businessfundsreport);
        stats.add(ratioreport);
        stats.add(employeeinfo);

        return stats;
    }


}

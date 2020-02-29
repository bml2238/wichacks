package mechanics;

import java.util.Map;

public class Business {
    private int employees;
    private int businessIncome;
    private int level;
    private int exp;
    public Map<String, Employee> employeelist;

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
        for(Employee e: employeelist.values())
        {
            //this.businessIncome - e.getSalary();
        }
    }

}

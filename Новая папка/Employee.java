public class Employee extends StaffMember{
    protected String SSN;
    protected double payRate;
     
    public Employee(String iName, String iAddress, String iPhone, String iSSN,
double rate){
            super (iName, iAddress, iPhone);
            SSN = iSSN;
            payRate = rate;
    }
    public String toString(){
        String result = super.toString();
         
        result += "\nSSN: " + SSN;
         
        return result;
    }
     
    public double pay(){
        return payRate;
    }
}
public class Volunteer extends StaffMember{
    public Volunteer (String iName, String iAddress, String iPhone){
        super (iName, iAddress, iPhone);
    }
    public double pay(){
        return 0.0;
    }
}   

public class Executive extends Employee{
    private double bonus;
     
    public Executive (String iName, String iAddress, String iPhone,  
            String SSN, double rate){
        super (iName, iAddress, iPhone, SSN, rate);
        bonus = 0;
    }
     
    public void awardBonus(double execBonus){
        bonus = execBonus;
    }
    public double pay(){
        double payment = super.pay() + bonus;
        bonus = 0;
        return payment;
    }
}
public class Hourly extends Employee{
    private int hoursWorked;
     
    public Hourly (String iName, String iAddress, String iPhone, String iSSN,
double rate){
        super (iName, iAddress, iPhone, iSSN, rate);
        hoursWorked = 0;
    }
    public void addHours (int moreHours){
        hoursWorked += moreHours;
    }
     
    public double pay(){
        double payment = payRate * hoursWorked;
        hoursWorked = 0;
        return payment;
    }
     
    public String toString(){
        String result = super.toString();

        result += "\nCurrent hours: " + hoursWorked;
        return result;
    }
} 
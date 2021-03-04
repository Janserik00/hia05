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
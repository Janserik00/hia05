public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create Employee array
        Employee[] employees = new Employee[4];
         
        // initialize array with Employess
        employees[0] = new SalariedEmployee("George", "Bush", "111‐22‐3333",1000);
        employees[1] = new HourlyEmployee("Bill", "Clinton", "222‐33‐4444", 16.75,
40);
        employees[2] = new CommissionEmployee("John", "MaCain", "333‐44‐5555",
10000.0, 0.06);
        employees[3] = new BasePlusCommissionEmployee("Barack", "Obama", "444‐
55‐6666", 5000.0, 0.04, 300);
        String output = "";
         
        // generically process each element in array employees
         
        for (int i = 0; i < employees.length; i++) {
            output += employees[i].toString();

           
            if (employees[i] instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee currentEmployee =  
                        (BasePlusCommissionEmployee)employees[i];
                 
                double oldBaseSalary = currentEmployee.getBaseSalary();
                output += "\nold base salary: $" + oldBaseSalary;
                 
                currentEmployee.setBaseSalary(1.10 * oldBaseSalary);
                output += "\nnew base salary with 10% increase is: $" +
                        currentEmployee.getBaseSalary();
            }
            
            output += "\nearned: $" + employees[i].earnings() + "\n";
        }
           // get type name of each object in employees array
        for (int j = 0; j < employees.length; j++)
            output += "\nEmployee " + j + " is a " + employees[j].getClass().getName();
         
        System.out.println(output);    
    }
}
public abstract class Employee {
    private String firstName;
    private String lastName;
    private String SSN;
   
    public Employee (String first, String last, String ssn) {
          firstName = first;
lastName = last;
SSN = ssn;
    }
   
    public String getFirstName(){
return firstName;
    }
    public void setFirstName (String first) {
firstName = first;
    }
   
    public String getLastName(){
Java Programming Summer 2008

3
return lastName;
    }
   
    public void setLastName (String last) {
lastName = last;
    }
   
    public String getSSN(){
return SSN;
    }
   
    public void setSSN(String number){
SSN = number;
    }
   
    public String toString(){
return getFirstName() + " " + getLastName() + "\nSSN: " + getSSN();
    }
   
    public abstract double earnings();
}
public class CommissionEmployee extends Employee{
    private double grossSales;
    private double commissionRate;
   
    public CommissionEmployee (String first, String last, String SSN, double
grossWeeklySales, double percent){
super (first, last, SSN);
setGrossSales (grossWeeklySales);
setCommissionRate (percent);
    }
   
    public double getGrossSales(){
return grossSales;
    }
   
    public void setGrossSales (double sales){
grossSales = sales < 0.0 ? 0.0 : sales;
    }
   
    public double getCommissionRate(){
return commissionRate;
    }
Java Programming Summer 2008

4
   
    public void setCommissionRate (double rate){
commissionRate = (rate > 0.0 && rate < 1.0) ? rate : 0.0;
    }
   
    public double earnings(){
return getCommissionRate() * getGrossSales();
    }
   
    public String toString(){
return "\ncommission empolyee: " + super.toString();
    }
}
public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;
   
    public HourlyEmployee (String first, String last, String SSN, double
hourlyWage, double hoursWorked) {
super (first, last, SSN);
setWage (hourlyWage);
setHours (hoursWorked);
    }
   
    public void setWage (double wageAmount) {
      wage = wageAmount < 0.0 ? 0.0 : wageAmount;
    }
   
    public double getWage(){
return wage;
    }
   
    public void setHours (double hoursWorked){
hours = (hoursWorked >= 0.0 && hoursWorked <= 168.0) ? hoursWorked :
0.0;
    }
   
    public double getHours(){
return hours;
    }
   
    public double earnings(){
if (hours <= 40)
Java Programming Summer 2008

5
            return wage * hours;
else
            return 40 * wage + (hours ‐ 40) * wage * 1.5;
    }
   
    public String toString(){
return "\nhourly employee: " + super.toString();
    }
}   
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;
   
    public BasePlusCommissionEmployee (String first, String last, String SSN,  
double grossSalesAmount, double rate, double baseSalaryAmount){   
super (first, last, SSN, grossSalesAmount, rate);
setBaseSalary (baseSalaryAmount);
    }
   
    public void setBaseSalary (double salary){
baseSalary = salary < 0.0 ? 0.0 : salary;
    }
   
    public double getBaseSalary(){
return baseSalary;
    }
   
    public double earnings(){
return getBaseSalary() + super.earnings();
    }
   
    public String toString(){
      return "\nbase‐salaried commission employee: " + super.getFirstName() +   
" " + super.getLastName() + "\nsocial security number: " + super.getSSN();
    }
}

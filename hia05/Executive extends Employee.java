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
public class Staff {
   private StaffMember[] staffList;
    
   public Staff(){
       staffList = new StaffMember[4];
        
       staffList[0] = new Executive ("George", "123 Main Street", "555‐5555", "123‐45‐
6789", 10000.00);
       staffList[1] = new Employee ("Diane", "456 Grand Ave.", "666‐6666", "012‐34‐
5678", 4000.00);
       staffList[2] = new Hourly ("Woody", "789 Fifth Ave.", "777‐7777", "234‐56‐
7890", 10.55);
       staffList[3] = new Volunteer ("Jane", "012 South Street", "888‐8888");
        
       ((Executive)staffList[0]).awardBonus(500.00);
       ((Hourly)staffList[2]).addHours(40);
   }
   public void payday(){
       double amount;
        
       for (int count = 0; count < staffList.length; count++){
            
           // get type name of each object staff array
            
           System.out.println(staffList[count].getClass().getName());
           System.out.println(staffList[count]);
           amount = staffList[count].pay();
            
           if (amount == 0.0)
               System.out.println("Thanks!");
           else
               System.out.println("Paid: " + amount);
            
           System.out.println ("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
       }
   }
}
public abstract class StaffMember {
    protected String name;
    protected String address;
    protected String phone;
     

    public StaffMember (String iName, String iAddress, String iPhone){
        name = iName;
        address = iAddress;
        phone = iPhone;
    }
     
    public String toString(){
        String result = "Name: " + name + "\n";
         
        result += "Address: " + address + "\n";
        result += "Phone: " + phone;
         
        return result;
    }
     
    public abstract double pay();
}
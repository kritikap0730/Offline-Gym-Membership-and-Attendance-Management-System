//creating an abstract class
public abstract class GymMember{
    //creating a protected instance variable which can only be accessible by the child class
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String dob;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    //a constructor is created
    
    public GymMember(int id,String name,String location,String phone,String email,String gender,String dob,
    String membershipStartDate){
        /*-this keyword is used to differentiate if the instance variable has a same name
          -acoording to question default value is assigned */
        this.attendance= 0;
        this.loyaltyPoints= 0.0;
        this.activeStatus= false;
        this.id= id;
        this.name= name;
        this.location= location;
        this.phone= phone;
        this.email= email;
        this.gender= gender;
        this.dob= dob;
        this.membershipStartDate= membershipStartDate;
    }
    
    //getter method
    public int getId(){
        return this.id;
    } 
    
    public String getName(){
        return this.name;
    } 
    
    public String getLocation(){
        return this.location;
    } 
    
    public String getPhone(){
        return this.phone;
    } 
    
    public String getEmail(){
        return this.email;
    } 
    
    public String getGender(){
        return this.gender;
    } 
    
    public String getDob(){
        return this.dob;
    } 
    
    public String getMembershipStartDate(){
        return this.membershipStartDate;
    } 
    
    public int getAttendance(){
        return this.attendance;
    } 
    
    public double getLoyaltyPoints(){
        return this.loyaltyPoints;
    }
    
    public boolean getActiveStatus(){
        return this.activeStatus;
    }
    
    //abstract method for subclass to implement it
    public abstract void markAttendance();
    
    //to activate membership
    public void activateMembership(){
        this.activeStatus= true;
        System.out.println("Your membership is activated sucessfully.");
    }
    
    //to deactivate the membership
    public void deactivateMembership(){
       if (this.activeStatus){
           this.activeStatus=false;
           System.out.println("Your membership is deactivated sucessfully.");
       }else{
           System.out.println("The membership must be activated first.");
       }
    }
    
    //to reset the details of the member
    public void resetMember(){
       this.activeStatus = false;
       this.attendance = 0;
       this.loyaltyPoints=0.0;
    }
    
    //display method is created to display the details
    public void display(){
       System.out.println("ID:"+ this.id); 
       System.out.println("Name:"+ this.name);
       System.out.println("Location:"+ this.location);
       System.out.println("Phone:"+ this.phone);
       System.out.println("Email:"+ this.email);
       System.out.println("Gender:"+ this.gender);
       System.out.println("Date of birth:"+ this.dob);
       System.out.println("Membership start Date:"+ this.membershipStartDate);
       System.out.println("Attendance:"+ this.attendance);
       System.out.println("Loyalty Points:"+ this.loyaltyPoints);
       System.out.println("Active status:"+ (this.activeStatus ? "Active" : "Inactive"));
    }
}
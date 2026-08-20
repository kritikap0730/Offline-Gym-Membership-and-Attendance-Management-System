public class RegularMember extends GymMember{//extends is used to get access of the gym member class
    /*creating a private instance varriable
    final is used so that no further modification can be done */
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //constructor is created
    public RegularMember(int id, String name, String location,String phone,String email,String gender,
    String DOB,String membershipStartDate,String referralSource){
    //super keyword is used to call the parent class
    super(id,name,location,phone,email,gender,DOB,membershipStartDate);
    this.isEligibleForUpgrade = false;
    this.attendanceLimit = 30;
    this.plan = "Basic";
    this.price = 6500;
    this.removalReason = "";
    this.referralSource = referralSource;
    }
    
    //accessor method is used
    public int getAttendanceLimit(){
        return this.attendanceLimit;
    }
    
    public boolean getIsEligibleForUpgrade(){
        return this.isEligibleForUpgrade;
    }
    
    public String getRemovalReason(){
        return this.removalReason;
    }
    
    public String getReferralSource(){
        return this.referralSource;
    }
    
    public String getPlan(){
        return this.plan;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    //override is used as mark attendance is already available in the parent class
    @Override
    public void markAttendance(){
        this.attendance++;//increases the attendance by 1
        this.loyaltyPoints+=5;//increases the loyalty points by 5
        if(getAttendance()>= this.attendanceLimit){
            this.isEligibleForUpgrade = true;
        }
    }
    
    public double getPlanPrice(String Plan){
      switch(Plan.toLowerCase()){//converts the plan for case sensitivity
          case "basic":
              return 6500;
          case "standard":
              return 12500;
          case "deluxe":
              return 18500;
          default:
              return -1;//according to the question
      }
    }
    
    //code to upgrade the plan
    public String upgradePlan(String Plan) {
        if (getPlanPrice(Plan) == -1) {
            return "Invalid plan.";
        }

        if (this.plan.equals(Plan)) {
            return "You are already subscribed to this plan.";
        }

        if (this.isEligibleForUpgrade) {
            this.plan = Plan;
            this.price = getPlanPrice(Plan);
            return "Plan upgraded to " + Plan + ". Price updated to Rs " + (int)price + ".";
        } else {
            return "You are not eligible for an upgrade,attendance must be 30.";
        }
    }
    //reseting the members details
    public void revertRegularMember(String removalReason){
       super.resetMember(); 
       this.isEligibleForUpgrade = false;
       this.plan ="basic";
       this.price =6500;
       this.removalReason = removalReason;
    }
    //calling super class method
    @Override
    public void display(){
        super.display();
        System.out.println("Plan:"+ this.plan);
        System.out.println("Price:"+ this.price);
        
        if (this.
        removalReason.length()>0){//to ensure it is not empty
        System.out.println("Removal Reason:"+ this.removalReason);
        }
    }
}
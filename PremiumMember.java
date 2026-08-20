public class PremiumMember extends GymMember{
    private final double premiumCharge;//final is used so that the value cant be changed . 
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    //constructor is created
    public PremiumMember(int id, String name, String location,String phone,String email,String gender,
    String DOB,String membershipStartDate,String personalTrainer){
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.premiumCharge= 50000;
        this.personalTrainer= personalTrainer;
        this.paidAmount= 0;
        this.isFullPayment = false;
        this.discountAmount=0;
    }

    //getter method is used
    public double getPremiumCharge(){
        return this.premiumCharge;
    }

    public String getPersonalTrainer(){
        return this.personalTrainer;
    }

    public boolean getFullPayment(){
        return this.isFullPayment;
    }

    public double getPaidAmount(){
        return this.paidAmount;
    }

    public double getDiscountAmount(){
        return this.discountAmount;
    }

    //the method is already in the parent class
    @Override
    public void markAttendance(){
        this.attendance++;
        this.loyaltyPoints+=10;
    }

    //shows us whether the payment is done or not
    public String payDueAmount(double paidAmount){
        if(this.isFullPayment){
            return"Payment is already completed";
        }
        if(this.paidAmount + paidAmount >this.premiumCharge){
            return"Payment exceeds the required amount";
        }
        if (paidAmount < 0) {
            return "Payment amount cannot be negative.";
        }
        this.paidAmount+= paidAmount;
        double remainingAmount = this.premiumCharge - this.paidAmount;
        if (this.paidAmount == this.premiumCharge){
            this.isFullPayment = true;
            return "Payment successful.No remaining amount left";
        }else{
            return "Payment successful.Remaining amount to be paid:" + remainingAmount;
        }
        
    }

    //code written to give discount if full payment is done
    public void calculateDiscount(){
        if (this.isFullPayment){
            this.discountAmount=premiumCharge* 0.10;
            System.out.println("You have received a 10% discount of " + this.discountAmount +" on your pakage");
        }else{
            System.out.println("You need to complete the full payment in order to recieve a discount.");
        }
    }

    //a superclass reset member is called to reset the details
    public void revertPremiumMember(){
        super.resetMember();
        this.personalTrainer= "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    //method to show the details
    @Override
    public void display(){
        super.display();
        System.out.println("Personal Trainer: " + this.personalTrainer);
        System.out.println("Paid Amount: " + this.paidAmount);
        System.out.println("Is Full Payment: " + (this.isFullPayment ? "Yes" : "No"));
        double remainingAmount = premiumCharge - this.paidAmount;
        System.out.println("Remaining Amount to be Paid: " + remainingAmount);
        if (this.isFullPayment) {
            System.out.println("Discount Amount: " + this.discountAmount);
        }
    }
}


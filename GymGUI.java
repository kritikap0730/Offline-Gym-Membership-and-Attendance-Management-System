import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.awt.Font;

public class GymGUI implements ActionListener{
    //creating an array list
    private ArrayList<GymMember> al =new ArrayList<GymMember>();

    private JFrame fr;
    //for regular member
    private JLabel labelId, labelName, labelLocation, labelPhone, labelEmail,
    labelGender , labelDob, labelMembership, labelReferral, 
    labelBasic,labelStandard,labelDeluxe,labelPlan,labelRemoval,labelLoyalty;
    private JTextField tfId,tfName,tfLocation,tfPhone,tfEmail,
    tfBasic,tfStandard,tfDeluxe,tfLoyalty;
    private JTextArea tfReferral,tfRemoval;
    private JButton btnAddReg, btnActivateReg,btnDeactivateReg,btnAttendanceReg,btnRevertReg,
    btnDisplayReg,btnClearReg,btnUpdateReg,btnReadReg,btnSaveReg;
    private JComboBox<String> cbMonth,comboMonth,cbPlan;
    private JComboBox<Integer> cbYear ,cbDay,comboYear,comboDay;
    private JRadioButton rb1,rb2;
    private ButtonGroup bg;

    //for premium member
    private JLabel labelIdPrem, labelNamePrem, labelLocationPrem, labelPhonePrem, labelEmailPrem,
    labelGenderPrem , labelDobPrem, labelMembershipPrem,  labelPaidPrem, labelRemovalPrem,
    labelTrainer,labelPremium,labelDiscountPrem,labelLoyaltyPrem;
    private JTextArea tfRemovalPrem;
    private JTextField tfIdPrem,tfNamePrem,tfLocationPrem,tfPhonePrem,tfEmailPrem,
    tfPaidPrem,tfTrainer,tfPremium,tfDiscountPrem,tfLoyaltyPrem;
    private JButton btnAddPrem, btnActivatePrem,btnDeactivatePrem,btnAttendancePrem,btnRevertPrem,
    btnDisplayPrem,btnClearPrem,btnCalculatePrem,btnPayPrem,btnReadPrem,btnSavePrem;
    private JComboBox<String> cbMonthPrem,comboMonthPrem;
    private JComboBox<Integer> cbYearPrem ,cbDayPrem,comboYearPrem,comboDayPrem;
    private JRadioButton rb3,rb4;
    private ButtonGroup bg1;

    //creating separate tabs and panel
    private JTabbedPane tabbedPane;
    private JPanel panelRegular, panelPremium;
    public GymGUI(){
        fr=new JFrame("Gym Memership");//creating a frame

        // creating a tabbed panel
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(10, 10, 660, 640);

        panelRegular = new JPanel(null);
        panelPremium = new JPanel(null);

        setupRegularPanel();
        setupPremiumPanel();

        panelRegular.setBackground(new Color(255, 228, 225));
        panelPremium.setBackground( new Color(173, 216, 230));

        tabbedPane.addTab("Regular Member", panelRegular);
        tabbedPane.addTab("Premium Member", panelPremium);

        tabbedPane.setBackgroundAt(0, Color.PINK); // Regular tab
        tabbedPane.setBackgroundAt(1, Color.PINK);       // Premium tab

        fr.add(tabbedPane);
    }

    private void setupRegularPanel(){

        // Regular Member Panel
        labelId = new JLabel("ID");
        labelId.setBounds(30, 50, 150, 30);
        tfId = new JTextField();
        tfId.setBounds(120, 50, 190, 30);

        labelName = new JLabel("Name");
        labelName.setBounds(350, 50, 150, 30);
        tfName=new JTextField();

        tfName.setBounds(460, 50, 190, 30);
        labelLocation = new JLabel("Location");
        labelLocation.setBounds(30, 100, 150, 30);
        tfLocation=new JTextField();
        tfLocation.setBounds(120, 100, 190, 30);

        labelPhone = new JLabel("Phone");
        labelPhone.setBounds(350, 100, 150, 30);
        tfPhone = new JTextField();
        tfPhone.setBounds(460, 100, 190, 30);

        labelEmail = new JLabel("Email");
        labelEmail.setBounds(30, 150, 150, 30);
        tfEmail = new JTextField();
        tfEmail.setBounds(120, 150, 190, 30);

        labelGender = new JLabel("Gender");
        labelGender.setBounds(30, 200, 150, 25);
        rb1 = new JRadioButton("Male");
        rb1.setBounds(120, 200, 80, 25);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(210, 200, 110, 25);
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        labelDob = new JLabel("DOB");
        labelDob.setBounds(350, 150, 150, 30);
        Integer[] days = new Integer[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = Integer.valueOf(i);
        cbDay = new JComboBox<>(days);
        cbDay.setBounds(460, 150, 50, 25);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        cbMonth = new JComboBox<>(months);
        cbMonth.setBounds(520, 150, 60, 25);
        Integer[] years = new Integer[76];
        for (int i = 0; i < 76; i++) years[i] = Integer.valueOf(1950 + i);
        cbYear = new JComboBox<>(years);
        cbYear.setBounds(590, 150, 60, 25);

        labelMembership = new JLabel("Membership Date");
        labelMembership.setBounds(350, 200, 150, 30);
        Integer[] day = new Integer[31];
        for (int i = 1; i <= 31; i++) day[i - 1] = Integer.valueOf(i);
        comboDay = new JComboBox<>(day);
        comboDay.setBounds(460, 200, 50, 25);
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        comboMonth = new JComboBox<>(month);
        comboMonth.setBounds(520, 200, 60, 25);
        Integer[] year = new Integer[76];
        for (int i = 0; i < 76; i++) year[i] = Integer.valueOf(1950 + i);
        comboYear = new JComboBox<>(year);
        comboYear.setBounds(590, 200, 60, 25);

        labelPlan = new JLabel("Plan");
        labelPlan.setBounds(30, 250, 150, 30);
        cbPlan = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        cbPlan.setBounds(120, 250, 80, 30);

        labelBasic = new JLabel("Basic");
        labelBasic.setBounds(220, 250, 150, 30);
        tfBasic = new JTextField("Rs. 6500");
        tfBasic.setBounds(310, 250, 80, 30);
        tfBasic.setEditable(false);

        labelStandard = new JLabel("standard");
        labelStandard.setBounds(220, 270, 150, 30);
        tfStandard = new JTextField("Rs. 12500");
        tfStandard.setBounds(310, 270, 80, 30);
        tfStandard.setEditable(false);

        labelDeluxe = new JLabel("Deluxe");
        labelDeluxe.setBounds(220, 290, 150, 30);
        tfDeluxe = new JTextField("Rs. 18500");
        tfDeluxe.setBounds(310, 290, 80, 30);
        tfDeluxe.setEditable(false);

        labelReferral = new JLabel("Referral");
        labelReferral.setBounds(400, 250, 150, 30);
        tfReferral = new JTextArea();
        tfReferral.setBounds(460, 250, 190, 75);

        labelRemoval = new JLabel("Removal Reason");
        labelRemoval.setBounds(450, 400, 150, 30);
        tfRemoval = new JTextArea();
        tfRemoval.setBounds(450, 440, 200, 75);

        labelLoyalty = new JLabel("Loyalty points");
        labelLoyalty.setBounds(30, 500, 150, 30);
        tfLoyalty = new JTextField();
        tfLoyalty.setBounds(120, 500, 90, 30);

        //for buttons
        btnAddReg = new JButton("Add Member");
        btnAddReg.setBounds(260, 350, 150, 30);

        btnUpdateReg = new JButton("Upgrade plan");
        btnUpdateReg.setBounds(30, 350, 200, 30);

        btnActivateReg = new JButton("Activate Membership");
        btnActivateReg.setBounds(30, 400, 200, 30);

        btnDeactivateReg = new JButton("Deactivate Membership");
        btnDeactivateReg.setBounds(450, 350, 200, 30);

        btnAttendanceReg = new JButton("Mark Attendance");
        btnAttendanceReg.setBounds(30, 450, 200, 30);

        btnRevertReg = new JButton("Revert Member");
        btnRevertReg.setBounds(260, 450, 150, 30);

        btnDisplayReg = new JButton("Display Members");
        btnDisplayReg.setBounds(30, 550, 200, 30);

        btnClearReg = new JButton("Clear");
        btnClearReg.setBounds(260, 400, 150, 30);

        btnSaveReg = new JButton("Save");
        btnSaveReg.setBounds(260, 500, 150, 30);

        btnReadReg = new JButton("Read");
        btnReadReg.setBounds(260, 550, 150, 30);

        //adding it so it is visible in the frame
        panelRegular.add(labelId); panelRegular.add(tfId);
        panelRegular.add(labelName); panelRegular.add(tfName);
        panelRegular.add(labelLocation); panelRegular.add(tfLocation);
        panelRegular.add(labelPhone); panelRegular.add(tfPhone);
        panelRegular.add(labelEmail); panelRegular.add(tfEmail);
        panelRegular.add(labelGender); panelRegular.add(rb1); panelRegular.add(rb2);
        panelRegular.add(labelDob); panelRegular.add(cbDay); panelRegular.add(cbMonth); panelRegular.add(cbYear);
        panelRegular.add(labelMembership); panelRegular.add(comboDay); panelRegular.add(comboMonth); panelRegular.add(comboYear);
        panelRegular.add(labelPlan); panelRegular.add(cbPlan);
        panelRegular.add(labelBasic); panelRegular.add(tfBasic);
        panelRegular.add(labelStandard); panelRegular.add(tfStandard);
        panelRegular.add(labelDeluxe); panelRegular.add(tfDeluxe);
        panelRegular.add(labelReferral); panelRegular.add(tfReferral);
        panelRegular.add(labelRemoval); panelRegular.add(tfRemoval);
        panelRegular.add(labelLoyalty); panelRegular.add(tfLoyalty);
        panelRegular.add(btnAddReg);
        panelRegular.add(btnUpdateReg);
        panelRegular.add(btnActivateReg);
        panelRegular.add(btnDeactivateReg);
        panelRegular.add(btnClearReg);
        panelRegular.add(btnAttendanceReg);
        panelRegular.add(btnRevertReg);
        panelRegular.add(btnDisplayReg);
        panelRegular.add(btnSaveReg);
        panelRegular.add(btnReadReg);

        //for action to be performed
        btnAddReg.addActionListener(this);
        btnAttendanceReg.addActionListener(this);
        btnActivateReg.addActionListener(this);
        btnDeactivateReg.addActionListener(this);
        btnRevertReg.addActionListener(this);
        btnDisplayReg.addActionListener(this);
        btnUpdateReg.addActionListener(this);
        btnClearReg.addActionListener(this);
        btnSaveReg.addActionListener(this);
        btnReadReg.addActionListener(this);
    }

    private void setupPremiumPanel(){
        // Regular Member Panel
        labelIdPrem = new JLabel("ID");
        labelIdPrem.setBounds(30, 50, 150, 30);
        tfIdPrem = new JTextField();
        tfIdPrem.setBounds(120, 50, 190, 30);

        labelNamePrem = new JLabel("Name");
        labelNamePrem.setBounds(350, 50, 150, 30);
        tfNamePrem=new JTextField();
        tfNamePrem.setBounds(460, 50, 190, 30);

        labelLocationPrem = new JLabel("Location");
        labelLocationPrem.setBounds(30, 100, 150, 30);
        tfLocationPrem=new JTextField();
        tfLocationPrem.setBounds(120, 100, 190, 30);

        labelPhonePrem = new JLabel("Phone");
        labelPhonePrem.setBounds(350, 100, 150, 30);
        tfPhonePrem = new JTextField();
        tfPhonePrem.setBounds(460, 100, 190, 30);

        labelEmailPrem = new JLabel("Email");
        labelEmailPrem.setBounds(30, 150, 150, 30);
        tfEmailPrem = new JTextField();
        tfEmailPrem.setBounds(120, 150, 190, 30);

        labelGenderPrem = new JLabel("Gender");
        labelGenderPrem.setBounds(30, 200, 150, 25);
        rb3 = new JRadioButton("Male");
        rb3.setBounds(120, 200, 80, 25);
        rb4 = new JRadioButton("Female");
        rb4.setBounds(210, 200, 110, 25);
        bg1 = new ButtonGroup();
        bg1.add(rb3);
        bg1.add(rb4);

        labelDobPrem = new JLabel("DOB");
        labelDobPrem.setBounds(350, 150, 150, 30);
        Integer[] days = new Integer[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = Integer.valueOf(i);
        cbDayPrem = new JComboBox<>(days);
        cbDayPrem.setBounds(460, 150, 50, 25);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        cbMonthPrem = new JComboBox<>(months);
        cbMonthPrem.setBounds(520, 150, 60, 25);
        Integer[] years = new Integer[76];
        for (int i = 0; i < 76; i++) years[i] = Integer.valueOf(1950 + i);
        cbYearPrem = new JComboBox<>(years);
        cbYearPrem.setBounds(590, 150, 60, 25);

        labelMembershipPrem = new JLabel("Membership Date");
        labelMembershipPrem.setBounds(350, 200, 150, 30);
        Integer[] day = new Integer[31];
        for (int i = 1; i <= 31; i++) day[i - 1] = Integer.valueOf(i);
        comboDayPrem = new JComboBox<>(day);
        comboDayPrem.setBounds(460, 200, 50, 25);
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        comboMonthPrem = new JComboBox<>(month);
        comboMonthPrem.setBounds(520, 200, 60, 25);
        Integer[] year = new Integer[76];
        for (int i = 0; i < 76; i++) year[i] = Integer.valueOf(1950 + i);
        comboYearPrem = new JComboBox<>(year);
        comboYearPrem.setBounds(590, 200, 60, 25);

        labelPaidPrem = new JLabel("Paid Amount");
        labelPaidPrem.setBounds(30, 250, 150, 30);
        tfPaidPrem= new JTextField();
        tfPaidPrem.setBounds(120, 250, 80, 30);

        labelPremium = new JLabel("Premium Price");
        labelPremium .setBounds(220, 250, 150, 30);
        tfPremium  = new JTextField("Rs. 50000");
        tfPremium .setBounds(310, 250, 80, 30);
        tfPremium .setEditable(false);

        labelTrainer = new JLabel("Trainer");
        labelTrainer.setBounds(400, 250, 150, 30);
        tfTrainer = new JTextField();
        tfTrainer.setBounds(460, 250, 190, 30);

        labelDiscountPrem = new JLabel("Discount");
        labelDiscountPrem.setBounds(30, 300, 150, 30);
        tfDiscountPrem = new JTextField();
        tfDiscountPrem.setBounds(120, 300, 80, 30);

        labelRemovalPrem = new JLabel("Removal Reason");
        labelRemovalPrem.setBounds(450, 350, 150, 30);
        tfRemovalPrem = new JTextArea();
        tfRemovalPrem.setBounds(450, 390, 200, 75);

        labelLoyaltyPrem = new JLabel("Loyalty points");
        labelLoyaltyPrem.setBounds(30, 500, 150, 30);
        tfLoyaltyPrem = new JTextField();
        tfLoyaltyPrem.setBounds(120, 500, 90, 30);

        //for buttons
        btnAddPrem = new JButton("Add member");
        btnAddPrem.setBounds(260, 300, 150, 30);

        btnCalculatePrem=new JButton("Calculate Discount");
        btnCalculatePrem.setBounds(30,350,200,30);

        btnActivatePrem = new JButton("Activate Membership");
        btnActivatePrem.setBounds(30, 400, 200, 30);

        btnDeactivatePrem = new JButton("Deactivate Membership");
        btnDeactivatePrem.setBounds(450, 300, 200, 30);

        btnAttendancePrem = new JButton("Mark Attendance");
        btnAttendancePrem.setBounds(30, 450, 200, 30);

        btnRevertPrem = new JButton("Revert Member");
        btnRevertPrem.setBounds(260, 400, 150, 30);

        btnDisplayPrem = new JButton("Display Members");
        btnDisplayPrem.setBounds(30, 550, 200, 30);

        btnPayPrem = new JButton("Pay due amount");
        btnPayPrem.setBounds(260, 350, 150, 30);

        btnClearPrem = new JButton("Clear");
        btnClearPrem.setBounds(260, 450, 150, 30);

        btnSavePrem = new JButton("Save");
        btnSavePrem.setBounds(260, 500, 150, 30);

        btnReadPrem = new JButton("Read");
        btnReadPrem.setBounds(260, 550, 150, 30);

        //adding it so it is visible in the frame
        panelPremium.add(labelIdPrem); panelPremium.add(tfIdPrem);
        panelPremium.add(labelNamePrem); panelPremium.add(tfNamePrem);
        panelPremium.add(labelLocationPrem); panelPremium.add(tfLocationPrem);
        panelPremium.add(labelPhonePrem); panelPremium.add(tfPhonePrem);
        panelPremium.add(labelEmailPrem); panelPremium.add(tfEmailPrem);
        panelPremium.add(labelGenderPrem); panelPremium.add(rb3); panelPremium.add(rb4);
        panelPremium.add(labelDobPrem); panelPremium.add(cbDayPrem); panelPremium.add(cbMonthPrem); panelPremium.add(cbYearPrem);
        panelPremium.add(labelMembershipPrem); panelPremium.add(comboDayPrem); panelPremium.add(comboMonthPrem); panelPremium.add(comboYearPrem);
        panelPremium.add(labelPaidPrem); panelPremium.add(tfPaidPrem);
        panelPremium.add(labelPremium); panelPremium.add(tfPremium);
        panelPremium.add(labelTrainer); panelPremium.add(tfTrainer);
        panelPremium.add(labelDiscountPrem); panelPremium.add(tfDiscountPrem);
        panelPremium.add(labelRemovalPrem); panelPremium.add(tfRemovalPrem);
        panelPremium.add(labelLoyaltyPrem); panelPremium.add(tfLoyaltyPrem);
        panelPremium.add(btnAddPrem);
        panelPremium.add(btnCalculatePrem);
        panelPremium.add(btnActivatePrem);
        panelPremium.add(btnDeactivatePrem);
        panelPremium.add(btnClearPrem);
        panelPremium.add(btnAttendancePrem);
        panelPremium.add(btnRevertPrem);
        panelPremium.add(btnDisplayPrem);
        panelPremium.add(btnPayPrem);
        panelPremium.add(btnSavePrem);
        panelPremium.add(btnReadPrem);

        btnAddPrem.addActionListener(this);
        btnAttendancePrem.addActionListener(this);
        btnActivatePrem.addActionListener(this);
        btnDeactivatePrem.addActionListener(this);
        btnRevertPrem.addActionListener(this);
        btnDisplayPrem.addActionListener(this);
        btnCalculatePrem.addActionListener(this);
        btnPayPrem.addActionListener(this);
        btnClearPrem.addActionListener(this);
        btnSavePrem.addActionListener(this);
        btnReadPrem.addActionListener(this);

        fr.setLayout(null);
        fr.setVisible(true);
        fr.setSize(700,700);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnAddReg) {
            // Handle Regular Member addition

            String idStr = tfId.getText();
            String name = tfName.getText();
            String location = tfLocation.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String referral = tfReferral.getText();
            String selectedPlan = (String) cbPlan.getSelectedItem();

            String gender = rb1.isSelected() ? "Male" : (rb2.isSelected() ? "Female" : null);

            String dob = cbDay.getSelectedItem() + "/" + cbMonth.getSelectedItem() + "/" + cbYear.getSelectedItem();
            String startDate = comboDay.getSelectedItem() + "/" + comboMonth.getSelectedItem() + "/" + comboYear.getSelectedItem();

            if (idStr.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() ||
            referral.isEmpty() ||  gender == null || selectedPlan == null) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "Phone number must be exactly 10 digits.", "Invalid Phone", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "ID must be a valid integer.", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (GymMember m : al) {
                if (m.getId() == id) {
                    JOptionPane.showMessageDialog(null, "Member ID already exists!");
                    return;
                }
            }

            RegularMember rm = new RegularMember(id, name, location, phone, email, gender, dob, startDate, referral);
            al.add(rm);
            JOptionPane.showMessageDialog(null, "Regular Member added successfully!");

        }

        else if (source == btnAddPrem) {
            // Handle Premium Member addition

            String idStr = tfIdPrem.getText();
            String name = tfNamePrem.getText();
            String location = tfLocationPrem.getText();
            String phone = tfPhonePrem.getText();
            String email = tfEmailPrem.getText();
            String trainer = tfTrainer.getText();
            String planStr = tfPaidPrem.getText();
            String discount = tfDiscountPrem.getText();

            String gender = rb3.isSelected() ? "Male" : (rb4.isSelected() ? "Female" : null);

            String dob = cbDayPrem.getSelectedItem() + "/" + cbMonthPrem.getSelectedItem() + "/" + cbYearPrem.getSelectedItem();
            String startDate = comboDayPrem.getSelectedItem() + "/" + comboMonthPrem.getSelectedItem() + "/" + comboYearPrem.getSelectedItem();

            if (idStr.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() ||
            trainer.isEmpty() || planStr.isEmpty() || gender == null) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
                return;
            }
            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "Phone number must be exactly 10 digits.", "Invalid Phone", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "ID must be a valid integer.", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double planPrice;
            try {
                planPrice = Double.parseDouble(planStr);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Price must be a valid number.", "Invalid  Price", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (GymMember m : al) {
                if (m.getId() == id) {
                    JOptionPane.showMessageDialog(null, "Member ID already exists!");
                    return;
                }
            }

            PremiumMember pm = new PremiumMember(id, name, location, phone, email, gender, dob, startDate, trainer);
            al.add(pm);
            JOptionPane.showMessageDialog(null, "Premium Member added successfully!");

        }

        //for mark attendance
        else if (e.getSource() == btnAttendanceReg || e.getSource() == btnAttendancePrem) {
            // Use the correct text field depending on which button was pressed
            JTextField activeField = (e.getSource() == btnAttendanceReg) ? tfId : tfIdPrem;
            String idStr = activeField.getText();

            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID to mark attendance.", "Missing Field", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                boolean found = false;

                for (GymMember member : al) {
                    if (member.getId() == id) {
                        // Match member type and check if membership is active
                        if (((e.getSource() == btnAttendanceReg && member instanceof RegularMember) ||
                            (e.getSource() == btnAttendancePrem && member instanceof PremiumMember))
                        && member.getActiveStatus()) {

                            member.markAttendance(); // Already includes loyalty point increase
                            int attendanceCount=member.getAttendance();
                            double updatedPoints = member.getLoyaltyPoints();
                            if (member instanceof RegularMember) {
                                tfLoyalty.setText(String.valueOf(updatedPoints));
                            } else if (member instanceof PremiumMember) {
                                tfLoyaltyPrem.setText(String.valueOf(updatedPoints));
                            }
                            JOptionPane.showMessageDialog(null, "Attendance marked for: " + member.getName()+"\nAttendance count: " + attendanceCount, 
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                            found = true;
                            return;

                        } else if (!member.getActiveStatus()) {
                            JOptionPane.showMessageDialog(null, "Membership is not active for this member.", "Inactive Membership", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found or type mismatch.", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Handling Activate Membership
        else if (e.getSource() == btnActivateReg || e.getSource() == btnActivatePrem) {
            JTextField activeField = (e.getSource() == btnActivateReg) ? tfId : tfIdPrem;
            String idStr = activeField.getText();

            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID to activate membership.", "Missing Field", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);

                for (GymMember member : al) {
                    if (member.getId() == id) {
                        if ((e.getSource() == btnActivateReg && member instanceof RegularMember) ||
                        (e.getSource() == btnActivatePrem && member instanceof PremiumMember)) {

                            if (member.activeStatus) {
                                JOptionPane.showMessageDialog(null, "Membership is already active.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                member.activeStatus = true;
                                JOptionPane.showMessageDialog(null, "Membership activated for: " + member.getName(), "Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                            return;
                        }
                    }
                }

                JOptionPane.showMessageDialog(null, "Member ID not found or type mismatch.", "Invalid ID", JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Handling Deactivate Membership
        else if (e.getSource() == btnDeactivateReg || e.getSource() == btnDeactivatePrem) {
            JTextField activeField = (e.getSource() == btnDeactivateReg) ? tfId : tfIdPrem;
            JTextArea reasonField = (e.getSource() == btnDeactivateReg) ? tfRemoval : tfRemovalPrem;
            String idStr = activeField.getText();
            String removalReason = reasonField.getText();

            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID to deactivate membership.", "Missing Field", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);

                for (GymMember member : al) {
                    if (member.getId() == id) {
                        if ((e.getSource() == btnDeactivateReg && member instanceof RegularMember) ||
                        (e.getSource() == btnDeactivatePrem && member instanceof PremiumMember)) {

                            if (!member.activeStatus) {
                                JOptionPane.showMessageDialog(null, "Membership is already inactive.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                if (removalReason.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Please enter a removal reason before deactivating membership.", "Missing Field", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }

                                member.activeStatus = false;
                                JOptionPane.showMessageDialog(null, "Membership deactivated for: " + member.getName(), "Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                            return;
                        }
                    }
                }

                JOptionPane.showMessageDialog(null, "Member ID not found or type mismatch.", "Invalid ID", JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }//revert member

        else if (e.getSource() == btnRevertReg || e.getSource() == btnRevertPrem) {
            JTextField activeField = (e.getSource() == btnRevertReg) ? tfId : tfIdPrem;
            JTextArea reasonField = (e.getSource() == btnRevertReg) ? tfRemoval : tfRemovalPrem;
            String idStr = activeField.getText();
            String removalReason = reasonField.getText();

            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID to revert.", "Missing Field", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                boolean found = false;

                for (int i = 0; i < al.size(); i++) {
                    GymMember member = al.get(i);

                    if (member.getId() == id) {
                        // Ensure only active members can be reverted
                        if (!member.activeStatus) {
                            JOptionPane.showMessageDialog(null, "Only active members can be reverted.", "Inactive Member", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        // Check member type matches the button
                        if ((e.getSource() == btnRevertReg && member instanceof RegularMember) ||
                        (e.getSource() == btnRevertPrem && member instanceof PremiumMember)) {
                            if (removalReason.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Please enter a removal reason.", "Missing Field", JOptionPane.WARNING_MESSAGE);
                                return;
                            }

                            // Revert logic
                            if (member instanceof RegularMember) {
                                RegularMember reg = (RegularMember) member;
                                reg.revertRegularMember("Reverted by admin");
                                tfLoyalty.setText("0");
                                cbPlan.setSelectedIndex(0);  // Select first item

                            } else if (member instanceof PremiumMember) {
                                PremiumMember prem = (PremiumMember) member;
                                prem.revertPremiumMember();
                                tfLoyaltyPrem.setText("0");
                                tfPaidPrem.setText("");
                                tfTrainer.setText("");
                                tfDiscountPrem.setText("");
                            }

                            al.remove(i);  // Remove from ArrayList

                            JOptionPane.showMessageDialog(null, "Member reverted and removed: " + member.getName(),
                                "Revert Successful", JOptionPane.INFORMATION_MESSAGE);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found or type mismatch.",
                        "Invalid ID", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        //update plan 
        else if (e.getSource() == btnUpdateReg) {
            String idStr = tfId.getText(); // Member ID input
            String selectedPlan = cbPlan.getSelectedItem().toString(); // Plan dropdown

            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID.", "Missing Field", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                boolean found = false;

                for (GymMember member : al) {
                    if (member.getId() == id) {
                        found = true;

                        if (member instanceof RegularMember) {
                            RegularMember reg = (RegularMember) member;

                            if (!reg.getActiveStatus()) {
                                JOptionPane.showMessageDialog(null, "Membership must be active to upgrade the plan.", "Inactive Member", JOptionPane.WARNING_MESSAGE);
                                return;
                            }

                            // Now call upgradePlan which handles eligibility and same plan check
                            String result = reg.upgradePlan(selectedPlan);
                            JOptionPane.showMessageDialog(null, result, "Upgrade Result", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Only Regular Members can upgrade their plan.", "Invalid Member Type", JOptionPane.ERROR_MESSAGE);
                        }

                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found.", "Not Found", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }//calculate discount
        else if (e.getSource() == btnCalculatePrem) {
            String idStr = tfIdPrem.getText();

            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID.", "Missing Field", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                boolean found = false;

                for (GymMember member : al) {
                    if (member.getId() == id) {
                        found = true;

                        if (member instanceof PremiumMember) {
                            PremiumMember prem = (PremiumMember) member;

                            if (prem.getFullPayment()) {
                                prem.calculateDiscount(); // Sets discountAmount internally
                                double discount = prem.getDiscountAmount();

                                tfDiscountPrem.setText("Rs. " + discount);

                                JOptionPane.showMessageDialog(null,
                                    "You have received a 10% discount of Rs. " + discount,
                                    "Discount Applied", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                tfDiscountPrem.setText("");

                                JOptionPane.showMessageDialog(null,
                                    "You need to complete the full payment to receive a discount.",
                                    "Payment Incomplete", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            tfDiscountPrem.setText("");

                            JOptionPane.showMessageDialog(null,
                                "Only Premium Members are eligible for discounts.",
                                "Invalid Member Type", JOptionPane.ERROR_MESSAGE);
                        }

                        break;
                    }
                }

                if (!found) {
                    tfDiscountPrem.setText("");

                    JOptionPane.showMessageDialog(null,
                        "Member ID not found.",
                        "Invalid ID", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                tfDiscountPrem.setText("");

                JOptionPane.showMessageDialog(null,
                    "Please enter a valid numeric Member ID.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }//pay due amount
        else if (e.getSource() == btnPayPrem) {
            String idStr = tfIdPrem.getText();         // Text field for Member ID
            String payStr = tfPaidPrem.getText();     // Text field for payment amount

            if (idStr.isEmpty() || payStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both Member ID and amount.", "Missing Fields", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                double payAmount = Double.parseDouble(payStr);

                boolean found = false;

                for (GymMember member : al) {
                    if (member.getId() == id) {
                        found = true;

                        if (member instanceof PremiumMember) {
                            PremiumMember prem = (PremiumMember) member;

                            String message = prem.payDueAmount(payAmount);

                            // Show result in a dialog
                            JOptionPane.showMessageDialog(null, message, "Payment Result", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Only Premium Members can pay due amounts.", "Invalid Member Type", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found.", "Not Found", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == btnClearReg) {
            // Clear Regular Member fields only
            tfId.setText("");
            tfName.setText("");
            tfLocation.setText("");
            tfPhone.setText("");
            tfEmail.setText("");
            tfReferral.setText("");
            tfRemoval.setText("");
            tfLoyalty.setText("");

            bg.clearSelection();  // Clear gender selection

            cbYear.setSelectedIndex(0);
            cbMonth.setSelectedIndex(0);
            cbDay.setSelectedIndex(0);

            comboYear.setSelectedIndex(0);
            comboMonth.setSelectedIndex(0);
            comboDay.setSelectedIndex(0);
        }

        else if (e.getSource() == btnClearPrem) {
            // Clear Premium Member fields only
            tfIdPrem.setText("");
            tfNamePrem.setText("");
            tfLocationPrem.setText("");
            tfPhonePrem.setText("");
            tfEmailPrem.setText("");
            tfPaidPrem.setText("");
            tfTrainer.setText("");
            tfRemovalPrem.setText("");
            tfDiscountPrem.setText("");
            tfLoyaltyPrem.setText("");

            bg1.clearSelection();  // Clear gender selection

            cbYearPrem.setSelectedIndex(0);
            cbMonthPrem.setSelectedIndex(0);
            cbDayPrem.setSelectedIndex(0);

            comboYearPrem.setSelectedIndex(0);
            comboMonthPrem.setSelectedIndex(0);
            comboDayPrem.setSelectedIndex(0);

            cbPlan.setSelectedIndex(0);  // Reset plan combo box
        }//display
        else if (e.getSource() == btnDisplayReg||e.getSource()==btnDisplayPrem) {  // Assuming you have a combined display button
            JFrame displayFrame = new JFrame("All Members");
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setBounds(10, 10, 660, 640);  // Leave some padding inside frame

            if (al.isEmpty()) {
                textArea.setText("No members to display.");
            } else {
                // Append details of all members, both Regular and Premium
                for (GymMember member : al) {
                    if (member instanceof RegularMember) {
                        RegularMember reg = (RegularMember) member;
                        // Assuming your display() method prints to console, we build string manually here
                        textArea.append("Regular Member:\n");
                        textArea.append("ID: " + reg.getId() + "\n");
                        textArea.append("Name: " + reg.getName() + "\n");
                        textArea.append("Location: " + reg.getLocation() + "\n");
                        textArea.append("Phone: " + reg.getPhone() + "\n");
                        textArea.append("Email: " + reg.getEmail() + "\n");
                        textArea.append("Gender: " + reg.getGender() + "\n");
                        textArea.append("DOB: " + reg.getDob() + "\n");
                        textArea.append("Membership Start Date: " + reg.getMembershipStartDate() + "\n");
                        textArea.append("Attendance: " + reg.getAttendance() + "\n");
                        textArea.append("Loyalty Points: " + reg.getLoyaltyPoints() + "\n");
                        textArea.append("Active Status: " + (reg.getActiveStatus() ? "Active" : "Inactive") + "\n");
                        textArea.append("Plan: " + reg.getPlan() + "\n");
                        textArea.append("Price: " + reg.getPrice() + "\n");
                        if (reg.getRemovalReason() != null && !reg.getRemovalReason().isEmpty()) {
                            textArea.append("Removal Reason: " + reg.getRemovalReason() + "\n");
                        }
                        textArea.append("-------------------------------\n\n");

                    } else if (member instanceof PremiumMember) {
                        PremiumMember prem = (PremiumMember) member;
                        textArea.append("Premium Member:\n");
                        textArea.append("ID: " + prem.getId() + "\n");
                        textArea.append("Name: " + prem.getName() + "\n");
                        textArea.append("Location: " + prem.getLocation() + "\n");
                        textArea.append("Phone: " + prem.getPhone() + "\n");
                        textArea.append("Email: " + prem.getEmail() + "\n");
                        textArea.append("Gender: " + prem.getGender() + "\n");
                        textArea.append("DOB: " + prem.getDob() + "\n");
                        textArea.append("Membership Start Date: " + prem.getMembershipStartDate() + "\n");
                        textArea.append("Attendance: " + prem.getAttendance() + "\n");
                        textArea.append("Loyalty Points: " + prem.getLoyaltyPoints() + "\n");
                        textArea.append("Active Status: " + (prem.getActiveStatus() ? "Active" : "Inactive") + "\n");
                        textArea.append("Personal Trainer: " + prem.getPersonalTrainer() + "\n");
                        textArea.append("Paid Amount: " + prem.getPaidAmount() + "\n");
                        textArea.append("Is Full Payment: " + (prem.getFullPayment() ? "Yes" : "No") + "\n");
                        double remaining = prem.getPremiumCharge() - prem.getPaidAmount();
                        textArea.append("Remaining Amount to be Paid: " + remaining + "\n");
                        if (prem.getFullPayment()) {
                            textArea.append("Discount Amount: " + prem.getDiscountAmount() + "\n");
                        }
                        textArea.append("-------------------------------\n\n");
                    }
                }

            }

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setBounds(10, 10, 660, 600); // Reduced height to make space for Back button
            displayFrame.add(scrollPane);

            JButton btnBack = new JButton("Back");
            btnBack.setBounds(300, 620, 100, 30); // Placed clearly below the scrollPane
            displayFrame.add(btnBack);

            btnBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        displayFrame.dispose();  // close the frame
                    }
                });
            displayFrame.setLayout(null);
            displayFrame.setVisible(true);
            displayFrame.setSize(700, 700);

        }//save
        else if (source == btnSaveReg || source == btnSavePrem) {
            try {
                String fileName = (source == btnSaveReg) ? "RegularMembers.txt" : "PremiumMembers.txt";
                File file = new File(fileName);

                FileWriter writer = new FileWriter(file); // **overwrite mode**

                // Write header every time
                String header = String.format(
                        "%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-10s %-10s %-15s %-15s %-20s\n",
                        "ID", "Name", "Location", "Phone", "Email", "Membership Date",
                        "Plan", "Price", "Attendance", "Loyalty", "Active", "Full Payment",
                        "Discount", "Net Paid"
                    );
                writer.write(header);
                writer.write("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

                for (GymMember m : al) {
                    boolean isRegular = (m instanceof RegularMember);
                    boolean isPremium = (m instanceof PremiumMember);

                    if ((source == btnSaveReg && isRegular) || (source == btnSavePrem && isPremium)) {
                        String plan = "-", price = "-", attendance = "-", loyalty = "-", fullPayment = "-", discount = "-", netPaid = "-";

                        if (isRegular) {
                            RegularMember rm = (RegularMember) m;
                            plan = rm.getPlan();
                            price = String.valueOf(rm.getPlanPrice(rm.getPlan()));
                            attendance = String.valueOf(rm.getAttendance());
                            loyalty = String.valueOf(rm.getLoyaltyPoints());
                        }

                        if (isPremium) {
                            PremiumMember pm = (PremiumMember) m;
                            price = String.valueOf(pm.getPremiumCharge());
                            fullPayment = pm.getFullPayment() ? "true" : "false";
                            discount = String.valueOf(pm.getDiscountAmount());
                            netPaid = String.valueOf(pm.getPaidAmount());
                            attendance = String.valueOf(pm.getAttendance());
                            loyalty = String.valueOf(pm.getLoyaltyPoints());
                        }

                        String line = String.format(
                                "%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-10s %-10s %-15s %-15s %-20s\n",
                                m.getId(), m.getName(), m.getLocation(), m.getPhone(), m.getEmail(), m.getMembershipStartDate(),
                                plan, price, attendance, loyalty, m.getActiveStatus() ? "Yes" : "No", fullPayment, discount, netPaid
                            );
                        writer.write(line);
                    }
                }

                writer.close();
                JOptionPane.showMessageDialog(null, fileName + " saved successfully .");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error writing to file: " + ex.getMessage());
            }
        }//read

        else if (source == btnReadReg || source == btnReadPrem) {
            String fileName = (source == btnReadReg) ? "RegularMembers.txt" : "PremiumMembers.txt";
            File file = new File(fileName);

            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, fileName + " does not exist.");
                return;
            }

            try {
                FileReader fr = new FileReader(file);
                StringBuilder content = new StringBuilder();

                int ch;
                while ((ch = fr.read()) != -1) {
                    content.append((char) ch);
                }

                fr.close();

                // Create a new JFrame to display the content
                JFrame frame = new JFrame((source == btnReadReg) ? "Regular Members" : "Premium Members");

                JTextArea textArea = new JTextArea();
                textArea.setEditable(false);
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

                textArea.setText(content.toString());  // <-- Set content here

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setBounds(10, 10, 760, 500);  // reduce height to leave space for button
                frame.add(scrollPane);

                JButton btnBack = new JButton("Back");
                btnBack.setBounds(350, 520, 100, 30);  // position below scroll pane
                frame.add(btnBack);

                
                btnBack.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            frame.dispose();  // close the frame
                        }
                    });
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setSize(800, 600);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        new GymGUI();
    }
}


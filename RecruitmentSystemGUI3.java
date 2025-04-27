import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;


public class RecruitmentSystemGUI3 {
    private JFrame frame;
    private JPanel fullTimePanel, partTimePanel, buttonPanel;
    // Full-time fields
    private JTextField vacancyNumberField, designationField, jobTypeField, staffNameField, joiningDateField, qualificationField, appointedByField;
    private JTextField salaryField, weeklyFractionalHoursField;
    private java.util.List<FullTimeStaffHire> fullTimeStaffList = new ArrayList<>();

    // Part-time fields
    private JTextField ptVacancyNumberField, ptDesignationField, ptJobTypeField, ptStaffNameField, ptJoiningDateField, ptQualificationField, ptAppointedByField;
    private JTextField workingHourField, wagesPerHourField, shiftsField;
    private java.util.List<PartTimeStaffHire> partTimeStaffList = new ArrayList<>();
    
    private JButton addFullTimeButton, addPartTimeButton, setSalaryButton, setShiftsButton, terminateButton, displayButton, clearButton;
     
    public RecruitmentSystemGUI3() {
        frame = new JFrame("Recruitment System");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1)); // 3 rows now: FullTime, PartTime, Buttons

        // Full-Time Staff Panel
        fullTimePanel = new JPanel(new GridLayout(6, 2, 5, 5));
        fullTimePanel.setBorder(BorderFactory.createTitledBorder("Full-Time Staff"));
        vacancyNumberField = new JTextField();
        designationField = new JTextField();
        jobTypeField = new JTextField();
        staffNameField = new JTextField();
        joiningDateField = new JTextField();
        qualificationField = new JTextField();
        appointedByField = new JTextField();
        salaryField = new JTextField();
        weeklyFractionalHoursField = new JTextField();
        
        fullTimePanel.add(new JLabel("Vacancy Number:"));
        fullTimePanel.add(vacancyNumberField);
        fullTimePanel.add(new JLabel("Designation:"));
        fullTimePanel.add(designationField);
        fullTimePanel.add(new JLabel("Job Type:"));
        fullTimePanel.add(jobTypeField);
        fullTimePanel.add(new JLabel("Staff Name:"));
        fullTimePanel.add(staffNameField);
        fullTimePanel.add(new JLabel("Joining Date:"));
        fullTimePanel.add(joiningDateField);
        fullTimePanel.add(new JLabel("Qualification:"));
        fullTimePanel.add(qualificationField);
        fullTimePanel.add(new JLabel("Appointed By:"));
        fullTimePanel.add(appointedByField);
        fullTimePanel.add(new JLabel("Salary:"));
        fullTimePanel.add(salaryField);
        fullTimePanel.add(new JLabel("Weekly Hours:"));
        fullTimePanel.add(weeklyFractionalHoursField);
        
        addFullTimeButton = new JButton("Add Full Time Staff");
        setSalaryButton = new JButton("Set Salary");
        fullTimePanel.add(addFullTimeButton);
        fullTimePanel.add(setSalaryButton);
        
        // Action listener for Add Full Time Staff
   addFullTimeButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (isValidFullTimeInput()) {
            int vacancy = Integer.parseInt(vacancyNumberField.getText().trim());
            // ✅ Duplicate check for full-time list
            for (FullTimeStaffHire staff : fullTimeStaffList) {
                if (staff.getVacancyNumber() == vacancy) {
                    JOptionPane.showMessageDialog(frame, "This vacancy number is already taken.");
                    return; // Prevent adding duplicate
                }
            }
            String designation = designationField.getText().trim();
            String jobType = jobTypeField.getText().trim();
            String staffName = staffNameField.getText().trim();
            String joiningDate = joiningDateField.getText().trim();
            String qualification = qualificationField.getText().trim();
            String appointedBy = appointedByField.getText().trim();
            double salary = Double.parseDouble(salaryField.getText().trim());
            int hours = Integer.parseInt(weeklyFractionalHoursField.getText().trim());

            FullTimeStaffHire staff = new FullTimeStaffHire(
                vacancy, designation, jobType, staffName, joiningDate,
                qualification, appointedBy, true, salary, hours
            );

            fullTimeStaffList.add(staff);
            JOptionPane.showMessageDialog(frame, "Full-Time Staff added successfully!");
            clearFields();
        }
    }
});

        
        // Part-Time Staff Panel
        partTimePanel = new JPanel(new GridLayout(7, 2, 5, 5));
        partTimePanel.setBorder(BorderFactory.createTitledBorder("Part-Time Staff"));
        
        // Separate JTextFields for part-time staff
        ptVacancyNumberField = new JTextField();
        ptDesignationField = new JTextField();
        ptJobTypeField = new JTextField();
        ptStaffNameField = new JTextField();
        ptJoiningDateField = new JTextField();
        ptQualificationField = new JTextField();
        ptAppointedByField = new JTextField();
        workingHourField = new JTextField();
        wagesPerHourField = new JTextField(); 
        shiftsField = new JTextField();     

        // Add fields to the part-time panel
        partTimePanel.add(new JLabel("Vacancy Number:"));
        partTimePanel.add(ptVacancyNumberField);
        partTimePanel.add(new JLabel("Designation:"));
        partTimePanel.add(ptDesignationField);
        partTimePanel.add(new JLabel("Job Type:"));
        partTimePanel.add(ptJobTypeField);
        partTimePanel.add(new JLabel("Staff Name:"));
        partTimePanel.add(ptStaffNameField);
        partTimePanel.add(new JLabel("Joining Date:"));
        partTimePanel.add(ptJoiningDateField);
        partTimePanel.add(new JLabel("Qualification:"));
        partTimePanel.add(ptQualificationField);
        partTimePanel.add(new JLabel("Appointed By:"));
        partTimePanel.add(ptAppointedByField);
        partTimePanel.add(new JLabel("Working Hours:"));
        partTimePanel.add(workingHourField);
        partTimePanel.add(new JLabel("Wages Per Hour:"));
        partTimePanel.add(wagesPerHourField);
        partTimePanel.add(new JLabel("Shifts:"));
        partTimePanel.add(shiftsField);
        
        addPartTimeButton = new JButton("Add Part Time Staff");
        setShiftsButton = new JButton("Set Shifts");
        terminateButton = new JButton("Terminate Staff");
        
        partTimePanel.add(addPartTimeButton);
        partTimePanel.add(setShiftsButton);
        partTimePanel.add(terminateButton);
       
        // Action listener for Add Part Time Staff
        addPartTimeButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (isValidPartTimeInput()) {
            int vacancy = Integer.parseInt(ptVacancyNumberField.getText().trim());
            // ✅ Duplicate check for part-time list
            for (PartTimeStaffHire staff : partTimeStaffList) {
                if (staff.getVacancyNumber() == vacancy) {
                    JOptionPane.showMessageDialog(frame, "This vacancy number is already taken.");
                    return; // Prevent adding duplicate
                }
            }
            String designation = ptDesignationField.getText().trim();
            String jobType = ptJobTypeField.getText().trim();
            String staffName = ptStaffNameField.getText().trim();
            String joiningDate = ptJoiningDateField.getText().trim();
            String qualification = ptQualificationField.getText().trim();
            String appointedBy = ptAppointedByField.getText().trim();
            int workingHour = Integer.parseInt(workingHourField.getText().trim());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText().trim());
            String shifts = shiftsField.getText().trim();

            PartTimeStaffHire staff = new PartTimeStaffHire(
                vacancy, designation, jobType,
                staffName, joiningDate, qualification,
                appointedBy, true, workingHour, wagesPerHour, shifts
            );

            partTimeStaffList.add(staff);
            JOptionPane.showMessageDialog(frame, "Part-Time Staff added successfully!");
            clearFields();
        }
    }
});

        
        // Buttons Panel (for Display and Clear)
        buttonPanel = new JPanel(new FlowLayout());
        displayButton = new JButton("Display Staff");
        buttonPanel.add(displayButton);
        clearButton = new JButton("Clear Fields");
        buttonPanel.add(clearButton);

        // Adding panels to frame
        frame.add(fullTimePanel);
        frame.add(partTimePanel);
        frame.add(buttonPanel);
        
        // Add the button listeners
        addButtonActions(); 
        
        frame.setVisible(true);
        
        
        // === Menu Bar Setup ===
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem saveItem = new JMenuItem("Save Records");
        JMenuItem loadItem = new JMenuItem("Load Records");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem exportItem = new JMenuItem("Export to Text File");
        fileMenu.add(exportItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);
        
        // === Menu Actions - adding Save and Load Functionalities) ===
        saveItem.addActionListener(e -> {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("staffData.ser"))) {
        StaffData data = new StaffData(fullTimeStaffList, partTimeStaffList);
        oos.writeObject(data);
        JOptionPane.showMessageDialog(frame, "Staff records saved successfully.");
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error saving records: " + ex.getMessage());
    }
});

        loadItem.addActionListener(e -> {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("staffData.ser"))) {
        StaffData data = (StaffData) ois.readObject();

        // Replace current staff lists with loaded ones
        fullTimeStaffList = data.getFullTimeStaffList();
        partTimeStaffList = data.getPartTimeStaffList();

        JOptionPane.showMessageDialog(frame, "Staff records loaded successfully.");

        // Optionally show the loaded data immediately:
        displayButton.doClick();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error loading records: " + ex.getMessage());
    }
});

        exportItem.addActionListener(e -> {
    try {
        FileWriter writer = new FileWriter("staff_export.txt");
        writer.write("=== Full-Time Staff ===\n");
        for (FullTimeStaffHire staff : fullTimeStaffList) {
            writer.write("Vacancy Number: " + staff.getVacancyNumber() + "\n");
            writer.write("Name: " + staff.getStaffName() + "\n");
            writer.write("Designation: " + staff.getDesignation() + "\n");
            writer.write("Salary: " + staff.getSalary() + "\n");
            writer.write("Hours: " + staff.getWeeklyFractionalHours() + "\n");
            writer.write("--------------------------\n");
        }

        writer.write("\n=== Part-Time Staff ===\n");
        for (PartTimeStaffHire staff : partTimeStaffList) {
            writer.write("Vacancy Number: " + staff.getVacancyNumber() + "\n");
            writer.write("Name: " + staff.getStaffName() + "\n");
            writer.write("Designation: " + staff.getDesignation() + "\n");
            writer.write("Wages/Hour: " + staff.getWagesPerHour() + "\n");
            writer.write("Working Hours: " + staff.getWorkingHour() + "\n");
            writer.write("Shifts: " + staff.getShifts() + "\n");
            writer.write("Terminated: " + staff.getTerminated() + "\n");
            writer.write("Income per Day: " + (staff.getWagesPerHour() * staff.getWorkingHour()) + "\n");
            writer.write("--------------------------\n");
        }

        writer.close();
        JOptionPane.showMessageDialog(frame, "Staff exported to staff_export.txt successfully.");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(frame, "Error exporting staff data: " + ex.getMessage());
        ex.printStackTrace();
    }
});
    
// Placeholders for Exit and About Menu Items
        exitItem.addActionListener(e -> System.exit(0));
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Recruitment System v1.0\nCreated by Ann :)"));
    
        frame.setVisible(true);
    }
    private void addButtonActions() {
        
        setSalaryButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int vacancy = Integer.parseInt(vacancyNumberField.getText().trim());
            double newSalary = Double.parseDouble(salaryField.getText().trim());

            boolean found = false;
            for (FullTimeStaffHire staff : fullTimeStaffList) {
                if (staff.getVacancyNumber() == vacancy) {
                    staff.setSalary(newSalary);  // Must be implemented in FullTimeStaffHire
                    JOptionPane.showMessageDialog(frame, "Salary updated successfully.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "No full-time staff found with vacancy number " + vacancy);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid vacancy number and salary.");
        }
    }
});

        setShiftsButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int vacancy = Integer.parseInt(ptVacancyNumberField.getText().trim());
            String newShift = shiftsField.getText().trim();

            boolean found = false;
            for (PartTimeStaffHire staff : partTimeStaffList) {
                if (staff.getVacancyNumber() == vacancy) {
                    staff.setShifts(newShift);  // Must be implemented in PartTimeStaffHire
                    JOptionPane.showMessageDialog(frame, "Shifts updated successfully.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "No part-time staff found with vacancy number " + vacancy);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid vacancy number.");
        }
    }
});


        terminateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int vacancy = Integer.parseInt(ptVacancyNumberField.getText().trim());

            boolean found = false;
            for (PartTimeStaffHire staff : partTimeStaffList) {
                if (staff.getVacancyNumber() == vacancy) {
                    if (!staff.getTerminated()) {
                        staff.terminateStaff();  // Must reset fields & set terminated = true
                        JOptionPane.showMessageDialog(frame, "Part-Time Staff terminated.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Staff is already terminated.");
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "No part-time staff found with vacancy number " + vacancy);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid vacancy number.");
        }
    }
});


        displayButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (fullTimeStaffList.isEmpty() && partTimeStaffList.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No staff records to display.");
            return;
        }

        StringBuilder builder = new StringBuilder();

        // --- Full-Time Staff ---
        if (!fullTimeStaffList.isEmpty()) {
            builder.append("=== Full-Time Staff ===\n\n");
            for (FullTimeStaffHire staff : fullTimeStaffList) {
                builder.append("Vacancy: ").append(staff.getVacancyNumber()).append("\n")
                       .append("Name: ").append(staff.getStaffName()).append("\n")
                       .append("Designation: ").append(staff.getDesignation()).append("\n")
                       .append("Salary: ").append(staff.getSalary()).append("\n")
                       .append("Hours: ").append(staff.getWeeklyFractionalHours()).append("\n")
                       .append("--------------------------\n");
            }
        }

        // --- Part-Time Staff ---
        if (!partTimeStaffList.isEmpty()) {
            builder.append("\n=== Part-Time Staff ===\n\n");
            for (PartTimeStaffHire staff : partTimeStaffList) {
                builder.append("Vacancy: ").append(staff.getVacancyNumber()).append("\n")
                       .append("Name: ").append(staff.getStaffName()).append("\n")
                       .append("Designation: ").append(staff.getDesignation()).append("\n")
                       .append("Wages/Hour: ").append(staff.getWagesPerHour()).append("\n")
                       .append("Working Hours: ").append(staff.getWorkingHour()).append("\n")
                       .append("Shifts: ").append(staff.getShifts()).append("\n")
                       .append("Terminated: ").append(staff.getTerminated()).append("\n")
                       .append("Income per Day: ").append(staff.getWagesPerHour() * staff.getWorkingHour()).append("\n")
                       .append("--------------------------\n");
            }
        }

        JTextArea textArea = new JTextArea(builder.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 350));

        JOptionPane.showMessageDialog(frame, scrollPane, "All Staff Records", JOptionPane.INFORMATION_MESSAGE);
    }
});
    clearButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        clearFields();
    }
});
    
    }

   private boolean isValidFullTimeInput() {
    System.out.println("Checking fields...");

System.out.println("Vacancy Number: '" + vacancyNumberField.getText() + "'");
System.out.println("Designation: '" + designationField.getText() + "'");
System.out.println("Job Type: '" + jobTypeField.getText() + "'");
System.out.println("Staff Name: '" + staffNameField.getText() + "'");
System.out.println("Joining Date: '" + joiningDateField.getText() + "'");
System.out.println("Qualification: '" + qualificationField.getText() + "'");
System.out.println("Appointed By: '" + appointedByField.getText() + "'");
System.out.println("Salary: '" + salaryField.getText() + "'");
System.out.println("Weekly Hours: '" + weeklyFractionalHoursField.getText() + "'");

if (vacancyNumberField.getText().trim().isEmpty()) {
    System.out.println("Vacancy Number is empty");
}
if (designationField.getText().trim().isEmpty()) {
    System.out.println("Designation is empty");
}
if (jobTypeField.getText().trim().isEmpty()) {
    System.out.println("Job Type is empty");
}
if (staffNameField.getText().trim().isEmpty()) {
    System.out.println("Staff Name is empty");
}
if (joiningDateField.getText().trim().isEmpty()) {
    System.out.println("Joining Date is empty");
}
if (qualificationField.getText().trim().isEmpty()) {
    System.out.println("Qualification is empty");
}
if (appointedByField.getText().trim().isEmpty()) {
    System.out.println("Appointed By is empty");
}
if (salaryField.getText().trim().isEmpty()) {
    System.out.println("Salary is empty");
}
if (weeklyFractionalHoursField.getText().trim().isEmpty()) {
    System.out.println("Weekly Hours is empty");
}

    
    // Step 1: Trim and check empty fields
    if (vacancyNumberField.getText().trim().isEmpty() ||
        designationField.getText().trim().isEmpty() ||
        jobTypeField.getText().trim().isEmpty() ||
        staffNameField.getText().trim().isEmpty() ||
        joiningDateField.getText().trim().isEmpty() ||
        qualificationField.getText().trim().isEmpty() ||
        appointedByField.getText().trim().isEmpty() ||
        salaryField.getText().trim().isEmpty() ||
        weeklyFractionalHoursField.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(frame, "Please fill out all Full-Time fields.");
        return false;
    }

    // Step 2: Parse numeric fields safely
    try {
        Integer.parseInt(vacancyNumberField.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Vacancy Number must be a valid whole number.");
        return false;
    }

    try {
        Double.parseDouble(salaryField.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Salary must be a valid number.");
        return false;
    }

    try {
        Integer.parseInt(weeklyFractionalHoursField.getText().trim()); // whole number, use int
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Weekly Hours must be a valid whole number.");
        return false;
    }

    return true;
}
     
    private boolean isValidPartTimeInput() {
    
        System.out.println("Checking Part-Time fields...");

    System.out.println("Vacancy Number: '" + ptVacancyNumberField.getText() + "'");
    System.out.println("Designation: '" + ptDesignationField.getText() + "'");
    System.out.println("Job Type: '" + ptJobTypeField.getText() + "'");
    System.out.println("Staff Name: '" + ptStaffNameField.getText() + "'");
    System.out.println("Joining Date: '" + ptJoiningDateField.getText() + "'");
    System.out.println("Qualification: '" + ptQualificationField.getText() + "'");
    System.out.println("Appointed By: '" + ptAppointedByField.getText() + "'");
    System.out.println("Working Hours: '" + workingHourField.getText() + "'");
    System.out.println("Wages Per Hour: '" + wagesPerHourField.getText() + "'");
    System.out.println("Shifts: '" + shiftsField.getText() + "'");

    if (ptVacancyNumberField.getText().trim().isEmpty()) {
        System.out.println("Vacancy Number is empty");
    }
    if (ptDesignationField.getText().trim().isEmpty()) {
        System.out.println("Designation is empty");
    }
    if (ptJobTypeField.getText().trim().isEmpty()) {
        System.out.println("Job Type is empty");
    }
    if (ptStaffNameField.getText().trim().isEmpty()) {
        System.out.println("Staff Name is empty");
    }
    if (ptJoiningDateField.getText().trim().isEmpty()) {
        System.out.println("Joining Date is empty");
    }
    if (ptQualificationField.getText().trim().isEmpty()) {
        System.out.println("Qualification is empty");
    }
    if (ptAppointedByField.getText().trim().isEmpty()) {
        System.out.println("Appointed By is empty");
    }
    if (workingHourField.getText().trim().isEmpty()) {
        System.out.println("Working Hours is empty");
    }
    if (wagesPerHourField.getText().trim().isEmpty()) {
        System.out.println("Wages Per Hour is empty");
    }
    if (shiftsField.getText().trim().isEmpty()) {
        System.out.println("Shifts is empty");
    }
    
       
    if (ptVacancyNumberField.getText().trim().isEmpty() ||
        ptDesignationField.getText().trim().isEmpty() ||
        ptJobTypeField.getText().trim().isEmpty() ||
        ptStaffNameField.getText().trim().isEmpty() ||
        ptJoiningDateField.getText().trim().isEmpty() ||
        ptQualificationField.getText().trim().isEmpty() ||
        ptAppointedByField.getText().trim().isEmpty() ||
        workingHourField.getText().trim().isEmpty() ||
        wagesPerHourField.getText().trim().isEmpty() ||
        shiftsField.getText().trim().isEmpty()) {
        
        JOptionPane.showMessageDialog(frame, "Please fill out all Part-Time fields.");
        return false;
    }

    try {
        Integer.parseInt(ptVacancyNumberField.getText().trim());
        Integer.parseInt(workingHourField.getText().trim());
        Double.parseDouble(wagesPerHourField.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Vacancy Number, Working Hours, and Wages must be valid numbers.");
        return false;
    }

    return true;
}


    private void clearFields() {
    // Full-Time Fields
    vacancyNumberField.setText("");
    designationField.setText("");
    jobTypeField.setText("");
    staffNameField.setText("");
    joiningDateField.setText("");
    qualificationField.setText("");
    appointedByField.setText("");
    salaryField.setText("");
    weeklyFractionalHoursField.setText("");

    // Part-Time Fields
    ptVacancyNumberField.setText("");
    ptDesignationField.setText("");
    ptJobTypeField.setText("");
    ptStaffNameField.setText("");
    ptJoiningDateField.setText("");
    ptQualificationField.setText("");
    ptAppointedByField.setText("");
    workingHourField.setText("");
    wagesPerHourField.setText("");
    shiftsField.setText("");
}
   
    
    public static void main(String[] args) {
        new RecruitmentSystemGUI3();
    }
}
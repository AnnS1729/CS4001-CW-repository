import java.io.Serializable;

public class PartTimeStaffHire extends StaffHire implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName,
                             String joiningDate, String qualification, String appointedBy, boolean joined,
                             int workingHour, double wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public double getWagesPerHour() {
        return wagesPerHour;
    }

    public String getShifts() {
        return shifts;
    }

    public boolean getTerminated() {
        return terminated;
    }

    public void setShifts(String newShifts) {
        if (getJoined()) {
            this.shifts = newShifts;
        } else {
            System.out.println("Cannot change shifts. Staff not yet joined.");
        }
    }

    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff already terminated.");
        } else {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            this.terminated = true;
        }
    }

    @Override
    public void display() {
        super.display();
        if (getJoined()) {
            System.out.println("Working Hours: " + workingHour);
            System.out.println("Wages Per Hour: " + wagesPerHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Terminated: " + terminated);
            System.out.println("Daily Income: " + (workingHour * wagesPerHour));
        }
    }
}

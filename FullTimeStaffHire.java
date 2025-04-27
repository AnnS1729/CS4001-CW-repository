import java.io.Serializable;

public class FullTimeStaffHire extends StaffHire implements Serializable {
    private static final long serialVersionUID = 1L;
    private double salary;
    private int weeklyFractionalHours;

    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName,
                             String joiningDate, String qualification, String appointedBy, boolean joined,
                             double salary, int weeklyFractionalHours) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    public double getSalary() {
        return salary;
    }

    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    public void setSalary(double newSalary) {
        if (super.getJoined()) {
            this.salary = newSalary;
        } else {
            System.out.println("Staff not joined. Cannot update salary.");
        }
    }

    public void setWeeklyFractionalHours(int newHours) {
        this.weeklyFractionalHours = newHours;
    }

    @Override
    public void display() {
        super.display();
        if (getJoined()) {
            System.out.println("Salary: " + salary);
            System.out.println("Weekly Hours: " + weeklyFractionalHours);
        }
    }
}

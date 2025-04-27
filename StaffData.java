import java.io.Serializable;
import java.util.List;

public class StaffData implements Serializable {
    private List<FullTimeStaffHire> fullTimeStaffList;
    private List<PartTimeStaffHire> partTimeStaffList;

    public StaffData(List<FullTimeStaffHire> fullTimeStaffList, List<PartTimeStaffHire> partTimeStaffList) {
        this.fullTimeStaffList = fullTimeStaffList;
        this.partTimeStaffList = partTimeStaffList;
    }

    // ✅ Add these getter methods:
    public List<FullTimeStaffHire> getFullTimeStaffList() {
        return fullTimeStaffList;
    }

    public List<PartTimeStaffHire> getPartTimeStaffList() {
        return partTimeStaffList;
    }
}

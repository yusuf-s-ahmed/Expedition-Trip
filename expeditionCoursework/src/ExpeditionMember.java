public class ExpeditionMember {

    // Fields
    private String memberName;
    private int studentID;
    public static int member_counter = 0;

    // Constructor
    public ExpeditionMember(String memberName, int studentID) {
         this.memberName = memberName;
         this.studentID = studentID;
         member_counter++;
    }

    // Setters & Getters
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberID(int studentID) {
        this.studentID = studentID;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public int getMemberID() {
        return this.studentID;
    }

}

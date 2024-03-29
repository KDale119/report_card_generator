import java.util.HashMap;
import java.util.Map;

public class Student {
    private String firstName;


    private String lastName;

    private Map<String, Double> assignmentToGrade = new HashMap<>();

//    public Student() {
//    } can keep empty so can have constructor or dont

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Double> getAssignmentToGrade() {
        return assignmentToGrade;
    }

    public void setAssignmentToGrade(Map<String, Double> assignmentToGrade) {
        this.assignmentToGrade = assignmentToGrade;
    }
}

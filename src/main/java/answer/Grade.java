package answer;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Grade {
    private Student student;
    private Exam exam;
    private Course course;
    private double initialGrade;
    private List<GradeChange> history = new ArrayList<>();

    public Grade(Student student, Exam exam, double initialGrade) {
        this.student = student;
        this.exam = exam;
        this.course = exam.getCourse();
        this.initialGrade = initialGrade;
    }

    public void addChange(double newGrade, String reason) {
        history.add(new GradeChange(Instant.now(), newGrade, reason));
    }

    public double getGradeAt(Instant t) {
        double grade = initialGrade;

        for (GradeChange change : history) {
            if (change.getTimestamp().isBefore(t) || change.getTimestamp().equals(t)) {
                grade = change.getNewGrade();
            }
        }
        return grade;
    }
}
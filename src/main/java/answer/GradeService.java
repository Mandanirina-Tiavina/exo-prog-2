package answer;

import java.time.Instant;
import java.util.List;

public class GradeService {

    public double getExamGrade(Exam exam, Student student, Instant t) {
        if (exam == null || student == null || t == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }

        List<Grade> grades = student.getGrades();

        for (Grade grade : grades) {
            if (grade.getExam() == exam) {
                return grade.getGradeAt(t);
            }
        }

        throw new IllegalStateException("No grade found for this exam and student");
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        if (course == null || student == null || t == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }

        List<Grade> grades = student.getGrades();
        double sum = 0.0;
        int count = 0;

        for (Grade grade : grades) {
            if (grade.getCourse() == course) {
                sum += grade.getGradeAt(t);
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalStateException("No grade found for this course and student");
        }

        return sum / count;
    }
}


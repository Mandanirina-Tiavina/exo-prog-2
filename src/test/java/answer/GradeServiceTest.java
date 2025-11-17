package answer;

import java.time.Instant;
import java.time.LocalDate;

public class GradeServiceTest {
    public static void main(String[] args) {
        GradeService service = new GradeService();

        Tutor tutor = new Tutor(
                1,
                "Smith",
                "Anna",
                LocalDate.of(1980, 5, 10),
                "anna.smith@example.com",
                "0600000000",
                "Mother"
        );

        Student student = new Student(
                2,
                "Doe",
                "John",
                LocalDate.of(2005, 3, 15),
                "john.doe@example.com",
                "0700000000",
                "PROG2-G1",
                tutor
        );

        Teacher teacher = new Teacher(
                3,
                "Brown",
                "Emily",
                LocalDate.of(1975, 11, 20),
                "emily.brown@example.com",
                "0800000000",
                TeacherSpeciality.Back_end
        );

        Course course = new Course(
                10,
                "PROG2",
                5,
                teacher
        );

        Exam midterm = new Exam(1, "Midterm", course);
        Exam finalExam = new Exam(2, "Final", course);

        Grade midtermGrade = new Grade(student, midterm, 14.0);
        Grade finalGrade = new Grade(student, finalExam, 16.0);

        student.getGrades().add(midtermGrade);
        student.getGrades().add(finalGrade);

        midtermGrade.addChange(15.0, "Correction");
        finalGrade.addChange(17.0, "Bonus");

        Instant now = Instant.now();

        double midtermAtNow = service.getExamGrade(midterm, student, now);
        double courseAtNow = service.getCourseGrade(course, student, now);

        if (Math.abs(midtermAtNow - midtermGrade.getGradeAt(now)) > 0.0001) {
            throw new AssertionError("getExamGrade returned wrong value");
        }

        double expectedCourse = (midtermGrade.getGradeAt(now) + finalGrade.getGradeAt(now)) / 2.0;
        if (Math.abs(courseAtNow - expectedCourse) > 0.0001) {
            throw new AssertionError("getCourseGrade returned wrong value");
        }

        System.out.println("All GradeService tests passed.");
    }
}


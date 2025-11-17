package answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exam {
    private int id;
    private String label;
    private Course course;

    public Exam(int id, String label, Course course) {
        this.id = id;
        this.label = label;
        this.course = course;
    }
}


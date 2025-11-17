package answer;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Student extends Person {
    private String group;
    private Tutor tutor;
    public Student(int id, String firstName, String lastName, LocalDate birthDate, String email,String phoneNumber, String group, Tutor tutor) {
        super(id, lastName, firstName, birthDate, email, phoneNumber);
        this.group = group;
        this.tutor = tutor;
    }
}

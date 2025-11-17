package answer;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter

public class Teacher extends Person{
    private TeacherSpeciality speciality;

    public Teacher(int id, String lastName, String firstName, LocalDate birthDate, String email, String phoneNumber, TeacherSpeciality specialty) {
        super(id, lastName, firstName, birthDate, email, phoneNumber);
        this.speciality = specialty;
    }
}

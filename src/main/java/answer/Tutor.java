package answer;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Tutor extends Person{
    private String relationshipDescription;

    public Tutor(int id, String lastName, String firstName, LocalDate birthdate, String email, String phoneNumber, String relationshipDescription) {
        super(id, lastName, firstName, birthdate, email, phoneNumber);
        this.relationshipDescription = relationshipDescription;
    }
}

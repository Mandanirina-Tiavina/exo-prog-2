package answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private int id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
}
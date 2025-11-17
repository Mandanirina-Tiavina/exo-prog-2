package answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Instant;

@Getter
@AllArgsConstructor
public class GradeChange {
    private Instant timestamp;
    private double newGrade;
    private String reason;
}


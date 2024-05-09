package school.sptech.apirestschool.dto.student;

import lombok.Data;

@Data
public class StudentRequest {

    private String ra;
    private String name;
    private Integer professorId;

}

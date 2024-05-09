package school.sptech.apirestschool.dto.student;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import school.sptech.apirestschool.entity.Teacher;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {

    private Integer id;
    private String ra;
    private String name;
    private Teacher teacher;

    // Nested class
    @Data
    @Builder
    public static class Teacher {

        private Integer id;
        private String nome;

    }
}

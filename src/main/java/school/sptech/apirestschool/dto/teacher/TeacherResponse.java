package school.sptech.apirestschool.dto.teacher;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherResponse {

    private Integer id;
    private String name;
    private List<Student> students;

    @Data
    @Builder
    public static class Student {

        private Integer id;
        private String ra;
        private String name;

    }
}

package school.sptech.apirestschool.dto.teacher;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherResponse {

    private Integer id;
    private String name;

}

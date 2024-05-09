package school.sptech.apirestschool.dto.teacher;

import school.sptech.apirestschool.entity.Teacher;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherMapper {

    public static Teacher toEntity(TeacherRequest dto ) {
        if (dto == null) return null;

        Teacher entity = new Teacher();
        entity.setName(dto.getName());
        return entity;
    }

    public static TeacherResponse toDto(Teacher entity) {
        if (entity == null) return null;

        TeacherResponse dto = new TeacherResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        if (entity.getStudents() !=null) {
            dto.setStudents(entity.getStudents().stream()
                    .map(s -> TeacherResponse.Student.builder()
                            .id(s.getId())
                            .ra(s.getRa())
                            .name(s.getName())
                            .build())
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static List<TeacherResponse> toDto(List<Teacher> entities) {
        return entities.stream()
                .map(TeacherMapper::toDto)
                .toList();
    }

}

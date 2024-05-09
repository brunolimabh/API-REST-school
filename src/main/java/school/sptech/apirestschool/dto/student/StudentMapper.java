package school.sptech.apirestschool.dto.student;

import school.sptech.apirestschool.entity.Student;
import school.sptech.apirestschool.entity.Teacher;

import java.util.List;

public class StudentMapper {

    public static Student toEntity(StudentRequest dto ) {
        if (dto == null) return null;

        Student entity = new Student();
        entity.setName(dto.getName());
        entity.setRa(dto.getRa());
        return entity;
    }

    public static StudentResponse toDto(Student entity) {
        if (entity == null) return null;

        StudentResponse dto = new StudentResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setName(entity.getName());
        dto.setRa(entity.getRa());
        dto.setTeacher(StudentResponse.Teacher.builder()
                .id(entity.getTeacher().getId())
                .nome(entity.getTeacher().getName())
                .build());
        return dto;
    }

    public static List<StudentResponse> toDto(List<Student> entities) {
        return entities.stream()
                .map(StudentMapper::toDto)
                .toList();
    }

}

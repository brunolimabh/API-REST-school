package school.sptech.apirestschool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RemoveTeacherWithStudentException extends RuntimeException{

    public RemoveTeacherWithStudentException() {
        super("teacher has a bond with student");
    }

}

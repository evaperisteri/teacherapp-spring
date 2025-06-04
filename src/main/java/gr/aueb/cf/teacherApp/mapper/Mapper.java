package gr.aueb.cf.teacherApp.mapper;

import gr.aueb.cf.teacherApp.core.enums.Role;
import gr.aueb.cf.teacherApp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherApp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherApp.dto.UserInsertDTO;
import gr.aueb.cf.teacherApp.model.Teacher;
import gr.aueb.cf.teacherApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Teacher mapToTeacherEntity(TeacherInsertDTO teacherInsertDTO){
        Teacher teacher = new Teacher();
        teacher.setFirstname(teacherInsertDTO.getFirstname());
        teacher.setLastname(teacherInsertDTO.getLastname());
        teacher.setVat(teacherInsertDTO.getVat());
        return teacher;
    }

    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(Teacher teacher){
        return new TeacherReadOnlyDTO(teacher.getId(), teacher.getCreatedAt(),teacher.getUpdatedAt(),
                teacher.getUuid(), teacher.getFirstname(), teacher.getLastname(), teacher.getVat(),
                teacher.getRegion().getName());
    }

    public User mapToUserEntity(UserInsertDTO userInsertDTO){
        return new User(null, userInsertDTO.getUsername(), userInsertDTO.getPassword(),
                Role.valueOf(userInsertDTO.getRole().toUpperCase()));
    }
}

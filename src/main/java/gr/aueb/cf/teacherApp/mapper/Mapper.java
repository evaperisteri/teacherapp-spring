package gr.aueb.cf.teacherApp.mapper;

import gr.aueb.cf.teacherApp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherApp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherApp.model.Teacher;
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
}

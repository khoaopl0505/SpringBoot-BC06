package net.javaguids.bt1.service;

import net.javaguids.bt1.dto.StudentDto;
import net.javaguids.bt1.entity.Student;


import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudent();
    Student save(Student student);
}

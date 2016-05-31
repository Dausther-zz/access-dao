package br.com.bb.dao;

import br.com.bb.entities.Student;

public interface StudentDAO {

    Student saveStudent(String studentName);

    void listStudent();

    void updateStudent(Long studentId, String studentName);

    void deleteStudent(Long studentId);

}

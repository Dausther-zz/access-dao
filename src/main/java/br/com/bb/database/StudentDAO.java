package br.com.bb.database;

public interface StudentDAO {

    Student saveStudent(String studentName);

    void listStudent();

    void updateStudent(Long studentId, String studentName);

    void deleteStudent(Long studentId);

}

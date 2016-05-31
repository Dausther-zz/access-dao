package br.com.bb;

import br.com.bb.dao.StudentDAO;
import br.com.bb.dao.StudentDAOImpl;
import br.com.bb.utils.EntityManagerUtil;
import br.com.bb.entities.Student;

import java.util.Arrays;
import java.util.List;

public class EscolaCarambola {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl(EntityManagerUtil.getEntityManager());

        System.out.println("After Successfully insertion ");
        Student student1 = studentDAO.saveStudent("Student1");
        Student student2 = studentDAO.saveStudent("Student2");
        studentDAO.listStudent();

        System.out.println("After Successfully modification ");
        studentDAO.updateStudent(student1.getStudentId(), "Student1 Lesson1");
        studentDAO.updateStudent(student2.getStudentId(), "Student2 Lesson2");
        studentDAO.listStudent();

        System.out.println("After Successfully deletion ");
        studentDAO.deleteStudent(student2.getStudentId());
        studentDAO.listStudent();
        List<String> prices = Arrays.asList("a","b","c");
    }

}

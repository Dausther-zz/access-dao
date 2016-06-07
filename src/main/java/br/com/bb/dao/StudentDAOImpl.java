package br.com.bb.dao;

import br.com.bb.entities.Student;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Student saveStudent(String studentName) {
        Student student = new Student();
        try {
            entityManager.getTransaction().begin();
            student.setStudentName(studentName);
            student = entityManager.merge(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return student;
    }

    public void listStudent() {
        try {
            entityManager.getTransaction().begin();
            @SuppressWarnings("unchecked")
            List<Student> Students = entityManager.createQuery("SELECT e FROM Student e").getResultList();
            for (Iterator<Student> iterator = Students.iterator(); iterator.hasNext();) {
                Student student = (Student) iterator.next();
                System.out.println(student.getStudentId()+" "+student.getStudentName());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void updateStudent(Long studentId, String studentName) {
        try {
            entityManager.getTransaction().begin();
            Student student = (Student) entityManager.find(Student.class, studentId);
            student.setStudentName(studentName);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteStudent(Long studentId) {
        try {
            entityManager.getTransaction().begin();
            Student student = (Student) entityManager.find(Student.class, studentId);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

}

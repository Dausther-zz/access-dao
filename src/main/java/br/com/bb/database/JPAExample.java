package br.com.bb.database;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class JPAExample {
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public static void main(String[] args) {
        JPAExample example = new JPAExample();

        System.out.println("After Sucessfully insertion ");
        Student student1 = example.saveStudent("Student1");
        Student student2 = example.saveStudent("Student2");
        example.listStudent();

        System.out.println("After Sucessfully modification ");
        example.updateStudent(student1.getStudentId(), "Student1 Lesson1");
        example.updateStudent(student2.getStudentId(), "Student2 Lesson2");
        example.listStudent();

        System.out.println("After Sucessfully deletion ");
        example.deleteStudent(student2.getStudentId());
        example.listStudent();

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

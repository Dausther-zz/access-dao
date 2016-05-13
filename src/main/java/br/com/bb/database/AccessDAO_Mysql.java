package br.com.bb.database;

import javax.persistence.EntityManager;

public class AccessDAO_Mysql implements AccessDAO {
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public Object save(Object object) {
        Student student = new Student();
        try {
            entityManager.getTransaction().begin();
//            student.setStudentName(studentName);
            student = entityManager.merge(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return student;
    }

    @Override
    public void update(Object object) {
        try {
            entityManager.getTransaction().begin();
//            Student student = (Student) entityManager.find(Student.class, studentId);
//            student.setStudentName(studentName);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Object object) {
        try {
            entityManager.getTransaction().begin();
//            Student student = (Student) entityManager.find(Student.class, studentId);
//            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void list(Object object) {
        try {
            entityManager.getTransaction().begin();
//            @SuppressWarnings("unchecked")
//            List<Student> Students = entityManager.createQuery("from Student").getResultList();
//            for (Iterator<Student> iterator = Students.iterator(); iterator.hasNext();) {
//                Student student = (Student) iterator.next();
//                System.out.println(student.getStudentName());
//            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}

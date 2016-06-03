package br.com.bb;

import br.com.bb.dao.StudentDAO;
import br.com.bb.dao.StudentDAOImpl;
import br.com.bb.dao.UserDAO;
import br.com.bb.dao.UserDAOImpl;
import br.com.bb.entities.User;
import br.com.bb.persistence.dao.TypedDao;
import br.com.bb.persistence.util.TestDAO;
import br.com.bb.utils.EntityManagerUtil;
import br.com.bb.entities.Student;

public class EntryPoint {
    public static void main(String[] args) {

        System.out.println(" ---------------------------- ");
        System.out.println(" *** STUDENT MAINTAINING *** ");
        System.out.println(" ---------------------------- ");

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


        System.out.println(" ------------------------ ");
        System.out.println(" *** USER MAINTAINING *** ");
        System.out.println(" ------------------------ ");

        UserDAO userDAO = new UserDAOImpl(EntityManagerUtil.getEntityManager());
        User user = new User();

        System.out.println("After Successfully insertion ");
        user.setUserName("User1");
        userDAO.persist(user);
        user.setUserName("User2");
        userDAO.persist(user);
        userDAO.find();


        System.out.println("After Successfully modification ");
        userDAO.find(1L);
        user.setUserName("User1 alterado");
        userDAO.update(user);
        user = userDAO.find(2L);
        user.setUserName("User2 alterado");
        userDAO.update(user);
        userDAO.find();

        TypedDao<Long, User> user2Dao = new TestDAO();

        System.out.println("After Successfully deletion ");
        user2Dao.delete(user);


    }

}

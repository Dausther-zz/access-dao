package br.com.bb;

import br.com.bb.dao.StudentDAO;
import br.com.bb.dao.StudentDAOImpl;
import br.com.bb.dao.UserDAO;
import br.com.bb.dao.UserDAOImpl;
import br.com.bb.entities.User;
import br.com.bb.persistence.api.IPersistenceProvider;
import br.com.bb.persistence.dao.ITypedDAO;
import br.com.bb.persistence.dao.TypedDao;
import br.com.bb.persistence.util.TestDAO;
import br.com.bb.utils.EntityManagerUtil;
import br.com.bb.entities.Student;
import br.com.bb.utils.TimPersistenceProvider;

import java.util.List;

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

        System.out.println("After Successfully insertion ");
        User user1 = new User();
        user1.setUserName("User1");
        userDAO.persist(user1);

        User user2 = new User();
        user2.setUserName("User2");
        userDAO.persist(user2);
        userDAO.find();


        System.out.println("After Successfully modification ");
        user1 = userDAO.find().get(0);
        user1.setUserName("User1 alterado");
        userDAO.update(user1);

        user2 = userDAO.find().get(1);
        user2.setUserName("User2 alterado");
        userDAO.update(user2);
        userDAO.find();

        TimPersistenceProvider timPersistenceProvider = new TimPersistenceProvider(EntityManagerUtil.getEntityManager());
        ITypedDAO<Long, User> testDAO = new TestDAO(Long.class, User.class, timPersistenceProvider);
        List<User> users = userDAO.find();


        System.out.println("After Successfully deletion ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Deleting: " + users.get(i).getId() + " - " + users.get(i).getUserName());
            testDAO.delete(users.get(i));
        }

    }

}

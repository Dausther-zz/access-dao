package br.com.bb.database;

public class JPAExample {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl(EntityManagerUtil.getEntityManager());

        System.out.println("After Sucessfully insertion ");
        Student student1 = studentDAO.saveStudent("Student1");
        Student student2 = studentDAO.saveStudent("Student2");
        studentDAO.listStudent();

        System.out.println("After Sucessfully modification ");
        studentDAO.updateStudent(student1.getStudentId(), "Student1 Lesson1");
        studentDAO.updateStudent(student2.getStudentId(), "Student2 Lesson2");
        studentDAO.listStudent();

        System.out.println("After Sucessfully deletion ");
        studentDAO.deleteStudent(student2.getStudentId());
        studentDAO.listStudent();

    }

}

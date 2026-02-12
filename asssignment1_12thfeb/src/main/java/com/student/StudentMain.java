package com.student;

import java.util.List;

public class StudentMain {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // SAVE
//        Student s = new Student();
//        s.setName("Submi");
//        s.setEmail("submi@gmail.com");
//        s.setMarks(85);
//        System.out.println(dao.saveStudent(s));

        // FIND
//        Student found = dao.findStudentById(1);
//        if (found != null) {
//            System.out.println(found.getName() + " " +
//                    found.getEmail() + " " +
//                    found.getMarks());
//        }

        // UPDATE
//        System.out.println(dao.updateStudent(1, 90));

        // DELETE
//        System.out.println(dao.deleteStudent(1));

        // FIND ALL
        List<Student> list = dao.findAllStudents();
        for (Student s : list) {
            System.out.println(s.getId() + " " +
                    s.getName() + " " +
                    s.getEmail() + " " +
                    s.getMarks());
        }

        dao.close();
    }
}

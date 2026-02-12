package com.person;

import java.util.List;

public class User {

    public static void main(String[] args) {

        PersonDAO dao = new PersonDAO();

        // INSERT
        Person p = new Person();
        p.setId(1);
        p.setName("Submi");
        p.setDob("2002-05-10");
        p.setAddress("Hyderabad");
        p.setPincode(500001);

        dao.insert(p);

        // FIND
//        Person found = dao.find(1);
//        if (found != null) {
//            System.out.println(
//                found.getId() + " " +
//                found.getName() + " " +
//                found.getDob() + " " +
//                found.getAddress() + " " +
//                found.getPincode()
//            );
//        }

        // UPDATE
//        dao.update(1, "Bangalore", 560001);

        // DELETE
//        dao.delete(1);

        // FIND ALL
//        List<Person> list = dao.findAll();
//        for (Person p : list) {
//            System.out.println(
//                p.getId() + " " +
//                p.getName() + " " +
//                p.getDob() + " " +
//                p.getAddress() + " " +
//                p.getPincode()
//            );
//        }

        dao.close();
    }
}

package com.passport;

import java.util.List;

public class User {

    public static void main(String[] args) {

        PassportDAO dao = new PassportDAO();

        // INSERT
//        Passport p = new Passport();
//        p.setPassportNo(1);
//        p.setName("Submi");
//        p.setGender("Female");
//        p.setAddress("Hyderabad");
//        p.setNoOfTravels(3);
//
//        System.out.println(dao.insert(p));

        // FIND
//        Passport found = dao.find(1);
//        if (found != null) {
//            System.out.println(
//                    found.getPassportNo() + " " +
//                    found.getName() + " " +
//                    found.getGender() + " " +
//                    found.getAddress() + " " +
//                    found.getNoOfTravels()
//            );
//        }

        // UPDATE
//        System.out.println(dao.update(1, "Bangalore", 5));

        // DELETE
//        System.out.println(dao.delete(1));

        // FIND ALL
        List<Passport> list = dao.findAll();
        for (Passport p : list) {
            System.out.println(
                    p.getPassportNo() + " " +
                    p.getName() + " " +
                    p.getGender() + " " +
                    p.getAddress() + " " +
                    p.getNoOfTravels()
            );
        }

        dao.close();
    }
}

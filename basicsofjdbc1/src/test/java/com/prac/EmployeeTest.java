package com.prac;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Employee2Test {

    List<List<Employee2>> employeeListOfLists;

    @BeforeEach
    void setUp() {
        employeeListOfLists = new ArrayList<>();
    }

    // 1️⃣ assertTrue → checks if the list is empty
    @Test
    void testEmployeeListIsEmpty() {
        assertTrue(employeeListOfLists.isEmpty());
    }

    // 2️⃣ assertFalse → checks if the list has elements
    @Test
    void testEmployeeListIsNotEmpty() {

        List<Employee2> employees = new ArrayList<>();

        employees.add(new Employee2(1, "Amit", 50000, 25,
                LocalDate.of(2022, 1, 10), "IT"));
        employees.add(new Employee2(2, "Riya", 55000, 26,
                LocalDate.of(2021, 3, 15), "HR"));
        employees.add(new Employee2(3, "John", 60000, 28,
                LocalDate.of(2020, 6, 20), "Finance"));
        employees.add(new Employee2(4, "Sneha", 52000, 24,
                LocalDate.of(2023, 2, 5), "IT"));
        employees.add(new Employee2(5, "Rahul", 58000, 27,
                LocalDate.of(2019, 9, 12), "Admin"));

        employeeListOfLists.add(employees);

        assertFalse(employeeListOfLists.isEmpty());
    }

    // 3️⃣ Minimum 5 employees
    @Test
    void testMinimumFiveEmployees() {

        List<Employee2> employees = new ArrayList<>();

        employees.add(new Employee2(1, "Amit", 50000, 25,
                LocalDate.now(), "IT"));
        employees.add(new Employee2(2, "Riya", 55000, 26,
                LocalDate.now(), "HR"));
        employees.add(new Employee2(3, "John", 60000, 28,
                LocalDate.now(), "Finance"));
        employees.add(new Employee2(4, "Sneha", 52000, 24,
                LocalDate.now(), "IT"));
        employees.add(new Employee2(5, "Rahul", 58000, 27,
                LocalDate.now(), "Admin"));

        assertTrue(employees.size() >= 5);
    }

    // 4️⃣ isValidAge → age > 18 for all employees
    @Test
    void testValidAgeForAllEmployees() {

        List<Employee2> employees = new ArrayList<>();

        employees.add(new Employee2(1, "Amit", 50000, 25,
                LocalDate.now(), "IT"));
        employees.add(new Employee2(2, "Riya", 55000, 26,
                LocalDate.now(), "HR"));
        employees.add(new Employee2(3, "John", 60000, 28,
                LocalDate.now(), "Finance"));
        employees.add(new Employee2(4, "Sneha", 52000, 24,
                LocalDate.now(), "IT"));
        employees.add(new Employee2(5, "Rahul", 58000, 27,
                LocalDate.now(), "Admin"));

        boolean isValidAge = employees.stream()
                .allMatch(emp -> emp.getAge() > 18);

        assertTrue(isValidAge);
    }
}

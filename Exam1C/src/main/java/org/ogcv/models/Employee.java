package org.ogcv.models;

public abstract class Employee {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected double baseSalary;
    protected static final double INCENTIVE = 300.0;

    public Employee(String id, String firstName, String lastName, int age, double baseSalary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.baseSalary = baseSalary;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method to calculate net salary
    public abstract double calculateNetSalary();

    @Override
    public String toString() {
        return "Employee: " + firstName + " " + lastName + " | ID: " + id + " | Net Salary: " + calculateNetSalary();
    }
}


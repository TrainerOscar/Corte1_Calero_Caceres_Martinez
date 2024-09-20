package org.ogcv.models;


public class DeliveryPerson extends Employee {
    private String zone;

    public DeliveryPerson(String id, String firstName, String lastName, int age, double baseSalary, String zone) {
        super(id, firstName, lastName, age, baseSalary);
        this.zone = zone;
    }

    @Override
    public double calculateNetSalary() {
        double finalSalary = baseSalary;
        if (age < 25 && zone.equalsIgnoreCase("Ciudad Sandino")) {
            finalSalary += INCENTIVE;
        }
        finalSalary -= finalSalary * 0.10; // 10% deduction
        return finalSalary;
    }
}


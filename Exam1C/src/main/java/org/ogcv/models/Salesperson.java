package org.ogcv.models;


public class Salesperson extends Employee {
    private double commission;

    public Salesperson(String id, String firstName, String lastName, int age, double baseSalary, double commission) {
        super(id, firstName, lastName, age, baseSalary);
        this.commission = commission;
    }

    @Override
    public double calculateNetSalary() {
        double finalSalary = baseSalary;
        if (age > 30 && commission < 500) {
            finalSalary += 0.5 * INCENTIVE;
        }
        finalSalary -= finalSalary * 0.07; // 7% deduction
        return finalSalary;
    }
}


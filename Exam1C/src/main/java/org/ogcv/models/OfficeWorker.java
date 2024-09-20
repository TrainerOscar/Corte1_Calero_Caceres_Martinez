package org.ogcv.models;


public class OfficeWorker extends Employee {
    private String position;

    public OfficeWorker(String id, String firstName, String lastName, int age, double baseSalary, String position) {
        super(id, firstName, lastName, age, baseSalary);
        this.position = position;
    }

    @Override
    public double calculateNetSalary() {
        double finalSalary = baseSalary;
        if (position.equalsIgnoreCase("Manager")) {
            finalSalary += 0.2 * INCENTIVE;
        } else {
            finalSalary += 0.8 * INCENTIVE;
        }
        finalSalary -= finalSalary * 0.07; // 7% deduction
        return finalSalary;
    }
}

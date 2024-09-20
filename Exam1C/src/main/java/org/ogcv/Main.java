package main;

import model.Salesperson;
import model.OfficeWorker;
import model.DeliveryPerson;
import service.EmployeeService;
import service.EmployeeInterface;
import model.Employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeInterface employeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Search Employee by Name");
            System.out.println("4. Show All Employees");
            System.out.println("5. Delete Employee by ID");
            System.out.println("6. Update Employee Information");
            System.out.println("7. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                   
                    addEmployee(employeeService, scanner);
                    break;
                case 2:
                   
                    searchEmployeeById(employeeService, scanner);
                    break;
                case 3:
                   
                    searchEmployeeByName(employeeService, scanner);
                    break;
                case 4:
                   
                    showAllEmployees(employeeService);
                    break;
                case 5:
                   
                    deleteEmployeeById(employeeService, scanner);
                    break;
                case 6:
                   
                    updateEmployeeInformation(employeeService, scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 7);

        scanner.close();
    }

    // Methods for each menu option (e.g., addEmployee, searchEmployeeById, etc.)
    private static void addEmployee(EmployeeInterface employeeService, Scanner scanner) {
        System.out.println("Choose type of employee to add: 1. Salesperson 2. DeliveryPerson 3. OfficeWorker");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Base Salary: ");
        double baseSalary = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.print("Enter Commission: ");
                double commission = scanner.nextDouble();
                Employee salesperson = new Salesperson(id, firstName, lastName, age, baseSalary, commission);
                employeeService.addEmployee(salesperson);
                break;
            case 2:
                System.out.print("Enter Zone: ");
                scanner.nextLine(); // consume newline
                String zone = scanner.nextLine();
                Employee deliveryPerson = new DeliveryPerson(id, firstName, lastName, age, baseSalary, zone);
                employeeService.addEmployee(deliveryPerson);
                break;
            case 3:
                System.out.print("Enter Position: ");
                scanner.nextLine(); // consume newline
                String position = scanner.nextLine();
                Employee officeWorker = new OfficeWorker(id, firstName, lastName, age, baseSalary, position);
                employeeService.addEmployee(officeWorker);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void searchEmployeeById(EmployeeInterface employeeService, Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String id = scanner.next();
        Employee employee = employeeService.searchEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void searchEmployeeByName(EmployeeInterface employeeService, Scanner scanner) {
        System.out.print("Enter Employee First Name: ");
        String name = scanner.next();
        var employees = employeeService.searchEmployeeByName(name);
        if (!employees.isEmpty()) {
            employees.forEach(System.out::println);
        } else {
            System.out.println("No employees found with that name.");
        }
    }

    private static void showAllEmployees(EmployeeInterface employeeService) {
        var employees = employeeService.getAllEmployees();
        if (!employees.isEmpty()) {
            employees.forEach(System.out::println);
        } else {
            System.out.println("No employees found.");
        }
    }

    private static void deleteEmployeeById(EmployeeInterface employeeService, Scanner scanner) {
        System.out.print("Enter Employee ID to delete: ");
        String id = scanner.next();
        employeeService.deleteEmployeeById(id);
        System.out.println("Employee deleted if existed.");
    }

    private static void updateEmployeeInformation(EmployeeInterface employeeService, Scanner scanner) {
        System.out.print("Enter Employee ID to update: ");
        String id = scanner.next();
        Employee employee = employeeService.searchEmployeeById(id);
        if (employee != null) {
           
            System.out.println("Update logic can be added here.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}

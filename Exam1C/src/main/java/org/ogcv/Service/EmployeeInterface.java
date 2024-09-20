package org.ogcv.Service;
import org.ogcv.models.Employee;
import java.util.List;

public interface EmployeeInterface {
    void addEmployee(Employee employee);
    Employee searchEmployeeById(String id);
    List<Employee> searchEmployeeByName(String name);
    List<Employee> getAllEmployees();
}


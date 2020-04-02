package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Employee;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EmployeeServiceLocal {

    void createEmployee(String name, String surname, int age, int salary, Cinema cinema);

    List<Employee> getAllEmployees(Cinema cinema);
}

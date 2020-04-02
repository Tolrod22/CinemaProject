package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EmployeeServiceRemote {

    void createEmployee(String name, String surname, int age, int salary, Cinema cinema);

    List<Employee> getAllEmployees(Cinema cinema);
}

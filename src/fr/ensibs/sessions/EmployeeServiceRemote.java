package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EmployeeServiceRemote {

    void createEmployee(String name, String surname, int age, int salary, Cinema cinema);

    List<Employee> getAllEmployees(Cinema cinema);

    void removeEmployee(Long id, Long idCinema);

    void editEmployee(String name, String surname, Integer age, Integer salary, Long id);

    Employee getEmployeeFrom(Long idEmployee);
}

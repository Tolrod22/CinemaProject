package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Employee;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EmployeeService implements EmployeeServiceLocal, EmployeeServiceRemote {

    @PersistenceContext(unitName = "cinema")
    private EntityManager em;

    @Override
    public void createEmployee(String name, String surname, int age, int salary, Cinema cinema) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setAge(age);
        employee.setSalary(salary);
        employee.setCinema(cinema);
        em.persist(employee);

        Cinema cine = em.find(Cinema.class, cinema.getIdCinema()); //TODO Pas sur de la légalité de ce truc
        cine.addEmployee(employee);
        em.persist(cine);
    }

    @Override
    public List<Employee> getAllEmployees(Cinema cinema) {
        //long cinemaId = cinema.getIdCinema();
        Query q = em.createQuery("SELECT e FROM Employee e WHERE e.cinema = :cinemaId").setParameter("cinemaId", cinema);
        return (List<Employee>) q.getResultList();
    }
}

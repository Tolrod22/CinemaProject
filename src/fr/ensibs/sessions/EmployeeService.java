package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Employee;

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
        em.getEntityManagerFactory().getCache().evict(Cinema.class, cinema.getIdCinema());
    }

    @Override
    public List<Employee> getAllEmployees(Cinema cinema) {
        return em.createQuery("SELECT e FROM Employee e WHERE e.cinema = :cinemaId", Employee.class).setParameter("cinemaId", cinema).getResultList();
    }

    @Override
    public void removeEmployee(Long id, Long idCinema) {
        Employee toRemove = em.createQuery("SELECT e FROM Employee e WHERE e.idEmployee = :employeeId", Employee.class).setParameter("employeeId", id).getSingleResult();
        em.remove(toRemove);
        em.getEntityManagerFactory().getCache().evict(Cinema.class, idCinema);
    }

    @Override
    public void editEmployee(String name, String surname, Integer age, Integer salary, Long id) {
        Employee toUpdate = getEmployeeFrom(id);
        if(!name.equals("")) toUpdate.setName(name);
        if(!surname.equals("")) toUpdate.setSurname(surname);
        if(age != null) toUpdate.setAge(age);
        if(salary != null) toUpdate.setSalary(salary);
        em.merge(toUpdate);
        em.getEntityManagerFactory().getCache().evict(Cinema.class, toUpdate.getCinema().getIdCinema());
    }

    @Override
    public Employee getEmployeeFrom(Long idEmployee) {
        Query q = em.createQuery("select e from Employee e where e.idEmployee = :id").setParameter("id", idEmployee);
        return (Employee) q.getResultList().get(0);
    }
}

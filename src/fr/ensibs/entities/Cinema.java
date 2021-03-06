package fr.ensibs.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

@Entity
public class Cinema implements Serializable {

    @Id
    @GeneratedValue
    private Long idCinema;

    private String name;

    private String address;

    private int postalCode;

    @OneToMany(
            mappedBy = "cinema",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Employee> employees = new ArrayList<>();

    @ManyToMany(mappedBy = "cinemas",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Movie> movies = new Vector<>();

    public Cinema() {
    }

    public Long getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Long idCinema) {
        this.idCinema = idCinema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        emp.setCinema(this);
    }

    public void removeEmploye(Employee emp) {
        employees.remove(emp);
        emp.setCinema(null);
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "idCinema=" + idCinema +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", NbEmployees=" + employees.size() +
                ", NbMovies=" + movies.size() +
                '}';
    }
}

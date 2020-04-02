package fr.ensibs.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cinema implements Serializable {

    @Id
    @GeneratedValue
    private Long idCinema;

    private String name;

    private String address;

    private int postalCode;

    @OneToMany
    private List<Employee> employees;

    @ManyToMany
    private List<Movie> movies;

    public Cinema() {
    }

    @Column(name = "cinema_id")
    public Long getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Long idCinema) {
        this.idCinema = idCinema;
    }

    @Column(name = "cinema_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "cinema_address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "cinema_postalCode")
    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "cinema_employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Column(name = "cinema_movies")
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
                ", employees=" + employees +
                ", movies=" + movies +
                '}';
    }
}

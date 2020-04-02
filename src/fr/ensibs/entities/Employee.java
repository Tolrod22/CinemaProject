package fr.ensibs.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long idEmployee;

    private String name;

    private String surname;

    private int age;

    private double salary;



    @ManyToOne
    private Cinema cinema;

    public Employee() {
    }

    @Column(name = "employee_id")
    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Column(name = "employee_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "employee_surname")
    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    @Column(name = "employee_age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "employee_salary")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Column(name = "employee_cinema")
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}

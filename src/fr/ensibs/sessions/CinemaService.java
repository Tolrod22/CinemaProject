package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CinemaService implements CinemaServiceLocal, CinemaServiceRemote{

    @PersistenceContext(unitName = "cinema")
    private EntityManager em;

    @Override
    public void createCinema(String name, String address, int postalCode) {
        Cinema cinema = new Cinema();
        cinema.setName(name);
        cinema.setAddress(address);
        cinema.setPostalCode(postalCode);
        em.persist(cinema);
    }

    @Override
    public List<Cinema> getAllCinema() {
        Query q = em.createQuery("select c from Cinema c");
        List<Cinema> cinemaList = q.getResultList();
        for (Cinema cine : cinemaList) {
            System.out.println(cine.toString());
        }
        return cinemaList;
    }
}
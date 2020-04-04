package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CinemaService implements CinemaServiceLocal, CinemaServiceRemote {

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
        return (List<Cinema>) q.getResultList();
    }

    @Override
    public Cinema getCinemaFrom(Long idCinema) {
        Query q = em.createQuery("select c from Cinema c where c.idCinema = :id").setParameter("id", idCinema);
        return (Cinema) q.getResultList().get(0);
    }
}

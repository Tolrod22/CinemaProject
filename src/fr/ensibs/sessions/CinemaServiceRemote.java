package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CinemaServiceRemote {

    void createCinema(String name, String address, int postalCode);

    List<Cinema> getAllCinema();

    Cinema getCinemaFrom(Long id);

    void removeCinema(Long id);
}

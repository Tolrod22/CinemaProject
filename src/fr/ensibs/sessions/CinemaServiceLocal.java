package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CinemaServiceLocal {

    void createCinema(String name, String address, int postalCode);

    List<Cinema> getAllCinema();

    Cinema getCinemaFrom(Long id);

    void removeCinema(Long id);

    void editCinema(Long id, String name, String address, Integer postalCode);
}

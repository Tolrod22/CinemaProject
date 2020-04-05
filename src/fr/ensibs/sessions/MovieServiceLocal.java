package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Movie;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface MovieServiceLocal {
    void createMovie(String title, Date startingDate, Date endingDate, Cinema cinema);

    List<Movie> getAllMovie();

    Movie getMovieFrom(Long id);

    void removeMovie(Long id, Long idCinema);

    Movie getMovieByTitle(String movieTitle);
}

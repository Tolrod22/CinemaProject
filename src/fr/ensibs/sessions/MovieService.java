package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Movie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class MovieService implements MovieServiceLocal, MovieServiceRemote {

    @PersistenceContext(unitName = "cinema")
    private EntityManager em;

    @Override
    public void createMovie(String title, Date startingDate, Date endingDate, Cinema cinema) {
        Movie testing = getMovieByTitle(title);
        if(testing == null){
            Movie movie = new Movie();
            movie.addCinema(cinema);
            movie.setTitle(title);
            movie.setStartingDate(startingDate);
            movie.setEndingDate(endingDate);
            em.persist(movie);
        } else {
            testing.addCinema(cinema);
            em.merge(testing);
        }
        em.getEntityManagerFactory().getCache().evict(Cinema.class, cinema.getIdCinema());
    }

    @Override
    public List<Movie> getAllMovie() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    @Override
    public Movie getMovieFrom(Long id) {
        return (Movie) em.createQuery("SELECT m FROM Movie m WHERE m.idMovie = :movieId", Movie.class).setParameter("movieId", id).getResultList();
    }

    @Override
    public void removeMovie(Long id, Long idCinema) {
        Movie toRemove = em.createQuery("SELECT m FROM Movie m WHERE m.idMovie = :movieId", Movie.class).setParameter("movieId", id).getSingleResult();
        if(toRemove.getCinemas().size() > 1){
            Cinema cineToRemove = (Cinema) em.createQuery("select c from Cinema c where c.idCinema = :id").setParameter("id", idCinema).getSingleResult();
            toRemove.getCinemas().remove(cineToRemove);
            em.merge(toRemove);
        } else {
            em.remove(toRemove);
        }
        em.getEntityManagerFactory().getCache().evict(Cinema.class, idCinema);
    }

    @Override
    public Movie getMovieByTitle(String title) {
        try{
            return em.createQuery("SELECT m FROM Movie m WHERE m.title = :movieTitle", Movie.class).setParameter("movieTitle", title).getSingleResult();
        } catch (Exception e){
            System.out.println("No movie with this title");
            return null;
        }
    }
}

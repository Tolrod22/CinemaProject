package fr.ensibs.pages;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Movie;
import fr.ensibs.sessions.CinemaServiceLocal;
import fr.ensibs.sessions.MovieServiceLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "addMovie", urlPatterns = {"/addMovie"})
public class AddMovie extends HttpServlet {

    public static final String VIEW = "/addMovie.jsp";

    @EJB
    private MovieServiceLocal movieService;

    @EJB
    private CinemaServiceLocal cinemaService;

    private Cinema cinema;

    private  ArrayList<Movie> movies;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        movies = new ArrayList<>();
        if (request.getParameter("id") != null) {
            this.cinema = this.cinemaService.getCinemaFrom(Long.parseLong(request.getParameter("id")));
            request.setAttribute("cinema", this.cinema);
        }
        if(request.getParameter("searched") != null){
            movies.add(movieService.getMovieByTitle(request.getParameter("searched")));
            request.setAttribute("movies", movies);
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getParameter("movieToAddFromSearch") != null){
            Movie theMovie = movies.get(0);
            this.movieService.createMovie(theMovie.getTitle(), theMovie.getStartingDate(), theMovie.getEndingDate(), cinema);
            response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinema.getIdCinema());
        } else if(request.getParameter("titleSearch") != null){
            response.sendRedirect("/CinemaProject/addMovie?id=" + this.cinema.getIdCinema()+"&searched="+request.getParameter("titleSearch"));
        } else {
            try {
                String title = request.getParameter("title");
                Date startingDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startingDate"));
                Date endingDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endingDate"));
                this.movieService.createMovie(title, startingDate, endingDate, this.cinema);
                response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinema.getIdCinema());
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinema.getIdCinema());
            }
        }
    }
}
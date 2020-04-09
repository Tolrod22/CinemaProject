package fr.ensibs.pages;

import fr.ensibs.entities.Movie;
import fr.ensibs.sessions.MovieServiceLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "editMovie", urlPatterns = {"/editMovie"})
public class EditMovie extends HttpServlet {

    public static final String VIEW = "/editMovie.jsp";

    @EJB
    private MovieServiceLocal movieService;

    private Movie movie;

    private String cinemaId;

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
        if (request.getParameter("id") != null && request.getParameter("idMovie") != null) {
            this.cinemaId = request.getParameter("id");
            this.movie = this.movieService.getMovieFrom(Long.parseLong(request.getParameter("idMovie")));

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String start = format.format(this.movie.getStartingDate());
            String end = format.format(this.movie.getEndingDate());
            request.setAttribute("movie", this.movie);
            request.setAttribute("startingDateValue", start);
            request.setAttribute("endingDateValue", end);
            request.setAttribute("idCinema", this.cinemaId);
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
        try {
            String title = request.getParameter("title");
            Date startingDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startingDate"));
            Date endingDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endingDate"));
            this.movieService.editMovie(title, startingDate, endingDate, this.movie.getIdMovie(), Long.parseLong(this.cinemaId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinemaId);
    }
}
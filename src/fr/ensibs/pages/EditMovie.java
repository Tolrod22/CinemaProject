package fr.ensibs.pages;

import fr.ensibs.entities.Employee;
import fr.ensibs.entities.Movie;
import fr.ensibs.sessions.EmployeeServiceLocal;
import fr.ensibs.sessions.MovieServiceLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
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
            cinemaId = request.getParameter("id");
            movie = this.movieService.getMovieFrom(Long.parseLong(request.getParameter("idMovie")));

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String start = format1.format(movie.getStartingDate());
            String end = format1.format(movie.getEndingDate());
            request.setAttribute("movie", movie);
            request.setAttribute("startingDateValue", start);
            request.setAttribute("endingDateValue", end);
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
            movieService.editMovie(title, startingDate, endingDate, movie.getIdMovie(), Long.parseLong(cinemaId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CinemaProject/manageCinema?id=" + cinemaId);
    }
}
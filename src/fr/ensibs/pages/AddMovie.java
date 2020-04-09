package fr.ensibs.pages;

import fr.ensibs.entities.Cinema;
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
import java.util.Date;

@WebServlet(name = "addMovie", urlPatterns = {"/addMovie"})
public class AddMovie extends HttpServlet {

    public static final String VIEW = "/addMovie.jsp";

    @EJB
    private MovieServiceLocal movieService;

    @EJB
    private CinemaServiceLocal cinemaService;

    private Cinema cinema;

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
        if (request.getParameter("id") != null) {
            this.cinema = this.cinemaService.getCinemaFrom(Long.parseLong(request.getParameter("id")));
            request.setAttribute("cinema", this.cinema);
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
            this.movieService.createMovie(title, startingDate, endingDate, this.cinema);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinema.getIdCinema());
    }
}
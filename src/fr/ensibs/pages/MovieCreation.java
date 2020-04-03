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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "movieCreation", urlPatterns = {"/movieCreation"})
public class MovieCreation extends HttpServlet {

    public static final String VIEW = "/creationMovie.jsp";

    @EJB
    private CinemaServiceLocal cinemaService;

    @EJB
    private MovieServiceLocal movieService;

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
        cinema = cinemaService.getCinemaFrom(Long.parseLong(request.getParameter("id")));
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String title = request.getParameter("title");
        String startingDate = request.getParameter("startingDate");
        String endingDate = request.getParameter("endingDate");
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startingDate);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endingDate);

        System.out.println(startingDate);
        movieService.createMovie(title, startDate, endDate, cinema);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CinemaProject/management?id=" + cinema.getIdCinema());
    }
}
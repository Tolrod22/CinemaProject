package fr.ensibs.pages;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Movie;
import fr.ensibs.entities.Ticket;
import fr.ensibs.sessions.CinemaServiceLocal;
import fr.ensibs.sessions.MovieServiceLocal;
import fr.ensibs.sessions.TicketServiceLocal;

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
import java.util.List;

@WebServlet(name = "manageMovie", urlPatterns = {"/manageMovie"})
public class ManageMovie extends HttpServlet {

    public static final String VIEW = "/manageMovie.jsp";

    @EJB
    private MovieServiceLocal movieService;

    @EJB
    private TicketServiceLocal ticketService;

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

            List<Ticket> tickets = ticketService.getAllTicketsFromMovie(movie);
            request.setAttribute("tickets", tickets);
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
            String price = request.getParameter("price");
            Date  endValidation = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endValidation"));
            String number = request.getParameter("number");
            ticketService.createTicket(Double.parseDouble(price), endValidation, Integer.parseInt(number), movie);
            response.sendRedirect("/CinemaProject/manageMovie?idMovie=" + movie.getIdMovie()+"&id="+cinemaId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
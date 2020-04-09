package fr.ensibs.pages;

import fr.ensibs.entities.Cinema;
import fr.ensibs.sessions.CinemaServiceLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editCinema", urlPatterns = {"/editCinema"})
public class EditCinema extends HttpServlet {

    public static final String VIEW = "/editCinema.jsp";

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
            Integer tmp = null;
            if (request.getParameter("postalCode").length() > 0)
                tmp = Integer.parseInt(request.getParameter("postalCode"));
            this.cinemaService.editCinema(this.cinema.getIdCinema(), request.getParameter("name"), request.getParameter("address"), tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinema.getIdCinema());
    }
}
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
import java.util.List;

@WebServlet(name = "manageCinemas", urlPatterns = {"/manageCinemas"})
public class ManageCinemas extends HttpServlet {

    public static final String VIEW = "/manageCinemas.jsp";

    @EJB
    private CinemaServiceLocal cinemaService;

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
        List<Cinema> cinemas = this.cinemaService.getAllCinema();
        request.setAttribute("cinemas", cinemas);
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
        if (request.getParameter("cinemaName") != null) {
            String name = request.getParameter("cinemaName");
            String address = request.getParameter("cinemaAddress");
            String postalCode = request.getParameter("cinemaPostalCode");
            this.cinemaService.createCinema(name, address, Integer.parseInt(postalCode));
            response.sendRedirect("/CinemaProject/manageCinemas");
        } else if (request.getParameter("idCinemaToManage") != null) {
            response.sendRedirect("/CinemaProject/manageCinema?id=" + request.getParameter("idCinemaToManage"));
        } else if (request.getParameter("idCinemaToDelete") != null) {
            // TODO DELETE THE CINEMA
        }
    }
}
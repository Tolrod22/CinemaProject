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
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "cinemaCreation", urlPatterns = {"/cinemaCreation"})
public class CinemaCreation extends HttpServlet {

    public static final String VIEW = "/creationCinema.jsp";
    public static final String VIEWTEST = "/test.jsp";

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

        List<Cinema> cinemas = cinemaService.getAllCinema();

        request.setAttribute("cinemas", cinemas); // Will be available as ${products} in JSP
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
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String postalCode = request.getParameter("postalCode");

            cinemaService.createCinema(name, address, Integer.parseInt(postalCode));

            //Trouver comment passer des informations entre les pages
            response.sendRedirect("/CinemaProject/test.jsp");
        }

    }
}
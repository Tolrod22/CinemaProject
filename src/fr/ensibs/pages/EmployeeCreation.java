package fr.ensibs.pages;

import fr.ensibs.entities.Cinema;
import fr.ensibs.sessions.CinemaServiceLocal;
import fr.ensibs.sessions.EmployeeServiceLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "employeeCreation", urlPatterns = {"/employeeCreation"})
public class EmployeeCreation extends HttpServlet {

    public static final String VIEW = "/creationEmployee.jsp";

    @EJB
    private EmployeeServiceLocal employeeService;

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

        List<Cinema> cinemas = cinemaService.getAllCinema();
        int cinemaId = Integer.parseInt(request.getParameter("id"));
        cinema = cinemas.get(cinemaId);
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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        String salary = request.getParameter("salary");
        response.sendRedirect("/CinemaProject/test.jsp?id=" + cinema.getIdCinema());
        employeeService.createEmployee(name, surname, Integer.parseInt(age), Integer.parseInt(salary), cinema);
    }
}
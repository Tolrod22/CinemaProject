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

@WebServlet(name = "addEmployee", urlPatterns = {"/addEmployee"})
public class AddEmployee extends HttpServlet {

    public static final String VIEW = "/addEmployee.jsp";

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
        this.cinema = this.cinemaService.getCinemaFrom(Long.parseLong(request.getParameter("id")));
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
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            int age = Integer.parseInt(request.getParameter("age"));
            int salary = Integer.parseInt(request.getParameter("salary"));
            this.employeeService.createEmployee(name, surname, age, salary, this.cinema);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinema.getIdCinema());
    }
}
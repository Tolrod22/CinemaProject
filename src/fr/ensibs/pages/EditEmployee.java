package fr.ensibs.pages;

import fr.ensibs.entities.Employee;
import fr.ensibs.sessions.EmployeeServiceLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editEmployee", urlPatterns = {"/editEmployee"})
public class EditEmployee extends HttpServlet {

    public static final String VIEW = "/editEmployee.jsp";

    @EJB
    private EmployeeServiceLocal employeeService;

    private Employee employee;

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
        if (request.getParameter("id") != null && request.getParameter("idEmp") != null) {
            this.cinemaId = request.getParameter("id");
            this.employee = this.employeeService.getEmployeeFrom(Long.parseLong(request.getParameter("idEmp")));
            request.setAttribute("employee", this.employee);
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
            Integer tmpAge = null;
            Integer tmpSalary = null;
            if (request.getParameter("age").length() > 0) {
                tmpAge = Integer.parseInt(request.getParameter("age"));
            }
            if (request.getParameter("salary").length() > 0) {
                tmpSalary = Integer.parseInt(request.getParameter("salary"));
            }
            this.employeeService.editEmployee(request.getParameter("name"), request.getParameter("surname"), tmpAge, tmpSalary, employee.getIdEmployee());
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinemaId);
    }
}

package fr.ensibs.pages;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Employee;
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

@WebServlet(name = "management", urlPatterns = {"/management"})
public class Management extends HttpServlet {

    public static final String VIEW = "/management.jsp";

    @EJB
    private CinemaServiceLocal cinemaService;

    @EJB
    private EmployeeServiceLocal employeeService;

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
        if(request.getParameter("id") != null){
            Cinema tmp = cinemaService.getCinemaFrom(Long.parseLong(request.getParameter("id")));
            //TODO Afficher la liste des employees de tmp dans la page (comme dans CinemaCreation)
            request.setAttribute("cinema", tmp);
        }
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
        if(request.getParameter("employeeAddTo") == null){
            //TODO movie and ticket
        } else {
            response.sendRedirect("/CinemaProject/employeeCreation?id="+request.getParameter("employeeAddTo"));
        }
    }
}

package fr.ensibs.pages;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Employee;
import fr.ensibs.entities.Movie;
import fr.ensibs.sessions.CinemaServiceLocal;
import fr.ensibs.sessions.EmployeeServiceLocal;
import fr.ensibs.sessions.MovieServiceLocal;

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
    private MovieServiceLocal movieService;

    private Cinema theCinema;

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
            theCinema = cinemaService.getCinemaFrom(Long.parseLong(request.getParameter("id")));
            System.out.println(theCinema.toString());
            List<Employee> employees = (List<Employee>) theCinema.getEmployees();
            List<Movie> movies = theCinema.getMovies();
            request.setAttribute("employees", employees);
            request.setAttribute("movies", movies);
            request.setAttribute("cinema", theCinema);
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
        if(request.getParameter("employeeAddTo") != null){
            response.sendRedirect("/CinemaProject/employeeCreation?id="+request.getParameter("employeeAddTo"));
        } else if(request.getParameter("movieAddTo") != null){
            response.sendRedirect("/CinemaProject/movieCreation?id="+request.getParameter("movieAddTo"));
        } else if(request.getParameter("movieToDelete") != null){
            movieService.removeMovie(Long.parseLong(request.getParameter("movieToDelete")), theCinema.getIdCinema());
            response.sendRedirect("/CinemaProject/management?id="+theCinema.getIdCinema());
        } else if(request.getParameter("ticketToAdd") != null){
            System.out.println("Redirecting to add tickets to "+request.getParameter("ticketToAdd"));
        } else {
            System.out.println("Nothing to do now");
        }
    }
}

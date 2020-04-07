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

@WebServlet(name = "manageCinema", urlPatterns = {"/manageCinema"})
public class ManageCinema extends HttpServlet {

    public static final String VIEW = "/manageCinema.jsp";

    @EJB
    private CinemaServiceLocal cinemaService;

    @EJB
    private MovieServiceLocal movieService;

    @EJB
    private EmployeeServiceLocal employeeService;

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
            List<Employee> employees = (List<Employee>) this.cinema.getEmployees();
            List<Movie> movies = this.cinema.getMovies();
            request.setAttribute("employees", employees);
            request.setAttribute("movies", movies);
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
        if (request.getParameter("idEmployeeToEdit") != null) {
            response.sendRedirect("/CinemaProject/editEmployee?id="+cinema.getIdCinema()+"&idEmp=" + request.getParameter("idEmployeeToEdit"));

        } else if (request.getParameter("idEmployeeToRemove") != null) {
            this.employeeService.removeEmployee(Long.parseLong(request.getParameter("idEmployeeToRemove")), this.cinema.getIdCinema());
            response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinema.getIdCinema());

        } else if (request.getParameter("idCinemaToAddEmployee") != null) {
            response.sendRedirect("/CinemaProject/addEmployee?id=" + this.cinema.getIdCinema());

        } else if (request.getParameter("idMovieToManage") != null) {
            response.sendRedirect("/CinemaProject/manageMovie?id=" + request.getParameter("idMovieToManage"));

        } else if (request.getParameter("idCinemaToAddMovie") != null) {
            response.sendRedirect("/CinemaProject/addMovie?id=" + this.cinema.getIdCinema());

        } else if (request.getParameter("idMovieToDelete") != null) {
            this.movieService.removeMovie(Long.parseLong(request.getParameter("idMovieToDelete")), this.cinema.getIdCinema());
            response.sendRedirect("/CinemaProject/manageCinema?id=" + this.cinema.getIdCinema());

        } else if (request.getParameter("idCinemaToEdit") != null) {
            response.sendRedirect("/CinemaProject/editCinema?id=" + this.cinema.getIdCinema());
        }
    }
}
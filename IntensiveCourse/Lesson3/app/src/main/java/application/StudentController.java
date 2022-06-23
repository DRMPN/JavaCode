package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class StudentController extends HttpServlet{
    private DaoStudent studentDao = DaoStudent.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertStudent(req, resp);
                    break;
                case "/delete":
                    deleteStudent(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updateStudent(req, resp);
                    break;
                default:
                    listStudent(req, resp);
                    break;
            }
        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) 
    throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String lastName = req.getParameter("lastname");
        String firstName = req.getParameter("firstname");

        Student student = new Student(id, lastName, firstName);
        studentDao.update(student);
        resp.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) 
    throws SQLException, IOException, ServletException {
        String id = req.getParameter("id");
        Optional<Student> existingStudent = studentDao.find(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/StudentForm.jsp");
        existingStudent.ifPresent(s -> req.setAttribute("student", s));
        dispatcher.forward(req, resp);
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) 
    throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));

        Student student = new Student(id);
        studentDao.delete(student);
        resp.sendRedirect("list");
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) 
    throws SQLException, IOException, ServletException {
        String lastName = req.getParameter("lastname");
        String firstName = req.getParameter("firstname");

        Student student = new Student(lastName, firstName);
        studentDao.save(student);
        resp.sendRedirect("list");
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) 
    throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/StudentForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) 
    throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/StudentList.jsp");
        
        List<Student> listStudent = studentDao.findAll();
        req.setAttribute("listStudent", listStudent);

        dispatcher.forward(req, resp);
    }
    
}

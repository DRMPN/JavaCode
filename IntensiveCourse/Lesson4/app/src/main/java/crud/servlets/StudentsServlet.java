package crud.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.model.Student;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO remove
        List<Student> students = new ArrayList<>();
        students.add(new Student("Eliyahu", "Santi", 11, "Computer Science"));

        Student student = null;

        int editid = (req.getParameter("editId")==null) ? 0 : Integer.parseInt(req.getParameter("editId"));
        int delId = (req.getParameter("delId")==null ? 0 : Integer.parseInt(req.getParameter("delId")));

        if (editid > 0) {
            // TODO: edit get student
            student = students.get(0);
        }
        if (delId > 0) {
            // TODO: remove student
            students.remove(0);
        }

        req.setAttribute("student", student);
        req.setAttribute("listStudent", students);
        req.getRequestDispatcher("jsps/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    
    
}

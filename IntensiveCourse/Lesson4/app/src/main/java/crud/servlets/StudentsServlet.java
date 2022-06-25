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
        // TODO
        List<Student> students = new ArrayList<>();
        students.add(new Student("Eliyahu", "Santi", 11, "Computer Science"));

        req.setAttribute("listStudent", students);
        req.getRequestDispatcher("jsps/students.jsp").forward(req, resp);
    }
    
}

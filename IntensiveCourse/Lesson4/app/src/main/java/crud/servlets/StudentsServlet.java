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
import crud.repo.StudentsRepo;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = null;
        List<Student> students = StudentsRepo.listStudents();

        int editid = (req.getParameter("editId") == null) ? 0 : Integer.parseInt(req.getParameter("editId"));
        int delId = (req.getParameter("delId") == null ? 0 : Integer.parseInt(req.getParameter("delId")));

        if (editid > 0) {
            // TODO: update student
        }
        if (delId > 0) {
            StudentsRepo.deleteStudent(delId);
        }

        req.setAttribute("student", student);
        req.setAttribute("listStudent", students);
        req.getRequestDispatcher("jsps/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = new Student(req.getParameter("firstName"),
                req.getParameter("lastName"),
                Integer.parseInt((String) req.getParameter("age")),
                req.getParameter("program"));

        StudentsRepo.addStudent(student);

        doGet(req, resp);
    }

}

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

        int editId = (req.getParameter("editId") == null ? 0 : Integer.parseInt(req.getParameter("editId")));
        int deleteId = (req.getParameter("deleteId") == null ? 0 : Integer.parseInt(req.getParameter("deleteId")));

        if (editId > 0) {
            student = StudentsRepo.findStudentById(editId);
        }
        if (deleteId > 0) {
            StudentsRepo.deleteStudent(deleteId);
        }

        List<Student> students = StudentsRepo.listStudents();

        req.setAttribute("student", student);
        req.setAttribute("listStudent", students);
        req.getRequestDispatcher("jsps/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student;
        boolean update;

        if (req.getParameter("studentId") == "") {
            update = false;
            student = new Student();
        }
        else {
            update = true;
            student = StudentsRepo.findStudentById(Integer.parseInt(req.getParameter("studentId")));
        }

        student.setFirstName(req.getParameter("firstName"));
        student.setLastName(req.getParameter("lastName"));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        student.setProgram(req.getParameter("program"));

        if (update) {
            StudentsRepo.updateStudent(student);
        }
        else {
            StudentsRepo.addStudent(student);
        }

        doGet(req, resp);
    }

}

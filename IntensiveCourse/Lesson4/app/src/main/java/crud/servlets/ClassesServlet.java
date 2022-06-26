package crud.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.model.Class;
import crud.repo.ClassesRepo;

@WebServlet("/classes")
public class ClassesServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Class clazz = null;

        int editId = (req.getParameter("editId") == null ? 0 : Integer.parseInt(req.getParameter("editId")));
        int deleteId = (req.getParameter("deleteId") == null ? 0 : Integer.parseInt(req.getParameter("deleteId")));

        if (editId > 0) {
            clazz = ClassesRepo.findClassById(editId);
        }
        if (deleteId > 0) {
            ClassesRepo.deleteClass(deleteId);
        }

        List<Class> classes = ClassesRepo.listClasses();

        req.setAttribute("class", clazz);
        req.setAttribute("listClasses", classes);
        req.getRequestDispatcher("jsps/classes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Class clazz;
        boolean update;

        if (req.getParameter("classId") == "") {
            update = false;
            clazz = new Class();
        }
        else {
            update = true;
            clazz = ClassesRepo.findClassById(Integer.parseInt(req.getParameter("classId")));
        }

        clazz.setTitle(req.getParameter("title"));
        clazz.setDescription(req.getParameter("description"));

        if (update) {
            ClassesRepo.updateClass(clazz);
        }
        else {
            ClassesRepo.addClass(clazz);
        }

        doGet(req, resp);
    }
    
}

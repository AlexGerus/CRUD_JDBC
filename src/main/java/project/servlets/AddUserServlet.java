package project.servlets;

import project.dbHelper.DBService;
import project.module.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        DBService dbService = null;
        try {
            dbService = new DBService();
            User user = new User(name, age);
            dbService.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/userList");
    }
}

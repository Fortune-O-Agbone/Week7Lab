/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author Fortune Agbone
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> users = null;
        
        try {
            users = userService.getAllUsers();
        } catch (Exception e){}
        
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && !action.isEmpty()) {
            if (action.equals("add")) {
                
                // get the incoming user parameters
                // call upon the add user method in user service
                // redirect the user back to the user page, or load the user.jsp
                
            } else if (action.equals("update")) {
                //updateUser(request, response);
            }
        }
    }

    /*
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        if (email != null && !email.isEmpty()) {
            deleteUser(email, response);
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        int roleId = Integer.parseInt(request.getParameter("role"));

        Role role = userService.getRoleById(roleId);

        if (role != null) {
            User newUser = new User(email, firstName, lastName, password, role);
            userService.addUser(newUser);

            response.sendRedirect(request.getContextPath() + "/users.jsp");
        } else {
            // Handle error - Invalid role ID
            // You may redirect to an error page or display an error message.
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int roleId = Integer.parseInt(request.getParameter("role"));

        Role role = userService.getRoleById(roleId);

        if (role != null) {
            User user;
            user = userService.getUserByEmail(email);
            if (user != null) {
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setRole(role);

                userService.updateUser(user);
            }

            response.sendRedirect(request.getContextPath() + "/users.jsp");
        } else {
            // Handle error - Invalid role ID
            // You may redirect to an error page or display an error message.
        }
    }

    private void deleteUser(String email, HttpServletResponse response)
            throws ServletException, IOException {
        User user;
        user = userService.getUserByEmail(email);
        if (user != null) {
            userService.deleteUser(user);
        }

        response.sendRedirect(request.getContextPath() + "/users.jsp");
    }
}
*/
}

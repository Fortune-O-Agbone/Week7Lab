<%-- 
    Document   : uses
    Created on : Jul 27, 2023, 7:50:26 PM
    Author     : Fortune Agbone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
    </head>

    <body>
        <h1>Manage Users</h1>

        <!-- Display the list of users -->
        <table>
            <tr>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Role</th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <!-- access the name from the role object, which is inside the user object -->
                    <td>${user.role.roleName}</td>

                    <td>
                        <a href="edit-user?email=${user.email}">Edit</a>
                    </td>

                    <td>
                        <a href="delete-user?email=${user.email}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <!-- Add user form -->
        <h2>Add User</h2>
        <form action="user" method="post">
            <div>
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required>
            </div>
            <div>
                <label for="firstName">First Name:</label>
                <input type="text" id="firstname" name="firstname">
            </div>
            <div>
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastname" name="lastname">
            </div>
            <div>
                <!-- insert code to edit user password. Note, password should not be
                     displayed and previous user password should be included-->
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
            </div>
            <div>
                <label for="role">Role:</label>
                <select id="role" name="role">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.roleId}">${role.roleName}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <input type="submit" name="Add user">
        </form>

        <!-- Edit User Form -->
        <h2>Edit User</h2>
        <form action="add-user" method="post">
            <!-- code to be inserted in order to retrieve user email address-->
            <label for="firstName">First Name:</label>
            <input type="text" id="firstname" name="firstname">

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastname" name="lastname">

            <label for="role">Role:</label>
            <select id="role" name="role">
                <c:forEach items="${roles}" var="role">
                    <option value="${role.roleId}">${role.roleName}</option>
                </c:forEach>
            </select><br>

            <input type="submit" name="Update" value="Update">
            <input type="submit" name="Cancel" value="Cancel">
        </form>
    </body>
</html>

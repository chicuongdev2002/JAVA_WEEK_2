<%@ page import="vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.EmployeeStatus" %>
<%--<%@ page import="vn.edu.iuh.fit.entities.Account" %>--%>
<%--<%@ page import="java.util.List" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Win 11--%>
<%--  Date: 9/15/2023--%>
<%--  Time: 3:14 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chính</title>
    <!-- Thêm CSS cho menu -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <style>
        ul.nav {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        ul.nav li {
            float: left;
        }

        ul.nav li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        ul.nav li a:hover {
            background-color: #ddd;
            color: black;
        }

        .logout-button {
            background-color: red;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .btn {
            padding: 5px 10px;
            background-color: #008CBA;
            color: white;
            border: none;
            cursor: pointer;
            text-decoration: none;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .btn-primary {
            background-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-danger {
            background-color: #dc3545;
        }

        .btn-danger:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
<div style="padding: 20px;">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>EmployeeID</th>
            <th>FullName</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("listEmployees");
            if (list != null) {
        %>
        <%

            for (Employee employee : list) {
                if (employee.getStatus().equals(EmployeeStatus.ACTIVE)) {
        %>
        <tr>
            <td><%=employee.getEmpId()%>
            </td>
            <td><%=employee.getFullName()%>
            </td>
            <td><%=employee.getDob()%>
            </td>
            <td><%=employee.getEmail()%>
            </td>
            <td><%=employee.getPhone()%>
            </td>

            <td><%=employee.getAddress()%>
            </td>
            <td><%=employee.getStatus()%>
            </td>
            <td>
                <a href="EmployeeController?actions=delete&empId=<%=employee.getEmpId()%>"
                   class="btn btn-danger"><i class="fas fa-trash"></i></a>
            </td>
        </tr>
        <%
            }

        %>

        <% } %>
        <%
            }else
                System.out.println("aaa");
        %>
        </tbody>
    </table>
</div>
</body>
<script>
</script>
</html>
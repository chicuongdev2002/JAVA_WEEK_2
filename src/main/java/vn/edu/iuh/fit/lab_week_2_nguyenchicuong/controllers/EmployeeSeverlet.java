package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.reposities.CustomerRepository;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.reposities.EmployeeRepository;

import java.io.IOException;

@WebServlet(name="EmployeeSeverlet",value = "/employeeSeverlet")
public class EmployeeSeverlet extends HttpServlet {
    EmployeeRepository employeeRepository=new EmployeeRepository();
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        delete(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           req.setAttribute("listEmployees",employeeRepository.getAllEmployees());
           req.getRequestDispatcher("WEB-INF/view/admin/listEmployee.jsp").forward(req,resp);
         // delete(req,resp);
    }
    void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            String action = req.getParameter("action");
            System.out.println(action);
            if ("delete".equalsIgnoreCase(action)) {
                String empId = req.getParameter("empId");
                if (empId != null) {
                    try {
                        long empID = Long.parseLong(empId);
                        boolean result = EmployeeRepository.deleteEmployee(empID);
                        if (result) {
                            resp.sendRedirect("employeeSeverlet");
                        } else {
                            // Xóa thất bại, ghi log
                            System.out.println("Xoa that bai");
                            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Xóa thất bại");
                        }
                    } catch (NumberFormatException e) {
                        // Xử lý tham số custId không hợp lệ
                        System.out.println("Invalid custId parameter");
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid custId parameter");
                    }
                } else {
                    // Xử lý trường hợp thiếu tham số custId
                    System.out.println("custId parameter is missing");
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "custId parameter is missing");
                }
            }
        }

    }
}

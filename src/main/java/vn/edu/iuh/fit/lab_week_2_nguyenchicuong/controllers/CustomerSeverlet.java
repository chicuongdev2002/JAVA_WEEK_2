package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.Customer;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.reposities.CustomerRepository;

import java.io.IOException;

@WebServlet(name = "CustomerSeverlet",value = "/customer-severlet")

public class CustomerSeverlet extends HttpServlet {
    private  CustomerRepository customerRepository=new CustomerRepository(Customer.class);
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Thanh cong");
//            System.out.println(CustomerRepository.getAllCustomers());
        req.setAttribute("listCustomers", customerRepository.getAll());
        req.getRequestDispatcher("WEB-INF/view/admin/listCustomer.jsp").forward(req, resp);
       // delete(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("edit".equalsIgnoreCase(action)) {
            req.getRequestDispatcher("WEB-INF/view/admin/editCustomer.jsp").forward(req,resp);
            long custId = Long.parseLong(req.getParameter("custId"));
            String newCustName = req.getParameter("custName");
            String newEmail = req.getParameter("email");
            String newAddress = req.getParameter("address");
            String newPhone = req.getParameter("phone");
            Customer customer=new Customer(newCustName,newEmail,newAddress,newPhone);
            boolean result = customerRepository.update(customer);
            if (result) {

                resp.sendRedirect("customer-severlet");
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Update failed");
            }
        } else {
        }
    }


//    void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        {
//            String action = req.getParameter("action");
//            System.out.println(action);
//            if ("delete".equalsIgnoreCase(action)) {
//                String custIdParam = req.getParameter("custId");
//                System.out.println(custIdParam);
//                if (custIdParam != null) {
//                    try {
//                        long custId = Long.parseLong(custIdParam);
//
//                        boolean result = customerRepository.delete(custId);
//                        System.out.println(result);
//                        if (result) {
//                            resp.sendRedirect("customer-severlet");
//                        } else {
//                            // Xóa thất bại, ghi log
//                            System.out.println("Xóa thất bại");
//                            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Xóa thất bại");
//                        }
//                    } catch (NumberFormatException e) {
//                        // Xử lý tham số custId không hợp lệ
//                        System.out.println("Invalid custId parameter");
//                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid custId parameter");
//                    }
//                } else {
//                    // Xử lý trường hợp thiếu tham số custId
//                    System.out.println("custId parameter is missing");
//                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "custId parameter is missing");
//                }
//            }
//        }

   // }
}

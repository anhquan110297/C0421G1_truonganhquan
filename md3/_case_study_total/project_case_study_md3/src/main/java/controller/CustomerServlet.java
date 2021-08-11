package controller;

import models.bean.customer.Customer;
import models.bean.employee.Employee;
import service.model_service.cusomer_service.CustomerService;
import service.model_service.cusomer_service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                viewCreateCustomer(request,response);
                break;
            case "edit":
                viewEditCustomer(request,response);
                break;
            default:
                showCustomer(request,response);
                break;
        };
    }

    private void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        String msg = "Employee List is empty";
        List<Customer> customerList = null;
        customerList = this.customerService.displayCustomer();
        if (customerList == null) {
            request.setAttribute("msg", msg);
        }
        try {
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("customer_view/view-customer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewEditCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
    }
}

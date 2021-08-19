package controller;

import models.bean.customer.Customer;
import models.bean.customer.CustomerType;
import models.repositories.customer_repository.CustomerRepository;
import service.cusomer_service.CustomerService;
import service.cusomer_service.CustomerTypeService;
import service.cusomer_service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    CustomerRepository customerRepository = new CustomerRepository();
    CustomerTypeService customerTypeService = new CustomerTypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                actionCreate(request,response);
                break;
            case "edit":
                actionEdit(request,response);
                break;
            case "remove":
                actionRemove(request,response);
                break;
            default:
                showCustomer(request,response);
                break;
        }
    }

    private void actionCreate(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = new Customer();
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerCode = request.getParameter("customerCode");
        customer = new Customer(name,birthday,idCard,email,phone,address,gender,customerTypeId,customerCode);
        Map<String,String> result = this.customerService.createCustomer(customer);
            try {
                if (result.isEmpty()) {
                    request.setAttribute("msg", "Success!");
                } else {
                    request.setAttribute("nameValidate",result.get("name"));
                    request.setAttribute("phoneValidate",result.get("telephoneNumber"));
                    request.setAttribute("emailValidate",result.get("email"));
                    request.setAttribute("customerCodeValidate",result.get("customerCode"));
                    viewCreateCustomer(request,response);
                }
                request.getRequestDispatcher("customer_view/view-create-customer.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    private void actionEdit(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = new Customer();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerCode = request.getParameter("customerCode");
        customer = new Customer(name,birthday,idCard,email,phone,address,gender,customerTypeId,customerCode);
        customer.setId(id);
        List<CustomerType> customerTypeList = this.customerTypeService.customerTypeList();
        request.setAttribute("customerTypeList",customerTypeList);
        request.setAttribute("customer", customer);
        boolean result = this.customerService.editCustomer(customer);
        try {
            if (result){
            request.setAttribute("msg","Success!");
            request.getRequestDispatcher("customer_view/view-edit-customer.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("error-404.jsp").forward(request,response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actionRemove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = this.customerService.removeCustomer(id);

        try {
            if (result){
                request.setAttribute("msg","Success!");
                showCustomer(request,response);
            } else {
                request.getRequestDispatcher("error-404.jsp").forward(request,response);
            }
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
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
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        List<CustomerType> customerTypeList = this.customerTypeService.customerTypeList();
        request.setAttribute("customerTypeList",customerTypeList);
        request.setAttribute("customer",customer);
        try {
            request.getRequestDispatcher("customer_view/view-edit-customer.jsp").forward(request,response);
        } catch (ServletException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void viewCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = null;
        customerTypeList = this.customerTypeService.customerTypeList();
        request.setAttribute("customerType",customerTypeList);
        try {
            request.getRequestDispatcher("customer_view/view-create-customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

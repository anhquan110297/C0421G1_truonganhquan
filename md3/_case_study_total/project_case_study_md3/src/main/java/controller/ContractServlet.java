package controller;

import models.bean.contract.Contract;
import models.bean.customer.Customer;
import models.bean.employee.Employee;
import models.bean.service.Service;
import service.contract_service.ContractService;
import service.contract_service.IContractService;
import service.cusomer_service.CustomerService;
import service.cusomer_service.ICustomerService;
import service.employee_service.EmployeeService;
import service.employee_service.IEmployeeService;
import service.service_service.IServiceService;
import service.service_service.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    ICustomerService customerService = new CustomerService();
    IServiceService service = new ServiceService();
    IContractService contractService = new ContractService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")) {
            actionCreate(request, response);
        }
    }

    private void actionCreate(HttpServletRequest request, HttpServletResponse response) {
        String contractStartDate = request.getParameter("startDate");
        String contractEndDate = request.getParameter("endDate");
        double contractDeposit = Double.parseDouble(request.getParameter("deposit"));
        double contractTotalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        int employeeId = Integer.parseInt(request.getParameter("employee"));
        int customerId = Integer.parseInt(request.getParameter("customer"));
        int serviceId = Integer.parseInt(request.getParameter("service"));
        Contract contract = new Contract(contractStartDate,contractEndDate,contractDeposit,contractTotalMoney,employeeId
                ,customerId,serviceId);
        boolean result = this.contractService.createContract(contract);
        if (result){
            try {
                request.setAttribute("msg", "Success!");
                request.getRequestDispatcher("contract_view/contract-view-create.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.getRequestDispatcher("error-404.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            viewContract(request,response);
        } else {
            viewCreate(request, response);
        }
    }

    private void viewContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = this.contractService.showContract();
        try {
            request.setAttribute("contract",contractList);
            request.getRequestDispatcher("contract_view/view-contract.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = this.employeeService.displayEmployeeList();
        List<Customer> customerList = this.customerService.displayCustomer();
        List<Service> serviceList = this.service.displayService();
        try {
            request.setAttribute("employee",employeeList );
            request.setAttribute("customer",customerList );
            request.setAttribute("service",serviceList );
            request.getRequestDispatcher("contract_view/contract-view-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

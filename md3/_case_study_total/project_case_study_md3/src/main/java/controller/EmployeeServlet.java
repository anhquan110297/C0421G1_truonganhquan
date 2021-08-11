package controller;

import models.bean.employee.Division;
import models.bean.employee.EducationDegree;
import models.bean.employee.Employee;
import models.bean.employee.Position;
import service.model_service.employee_service.EmployeeService;
import service.model_service.employee_service.IEmployeeService;
import service.model_service.employee_service.DivisionService;
import service.model_service.employee_service.EducationDegreeService;
import service.model_service.employee_service.ILinkedEmployeeService;
import service.model_service.employee_service.PositionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    ILinkedEmployeeService divisionService = new DivisionService();
    ILinkedEmployeeService EducationDegreeService = new EducationDegreeService();
    ILinkedEmployeeService PositionService = new PositionService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                actionCreate(request, response);
                break;
            case "edit":
                actionEdit(request, response);
                break;
            case "remove":
                actionRemove(request, response);
                break;
            default:
                break;
        }

    }

    private void actionRemove(HttpServletRequest request, HttpServletResponse response) {
        // lay gia tri id tu` truong id trong form modal
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.findPersonById(id);
        request.setAttribute("employeeRemove",employee);
        boolean result = this.employeeService.removeEmployee(employee);
        try {
            if (result) {
                request.setAttribute("msg", "Success!");
                request.getRequestDispatcher("employee_view/view-employee.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("error-404.jsp");
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void actionEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
//        String userName = request.getParameter("userName");
        Employee employee = new Employee(id, name, birthDay, idCard, email, phone, address, salary, positionId, divisionId, educationDegreeId);
        boolean result = this.employeeService.editEmployee(employee);
        request.setAttribute("employee", employee);
        try {
            if (result) {
                request.setAttribute("msg", "Success!");
                request.getRequestDispatcher("employee_view/view-edit-employee.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("error-404.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actionCreate(HttpServletRequest request, HttpServletResponse response) {
        String msg = "Success";
        Employee employee = new Employee();
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionID = Integer.parseInt(request.getParameter("positionID"));
        int educationDegreeID = Integer.parseInt(request.getParameter("educationDegreeID"));
        int divisionID = Integer.parseInt(request.getParameter("divisionID"));
        employee = new Employee(name, birthday, idCard, email, phone, address, salary, positionID, divisionID, educationDegreeID);
        boolean result = this.employeeService.CreateEmployee(employee);
        try {
            if (result) {
                request.setAttribute("msg", msg);
            } else {
                request.getRequestDispatcher("error-404.jsp").forward(request, response);
            }
            request.getRequestDispatcher("employee_view/view-create-employee.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                viewCreateEmployee(request, response);
                break;
            case "edit":
                viewEditEmployee(request, response);
                break;
            default:
                viewEmployeeList(request, response);
                break;
        }

    }

    private void viewEditEmployee(HttpServletRequest request, HttpServletResponse response) {
        //select division
        List<Division> divisionList = new ArrayList<>();
        divisionList = this.divisionService.showAll();
        request.setAttribute("divisionList",divisionList);
        //select education
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        educationDegreeList = this.EducationDegreeService.showAll();
        request.setAttribute("educationDegreeList",educationDegreeList);
        //select position
        List<Position> positionList = new ArrayList<>();
        positionList = this.PositionService.showAll();
        request.setAttribute("positionList",positionList);
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = this.employeeService.findPersonById(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("employee_view/view-edit-employee.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        //select division
        List<Division> divisionList = new ArrayList<>();
        divisionList = this.divisionService.showAll();
        request.setAttribute("divisionList",divisionList);
        //select education
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        educationDegreeList = this.EducationDegreeService.showAll();
        request.setAttribute("educationDegreeList",educationDegreeList);
        //select position
        List<Position> positionList = new ArrayList<>();
        positionList = this.PositionService.showAll();
        request.setAttribute("positionList",positionList);
        try {
            request.getRequestDispatcher("employee_view/view-create-employee.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        String msg = "Employee List is empty";
        List<Employee> employeeList = null;
        employeeList = this.employeeService.displayEmployeeList();
        if (employeeList == null) {
            request.setAttribute("msg", msg);
        }
        try {
            request.setAttribute("employeeList", employeeList);
            request.getRequestDispatcher("employee_view/view-employee.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

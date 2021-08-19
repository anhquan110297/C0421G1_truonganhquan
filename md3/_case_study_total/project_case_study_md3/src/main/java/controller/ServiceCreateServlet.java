package controller;

import models.bean.service.RentType;
import models.bean.service.Service;
import models.bean.service.ServiceType;
import models.repositories.service_repository.ISubServiceRepository;
import service.service_service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceCreateServlet",urlPatterns = "/service")
public class ServiceCreateServlet extends HttpServlet {
    IServiceService serviceService = new ServiceService();
    ISubServiceService rentTypeService = new RentTypeService();
    ISubServiceService serviceTypeService = new ServiceTypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")){
            actionCreate(request,response);
        }
    }

    private void actionCreate(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloor = Integer.parseInt(request.getParameter("numberOfFloor"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        Service service = new Service(serviceName,serviceArea,serviceCost,serviceMaxPeople,standardRoom,
        description,poolArea,numberOfFloor,rentTypeId,serviceTypeId);
        boolean result = this.serviceService.createService(service);
            try {
                if (result) {
                    request.setAttribute("msg", "Success!");
                    request.getRequestDispatcher("service_view/view-create-service.jsp").forward(request, response);
                }
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
        if ("create".equals(action)) {
            viewCreate(request, response);
        } else {
            viewService(request, response);
        }
    }



    private void viewCreate(HttpServletRequest request, HttpServletResponse response) {
        List rentTypeList = this.rentTypeService.showList();
        List serviceTypeList = this.serviceTypeService.showList();
        try {
                request.setAttribute("rentTypeList",rentTypeList);
                request.setAttribute("serviceTypeList",serviceTypeList);
                request.getRequestDispatcher("service_view/view-create-service.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewService(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("service_view/view-service.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

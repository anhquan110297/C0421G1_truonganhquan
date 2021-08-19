package controller;

import model.bean.Category;
import model.bean.Color;
import model.bean.Product;
import model.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    ISubService colorService = new ColorService();
    ISubService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                actionCreate(request,response);
                break;
            case "remove":
                actionRemove(request,response);
            case "searchName":
                searchName(request,response);
                break;
        }
    }

    private void searchName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("searchName");
        List<Product> productNameList = new ArrayList<>();
        productNameList = this.productService.searchByName(name);
        request.setAttribute("productNameList",productNameList);
        try {
            request.getRequestDispatcher("view/view-search-name.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actionRemove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = this.productService.remove(id);
        try {
            if (result){
                request.setAttribute("msg","Success!");
                viewList(request, response);
            } else {
                request.getRequestDispatcher("error-404.jsp").forward(request,response);
            }
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void actionCreate(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String description = request.getParameter("description");
        int idColor = Integer.parseInt(request.getParameter("idColor"));
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Product product = new Product(name,price,amount,description,idColor,idCategory);
        boolean result = this.productService.create(product);
        try {
            if (result) {
                request.setAttribute("msg","Sucesss!");
                request.getRequestDispatcher("view/view-create.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
                viewCreate(request,response);
                break;
            default:
                viewList(request,response);
                break;
        }
    }

    private void viewList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = new ArrayList<>();
        productList = this.productService.display();
        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("view/homepage.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Color> colorList = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        colorList = this.colorService.display();
        categoryList = this.categoryService.display();
        request.setAttribute("colorList",colorList);
        request.setAttribute("categoryList",categoryList);
        try {
            request.getRequestDispatcher("view/view-create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewEdit(HttpServletRequest request, HttpServletResponse response) {
    }
}

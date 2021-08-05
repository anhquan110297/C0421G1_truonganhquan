package models_servlet;

import models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add( new Customer("Quan","2020-03-08","DaNang","https://duhochfc.vn/images/files/duhochfc.vn/anh-nguoi-dep-han-quoc-top-anh-hot-girl-xinh-nhat-xu-so-kim-chi-%2015.jpg"));
        customerList.add( new Customer("Quan2","2020-02-08","QuangNam","https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/10/bi-quyet-chup-anh-dep-cho-nguoi-khong-an-anh-3.jpg"));
        customerList.add( new Customer("Quan3","2020-04-08","DaLat","https://duhochfc.vn/images/files/duhochfc.vn/anh-nguoi-dep-han-quoc-top-anh-hot-girl-xinh-nhat-xu-so-kim-chi-%2015.jpg"));
        customerList.add( new Customer("Quan4","2020-05-08","QuangNgai","https://duhochfc.vn/images/files/duhochfc.vn/anh-nguoi-dep-han-quoc-top-anh-hot-girl-xinh-nhat-xu-so-kim-chi-%2015.jpg"));
        request.setAttribute("customerListServlet",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}

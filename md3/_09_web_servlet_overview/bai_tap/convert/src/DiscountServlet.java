import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet",urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float ListPrice = Float.parseFloat(request.getParameter("listPricce"));
        int percent = Integer.parseInt(request.getParameter("percent"));
        double discountAmount = ListPrice * percent * 0.01;
        double discountPrice = ListPrice - discountAmount;


        request.setAttribute("description",description);
        request.setAttribute("ListPrice",ListPrice);
        request.setAttribute("percent",percent);
        request.setAttribute("discountAmount",discountAmount);
        request.setAttribute("discountPrice",discountPrice);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}

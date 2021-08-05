import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "SimpleCalculatorServlet", urlPatterns = "/result")
public class SimpleCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
        String operator = request.getParameter("operator");
        double result = 0;
        String error = "";
        try {
            result = new Calculator().simpleCalculator(firstOperand, secondOperand, operator);
        } catch (Exception e){
            error =  e.getMessage();
        }
        request.setAttribute("firstOperand", firstOperand);
        request.setAttribute("secondOperand", secondOperand);
        request.setAttribute("operator", operator);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}

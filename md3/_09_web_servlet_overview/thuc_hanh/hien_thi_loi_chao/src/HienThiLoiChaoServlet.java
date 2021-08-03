import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HienThiLoiChaoServlet", urlPatterns = "/login")
public class HienThiLoiChaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String loiChao = "Welcome " + userName + " to website";
        String loiKhongChao = "Login Error";
        if ("admin".equals(userName) && "admin".equals(password)) {
            request.setAttribute("result", loiChao);
        } else {
            request.setAttribute("result", loiKhongChao);
        }
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("anhquan");
    }
}

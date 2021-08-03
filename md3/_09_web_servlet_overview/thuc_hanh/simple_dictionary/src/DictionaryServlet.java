import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet",urlPatterns = "/dictionary")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello","xin chào");
        dictionary.put("good bye","tạm biệt");
        dictionary.put("handsome","đẹp trai");
        dictionary.put("table","cái bàn");
        String search  = request.getParameter("txtsearch");
        String result = dictionary.get(search);
        String notFound = "Not Found";
        if (result != null){
            request.setAttribute("word",search);
            request.setAttribute("result",result);
        }else {
            request.setAttribute("not_found",notFound);
        }
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}

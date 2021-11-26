import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double price = Double.parseDouble(request.getParameter("listPrice"));
        double discount = Double.parseDouble(request.getParameter("discountPercent"));
        double result = price*discount*0.01;
        String description = request.getParameter("txtSearch");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h2 style='color:black'>" + "Description: " + description + "</h2>");
        writer.println("<div><h2 style='color:black'>" + "Price: " + price + "</h2></div>");
        writer.println("<div><h2 style='color:black'>" + "Discount: " + discount + "</h2></div>");
        writer.println("<div><h2 style='color:red'>" + " Result: " + result + "</h2></div>");
        writer.println("</body>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

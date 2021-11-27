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
        double price = 0;
        double discount = 0;
        double result = 0;
        String description = request.getParameter("txtSearch");
        try {
            price=  Double.parseDouble(request.getParameter("listPrice"));
             discount = Double.parseDouble(request.getParameter("discountPercent"));
             result = price*discount*0.01;
            if (price <0 || discount <0){
                request.setAttribute("errmsg", "giá nhập vào phải lớn hơn 0");
                request.getRequestDispatcher("err.jsp").forward(request,response);
            }else {
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
        }catch (Exception e){
            request.setAttribute("errmsg", "ban phải nhập vào số");
            request.getRequestDispatcher("err.jsp").forward(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

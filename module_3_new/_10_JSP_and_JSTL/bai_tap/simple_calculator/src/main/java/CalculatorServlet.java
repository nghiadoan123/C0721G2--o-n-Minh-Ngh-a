import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/cal")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = 0;
        float secondOperand = 0;
        char operator = request.getParameter("operator").charAt(0);

        try {
            firstOperand = Integer.parseInt(request.getParameter("first-operand"));
            secondOperand = Integer.parseInt(request.getParameter("second-operand"));
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            request.setAttribute("Calculator", result);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("Calculator", e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

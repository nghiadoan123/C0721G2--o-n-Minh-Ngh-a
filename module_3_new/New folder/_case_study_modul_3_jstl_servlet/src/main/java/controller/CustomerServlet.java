package controller;

import bean.customer.Customer;
import bean.employee.Employee;
import service.ICustomerService;
import service.IEmployeeService;
import service.impl.CustomerServiceImpl;
import service.impl.EmployServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet" , urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    ICustomerService iCustomerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null){
            userAction ="";
        }
        switch (userAction){
            case "create":

                break;
            case "edit":

                break;
            case "search":

                break;
            default:

                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null){
            userAction ="";
        }
        switch (userAction){
            case "create":

                break;
            case "edit":

                break;
            case "delete":

                break;
            default:
                customerList(request,response);
                break;

        }
    }

    public void customerList(HttpServletRequest request, HttpServletResponse response){
        List<Customer> customerList = this.iCustomerService.findAll();
        
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("pages/customer/customerList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

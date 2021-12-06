package controller;

import bean.employee.Employee;
import bean.service.Service;
import repository.impl.ServiceRepositoryImpl;
import service.IServiceService;
import service.impl.ServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService iServiceService = new ServiceServiceImpl();

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
//                showCreateForm(request,response);
                break;
            case "edit":
//                showEditForm(request,response);
                break;
            case "delete":

                break;
            default:
            serviceList(request,response);
                break;

        }
    }

    public void serviceList(HttpServletRequest request, HttpServletResponse response){
        List<Service> serviceList = this.iServiceService.findAll();
        request.setAttribute("serviceList",serviceList);

        // phần sesion để lấy thông tin lưu sẵn trong tên nhân viên bỏ vào các trang
        HttpSession session = request.getSession();
        String username =  session.getAttribute("usernameinfo").toString();
        String password =  session.getAttribute("passwordinfo").toString();


        try {
            request.getRequestDispatcher("pages/service/serviceList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

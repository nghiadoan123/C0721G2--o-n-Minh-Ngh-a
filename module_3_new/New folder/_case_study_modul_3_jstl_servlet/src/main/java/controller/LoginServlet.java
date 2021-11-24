package controller;

import bean.employee.Login;
import service.ILoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns =  {"", "/login"})
public class LoginServlet extends HttpServlet {
    ILoginService iLoginService = new LoginServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);


        if (iLoginService.login(login)) {
            request.setAttribute("loginInformation",login);
            request.getRequestDispatcher("pages/home/home.jsp").forward(request,response);
//            response.sendRedirect("/home");
        } else {
            request.setAttribute("messageLogin", "incorrect username or pass word");
            response.sendRedirect("/index.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/login/login.jsp").forward(request,response);
    }
}

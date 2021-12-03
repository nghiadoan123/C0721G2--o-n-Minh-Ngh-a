package controller;

import bean.customer.Customer;
import bean.customer.CustomerType;
import bean.employee.Division;
import bean.employee.EducationDegree;
import bean.employee.Employee;
import bean.employee.Position;
import repository.impl.GetInformationSQL;
import service.ICustomerService;
import service.IEmployeeService;
import service.impl.CustomerServiceImpl;
import service.impl.EmployServiceImpl;
import util.Validate;

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
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "search":
                searchNameCustomer(request,response);
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
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;

            default:
                customerList(request,response);
                break;

        }
    }

    public void customerList(HttpServletRequest request, HttpServletResponse response){
        List<Customer> customerList = this.iCustomerService.findAll();
        
        request.setAttribute("customerList",customerList);


        //        HttpSession session = request.getSession();
//        String username =  session.getAttribute("usernameinfo").toString();
//        String password =  session.getAttribute("passwordinfo").toString();

        try {
            request.getRequestDispatcher("pages/customer/customerList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.remove(id);

        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchNameCustomer(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("searchName");
        List<Customer> customerList = this.iCustomerService.findByName(name);
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("pages/customer/customerList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateForm(HttpServletRequest request, HttpServletResponse response){

        List<CustomerType> customerTypeList = GetInformationSQL.customerTypeList();
        request.setAttribute("customerTypeList",customerTypeList);

        try {
            request.getRequestDispatcher("/pages/customer/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(HttpServletRequest request, HttpServletResponse response){
        String customerIDMess = null;
        String emailIMess = null;
        String phoneIMess = null;
        String idCardIMess = null;
        boolean flag = true;

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerType"));


        Customer customer = new Customer();
        CustomerType customerType = new CustomerType();
        customerType.setId(customerTypeId);

        customer.setId(id);
        customer.setName(name);
        customer.setBirthDay(birthday);
        customer.setGender(gender);
        customer.setIdCard(idCard);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setCustomerType(customerType);

//        if (!Validate.validateIdCustomer(request.getParameter("id"))){
//            flag = false;
//            customerIDMess = "Customer id invalid ex: KH-1234";
//        }

        if (!Validate.validateEmail(email)){
            flag = false;
            emailIMess = "email invalid ex: john@gmail.com";
        }

        if (!Validate.validatePhonenumber(phone)){
            flag = false;
            phoneIMess = "phone invalid ex: 0905111111";
        }

        if (!Validate.validatePersonalId(idCard)){
            flag = false;
            idCardIMess = "personal id  invalid ex: xxxx... with x = 9 or x = 12";
        }

        if (!flag) {
            request.setAttribute("customerError",customerIDMess);
            request.setAttribute("emailError",emailIMess);
            request.setAttribute("phoneError",phoneIMess);
            request.setAttribute("idcardError",idCardIMess);
            showCreateForm(request,response);
        }else {
            this.iCustomerService.save(customer);
            try {
                response.sendRedirect("/customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.iCustomerService.findById(id);
        List<CustomerType> customerTypeList = GetInformationSQL.customerTypeList();


        request.setAttribute("customer",customer);
        request.setAttribute("customerTypeList",customerTypeList);

        try {
            request.getRequestDispatcher("/pages/customer/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(HttpServletRequest request, HttpServletResponse response){

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerType"));

        CustomerType customerType = new CustomerType();
        customerType.setId(customerTypeId);
        Customer customer = new Customer(id,customerType,  name, birthDay, gender, idCard, phone, email, address);

        this.iCustomerService.update(customer);

        // cách 2 dùng redirect
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

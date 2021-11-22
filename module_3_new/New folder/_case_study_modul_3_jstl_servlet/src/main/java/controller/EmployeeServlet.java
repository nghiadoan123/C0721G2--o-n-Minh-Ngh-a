package controller;

import bean.employee.Division;
import bean.employee.EducationDegree;
import bean.employee.Employee;
import bean.employee.Position;
import jdk.nashorn.internal.ir.RuntimeNode;
import repository.impl.GetInformationSQL;
import service.IEmployeeService;
import service.impl.EmployServiceImpl;
import util.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    IEmployeeService iEmployeeService = new EmployServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null){
            userAction ="";
        }
        switch (userAction){
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                updateEmployee(request,response);
                break;
            case "search":
                searchNameEmployee(request,response);
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
                deleteEmployee(request,response);
                break;
            default:
                employeeList(request,response);
                break;

        }
    }


    public void employeeList(HttpServletRequest request, HttpServletResponse response){
        List<Employee> employeeList = this.iEmployeeService.findAll();
        request.setAttribute("employeeList",employeeList);
        try {
            request.getRequestDispatcher("pages/employee/employeeList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showCreateForm(HttpServletRequest request, HttpServletResponse response){

        List<Division> divisionList = GetInformationSQL.divisionList();
        List<EducationDegree> educationDegreeList = GetInformationSQL.educationDegreeList();
        List<Position> positionList = GetInformationSQL.positionList();

        request.setAttribute("divisionList",divisionList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("positionList",positionList);
        try {
            request.getRequestDispatcher("/pages/employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String personalIDMess = null;
        String phoneNumberMess = null;
        String salaryMess = null;
        String emailMess = null;
        boolean flag = true;

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        Double salary = 0d;
        try {
            salary = Double.parseDouble(request.getParameter("salary"));

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            salaryMess = "Salary is invalid!";
            flag = false;
        }

        int degreeID = Integer.parseInt(request.getParameter("degree"));
        int divisionID = Integer.parseInt(request.getParameter("division"));
        int positionID = Integer.parseInt(request.getParameter("position"));


        if (!Validate.validatePersonalId(idCard)) {
            personalIDMess = "Personal ID is invalid! EX: xxx... (x = 9 or x = 12) ";
            flag = false;
        }
        if (!Validate.validatePhonenumber(phone)) {
            phoneNumberMess = "Phone Number is invalid! EX: 0903111111";
            flag = false;
        }
        if (salary < 0 || salary.isNaN()) {
            salaryMess = "Salary is invalid! Salary>0";
            flag = false;
        }
        if (!Validate.validateEmail(email)) {
            emailMess = "Email is invalid! EX: aaa@gmail.com";
            flag = false;
        }

        Employee employee = new Employee();
        EducationDegree educationDegree = new EducationDegree();
        Division division = new Division();
        Position position = new Position();
        employee.setId(id);
        employee.setName(name);
        employee.setBirthDay(birthday);
        employee.setIdCard(idCard);
        employee.setPhone(phone);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setEmail(email);

        educationDegree.setId(degreeID);
        division.setId(divisionID);
        position.setId(positionID);

        employee.setEducationDegree(educationDegree);
        employee.setDivision(division);
        employee.setPosition(position);



        if (!flag) {
            request.setAttribute("personalIDMess", personalIDMess);
            request.setAttribute("phoneNumberMess", phoneNumberMess);
            request.setAttribute("salaryMess", salaryMess);
            request.setAttribute("emailMess", emailMess);
            request.setAttribute("employee", employee);


//            List<Division> divisionList = GetInformationSQL.divisionList();
//            List<EducationDegree> educationDegreeList = GetInformationSQL.educationDegreeList();
//            List<Position> positionList = GetInformationSQL.positionList();
//
//            request.setAttribute("divisionList",divisionList);
//            request.setAttribute("educationDegreeList",educationDegreeList);
//            request.setAttribute("positionList",positionList);

            showCreateForm(request,response);

//            try {
//                request.getRequestDispatcher("pages/employee/create.jsp").forward(request,response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        } else {
            this.iEmployeeService.save(employee);
            try {
               response.sendRedirect("/employee");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Employee employee = this.iEmployeeService.findById(id);
        List<Division> divisionList = GetInformationSQL.divisionList();
        List<EducationDegree> educationDegreeList = GetInformationSQL.educationDegreeList();
        List<Position> positionList = GetInformationSQL.positionList();

        request.setAttribute("employee",employee);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("positionList",positionList);

        try {
            request.getRequestDispatcher("/pages/employee/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateEmployee(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String id_card = request.getParameter("id_card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");


        int degreeID = Integer.parseInt(request.getParameter("degree"));
        int divisionID = Integer.parseInt(request.getParameter("division"));
        int positionID = Integer.parseInt(request.getParameter("position"));

        Employee employee = new Employee();
        EducationDegree educationDegree = new EducationDegree();
        Division division = new Division();
        Position position = new Position();

        educationDegree.setId(degreeID);
        division.setId(divisionID);
        position.setId(positionID);

        employee.setId(id);
        employee.setName(name);
        employee.setBirthDay(birthday);
        employee.setIdCard(id_card);
        employee.setSalary(salary);
        employee.setPhone(phone);
        employee.setAddress(address);
        employee.setEmail(email);
        employee.setEducationDegree(educationDegree);
        employee.setDivision(division);
        employee.setPosition(position);


        this.iEmployeeService.update(employee);

//        request.setAttribute("employee_update",employee);
//        try {
//            request.getRequestDispatcher("pages/employee/edit.jsp").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        // cách 2 dùng redirect
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        this.iEmployeeService.remove(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchNameEmployee(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("searchName");
        List<Employee> employeeList = this.iEmployeeService.findByName(name);
        request.setAttribute("employeeList",employeeList);
        try {
            request.getRequestDispatcher("pages/employee/employeeList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

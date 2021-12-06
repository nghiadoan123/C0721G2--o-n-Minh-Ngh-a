package controller;

import bean.Student;
import bean.StudentClass;
import service.IStudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentServlet", urlPatterns = {"","/student"})
public class StudentServlet extends HttpServlet {

    IStudentService iStudentService = new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null){
            userAction ="";
        }
        switch (userAction){
            case "create":
                createForm(request,response);
                break;
            case "edit":
                editForm(request,response);
                break;
            case "sort":
                sortAverage(request,response);
                break;
            case "search":
                searchStudent(request,response);
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

            case "search":

                break;

            case "delete":
                deleteUser(request,response);
                break;
            default:
                studentList(request,response);
                break;


        }
    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Student> studentList = this.iStudentService.findByName(name);
        request.setAttribute("studentList",studentList);
        List<StudentClass> studentClassList = this.iStudentService.findAllClass();
        request.setAttribute("studentClassList",studentClassList);
        try {
            request.getRequestDispatcher("student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortAverage(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList =  this.iStudentService.sortByAverage();
        request.setAttribute("studentList",studentList);
        List<StudentClass> studentClassList = this.iStudentService.findAllClass();
        request.setAttribute("studentClassList",studentClassList);
        try {
            request.getRequestDispatcher("student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("student/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        double average = Double.parseDouble(request.getParameter("average"));
        int idClass = Integer.parseInt(request.getParameter("idClass"));

        Student student = new Student(id,name,gender,age,average,idClass);

        Map<String,String> message = this.iStudentService.save(student);

        if (message.isEmpty()){
            try {
                response.sendRedirect("/student");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("errormessage", message.get("message"));
            request.setAttribute("messageName", message.get("messageName"));
            request.setAttribute("messageAge", message.get("messageAge"));
            request.setAttribute("messageAverage", message.get("messageAverage"));
            this.showCreateForm(request,response);
        }

    }



    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.iStudentService.findById(id);
        request.setAttribute("edit",student);
        try {
            request.getRequestDispatcher("student/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void editForm(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        double average = Double.parseDouble(request.getParameter("average"));
        int classId = Integer.parseInt(request.getParameter("classId"));


        Student student = new Student(id,name,gender,age,average,classId);

        Map<String,String> message = this.iStudentService.update(student);

        if (message.isEmpty()){
            try {
                response.sendRedirect("/student");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("errormessage", message.get("message"));
            request.setAttribute("messageName", message.get("messageName"));
            request.setAttribute("messageAge", message.get("messageAge"));
            request.setAttribute("messageAverage", message.get("messageAverage"));
            this.showEditForm(request,response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.iStudentService.remove(id);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void studentList(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = this.iStudentService.findAll();
        request.setAttribute("studentList",studentList);
        List<StudentClass> studentClassList = this.iStudentService.findAllClass();
        request.setAttribute("studentClassList",studentClassList);
        try {
            request.getRequestDispatcher("student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package controller;

import bean.BenhAn;
import bean.BenhNhan;
import bean.DanhSachBenhAn;
import service.IDanhSachBenhAnService;
import service.impl.DanhSachBenhAnServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BenhAnServlet", urlPatterns = {"","/danhsachbenhnhan"})
public class BenhAnServlet extends HttpServlet {
    IDanhSachBenhAnService iDanhSachBenhAnService = new DanhSachBenhAnServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null){
            userAction ="";
        }
        switch (userAction){
//            case "create":
//                createForm(request,response);
//                break;
//            case "edit":
//                editForm(request,response);
//                break;
//            case "sort":
//                sortAverage(request,response);
//                break;
//            case "search":
//                searchStudent(request,response);
//                break;
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
//            case "create":
//                showCreateForm(request,response);
//                break;
            case "edit":
                showEditForm(request,response);
                break;
//
//            case "search":
//
//                break;
//
            case "delete":
                delete(request,response);
                break;
            default:
                list(request,response);
                break;


        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.iDanhSachBenhAnService.remove(id);
        try {
            response.sendRedirect("/danhsachbenhnhan");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void list(HttpServletRequest request, HttpServletResponse response) {
        List<DanhSachBenhAn> danhSachBenhAnList = this.iDanhSachBenhAnService.findAll();
        request.setAttribute("danhSachBenhAnList", danhSachBenhAnList);
        List<BenhAn> benhAnList = this.iDanhSachBenhAnService.findAllBenhAn();
        request.setAttribute("benhAnList", benhAnList);
        List<BenhNhan> benhNhanList = this.iDanhSachBenhAnService.findAllBenhNhan();
        request.setAttribute("benhNhanList", benhNhanList);
        try {
            request.getRequestDispatcher("student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        DanhSachBenhAn danhSachBenhAn = this.iDanhSachBenhAnService.findById(id);
        request.setAttribute("edit",danhSachBenhAn);
        try {
            request.getRequestDispatcher("student/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

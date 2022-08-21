/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DayOffDAO;
import dal.EmployeeDAO;
import dal.ProductDAO;
import helper.DateTimeHelper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import model.DayOff;
import model.DayOffType;
import model.Employee;
import model.Product;
import model.ViewDate;

/**
 *
 * @author Long
 */
public class TimeSheetServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimeSheetServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeSheetServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Sử lý chấm công ngày đi làm
        Date today = new Date();
        today = DateTimeHelper.removeTime(today);
        int dayOfMonth = DateTimeHelper.getDayOfMonth(today);
        Date begin = DateTimeHelper.addDays(today, (dayOfMonth - 1) * -1);  //Lấy ngày đầu tiên trong tháng hiện tại
        Date end = DateTimeHelper.addDays(DateTimeHelper.addMonths(begin, 1), -1);   //Lấy ngày cuối cùng trong tháng hiện tại
        ArrayList<ViewDate> dates = DateTimeHelper.getDates(begin, end);
        request.setAttribute("dates", dates);

        //Sử Lý Phần Nhân Viên đi làm
        EmployeeDAO nvd = new EmployeeDAO();
        ArrayList<Employee> listE = nvd.getListEmployee(begin, end);

        //Sử Lý Chấm Công Phần Nghỉ
        for (int i = 0; i < listE.size(); i++) {
                listE.get(i).setDayoff(nvd.getListDOTEmployee(begin, end, listE.get(i).getEid()));
        }
        request.setAttribute("listE", listE);

        //Sử Lý Phần Ký Hiệu Chấm Công
        DayOffDAO dod = new DayOffDAO();
        ArrayList<DayOffType> listDOT = dod.getListDOT();
        int sizeDOT = listDOT.size();
        request.setAttribute("listDOT", listDOT);
        request.setAttribute("sizeDOT", sizeDOT);

        request.getRequestDispatcher("view/home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

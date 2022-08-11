/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Question;

/**
 *
 * @author Long
 */
public class ForgetServlet extends HttpServlet {

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
            out.println("<title>Servlet ForgetServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgetServlet at " + request.getContextPath() + "</h1>");
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
        QuestionDAO db = new QuestionDAO();
        List<Question> questions = db.getListQuestion();
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("view/forget.jsp").forward(request, response);
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

//        //C1:   Hiển thị thông báo lỗi khi forget
//        String username = request.getParameter("username");
//        String answer = request.getParameter("answer");
//        String id_raw = request.getParameter("qid");
//        try {
//            int id = Integer.parseInt(id_raw);
//            AccountDAO ad = new AccountDAO();
//            String password = ad.getPassword(username, id, answer);
//            if (password != null) {
//                response.getWriter().print(password);
//            } else {
//                response.getWriter().print("Invalid question or answer or username");
//            }
//        } catch (Exception e) {
//        }

        //C2:  Hiển thị thông báo lỗi khi forget và trả về trang forget.jsp nhưng không dùng Severlet khác
        String username = request.getParameter("username");
        String answer = request.getParameter("answer");
        String id_raw = request.getParameter("qid");
        QuestionDAO db = new QuestionDAO();
        List<Question> questions = db.getListQuestion();
        try {
            int id = Integer.parseInt(id_raw);
            AccountDAO ad = new AccountDAO();
            String password = ad.getPassword(username, id, answer);
            if (password != null) {
                response.getWriter().print(password);
            } else {
                request.setAttribute("error", "Invalid question or answer or username");
                request.setAttribute("questions", questions);
                request.getRequestDispatcher("view/forget.jsp").forward(request, response);
            }
        } catch (Exception e) {
        }

//        //C3: Hiển thị thông báo lỗi khi forget và trả về trang forget.jsp nhưng dùng Severlet khác
//        String username = request.getParameter("username");
//        String answer = request.getParameter("answer");
//        String id_raw = request.getParameter("qid");
//        QuestionDAO db = new QuestionDAO();
//        List<Question> questions = db.getListQuestion();
//        try {
//            int id = Integer.parseInt(id_raw);
//            AccountDAO ad = new AccountDAO();
//            String password = ad.getPassword(username, id, answer);
//            if (password != null) {
//                response.getWriter().print(password);
//            } else {
//                request.setAttribute("error", "Invalid question or answer or username");
////                request.setAttribute("questions", questions);
////                response.sendRedirect("back");
////                request.getRequestDispatcher("back").forward(request, response);
//            }
//        } catch (Exception e) {
//        }
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

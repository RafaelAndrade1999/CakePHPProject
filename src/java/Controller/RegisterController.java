/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.UserDB;
import Model.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rafael Andrade
 */
@WebServlet(name = "ValidaCadastro", urlPatterns = {"/ValidaCadastro"})
public class RegisterController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaCadastro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaCadastro at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String nome = request.getParameter("txtNome");
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        String endereco = request.getParameter("txtEndereco");
        User u = new User(nome, email, senha,endereco);
        String redirect = "./Register";
        if(nome.length() < 3 ){
            //redirect += "Nome inválido";
            //redirect = URLEncoder.encode(redirect, "UTF-8");
            response.sendRedirect(redirect);
            return;
        }
        if(senha.length()<5){
            //redirect += "Senha com menos de 5 caracteres";
            response.sendRedirect(redirect);
            return;
        }
        if(!Util.validaEmail(email)){
            //redirect += "Email invalido";
            response.sendRedirect(redirect);
            return;
        }
        if(endereco.length() < 3){
            //redirect += "Endereco invalido";
            response.sendRedirect(redirect);
            return;
        }
        UserDB uBD = new UserDB();
        if(uBD.insereUsuario(u)){
            HttpSession session = request.getSession();
            session.setAttribute("sessao", u.getEmail());
            response.sendRedirect("./Index");
        }else{
            processRequest(request, response);
        }
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

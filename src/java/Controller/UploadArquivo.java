/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Rafael Andrade
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2,
                 maxFileSize=1024*1024*10,
                 maxRequestSize=1024*1024*50)
@WebServlet(name = "UploadArquivo", urlPatterns = {"/UploadArquivo"})
public class UploadArquivo extends HttpServlet {
     private int id = 0;
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
            out.println("<title>Servlet UploadArquivo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadArquivo at " + request.getContextPath() + "</h1>");
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
        Part part = request.getPart("arquivo");
        String nome = part.getSubmittedFileName();
        System.out.println(nome);
        String images_path = request.getServletContext().getRealPath("/uploads");
        InputStream in = part.getInputStream();
        images_path = images_path.replace('\\','/' );
        String formato = Util.retornaFormato(part.getContentType());
        if (formato != null) {
            Files.copy(in, Paths.get(images_path + "/" + nome ), StandardCopyOption.REPLACE_EXISTING);
        }
        part.delete();
        ArquivoBD arqBD = new ArquivoBD();
        Usuario us = getUsuario(request);
        arqBD.insereArquivo(new Arquivo(nome, us,  images_path, formato));
        response.sendRedirect("./Upload");
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
    
    public Usuario getUsuario(HttpServletRequest request){
        String email = (String)request.getSession().getAttribute("sessao");
        UsuarioBD usBD = new UsuarioBD();
        return usBD.getUsuario(email);
    }
}

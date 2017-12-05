/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.File;
import Model.FileDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael Andrade
 */
@WebServlet(name = "FileEditController", urlPatterns = {"/FileEditController"})
public class FileEditController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String fileName = request.getParameter("fileName");
            FileDB filDB = new FileDB();
            File file = filDB.getFile(id);
            String images_path = request.getServletContext().getRealPath("/uploads");
            Path source = Paths.get(images_path + "/" + file.getName() + file.getFormat());
            Files.move(source, source.resolveSibling(fileName + file.getFormat()));
            file.setName(fileName);
            filDB.update(file);
            out.println("{\"msg\": \"File edit completed!\",\"sucesso\": true,\"nome\":\""+file.getName()+"\" ,\"src\":\"uploads/"+fileName+file.getFormat()+"\"}");
        } catch (Exception err) {
            out.println("{\"msg\": \"Unable to edit file!\",\"sucesso\": false}");
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

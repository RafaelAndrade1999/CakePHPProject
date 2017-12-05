/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.File;
import Model.FileDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael Andrade
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

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
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>CakePHP - Build fast, grow solid | PHP Framework | Upload</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
            out.println("<link rel=\"shortcut icon \" type=\"image/x-png\" href=\"css/cakephp.png\">");
            out.println("<script src=\"js/jquery-3.2.1.js\" ></script>");
            out.println("<script src=\"js/progressbar.js\" ></script>");
            out.println("<script src=\"js/editfile.js\" ></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("     <div class=\"topdiv\">");
            out.println("           <a href=\"./Index\"><img src=\"css/cake-logo.svg\" id = \"logoo\"></a>");
            out.println("           <a href=\"\"><div class=\"donate\"><p class=\"donatetxt\">DONATE</p></div></a>");
            out.println("           <div class=\"dropdown\">");
            out.println("                 <button class=\"first\">Team</button>");
            out.println("           </div>");
            out.println("           <div class=\"dropdown\">");
            out.println("                 <button class=\"first\">Road Trip</button>");
            out.println("                 <img src=\"css/new-tag.svg\" class=\"new-tag\">");
            out.println("           </div>");
            out.println("           <div class=\"dropdown\">");
            out.println("                 <a href=\"./Profile\"><button class=\"first\">Profile</button></a>");
            out.println("           </div>");
            out.println("           <div class=\"dropdown\">");
            out.println("                 <a href=\"./Login\"><button class=\"first\">Login</button></a>");
            out.println("           </div>");
            out.println("           <div class=\"dropdown\">");
            out.println("                 <a href=\"./Register\"><button class=\"first\">Register</button></a>");
            out.println("           </div>");
            out.println("            <div class=\"dropdown\">");
            out.println("                 <a href=\"./Upload\"><button class=\"first\">Upload</button></a>");
            out.println("            </div>");
            out.println("           <form action=\"./Search\" method=\"GET\">");
            out.println("		<input type=\"text\" name=\"txtSearch\" />");
            out.println("		<a href=\"Search\"><button class=\"first\">Search</button></a>");
            out.println("           </form>");
            out.println("           <a href=\"\"><div class=\"lines\"></div></a>");
            out.println("     </div>");
            out.println("     <a href=\"\">");
            out.println("           <div class=\"cookbook\">");
            out.println("                 <p class=\"cookbooktxt\">CakePHP <strong>Cookbook</strong></p>");
            out.println("                 <img src=\"css/book.png\" class=\"book\">");
            out.println("           </div>");
            out.println("     </a>");
            out.println("     <a href=\"\">");
            out.println("           <div class=\"api\">");
            out.println("                 <p class=\"apitxt\">CakePHP <strong>API</strong></p>");
            out.println("                 <img src=\"css/tools.png\" class = \"tools\">");
            out.println("           </div>");
            out.println("     </a>");
            out.println("	<div class=\"listagem-container\">");
            out.println("		<div class=\"listagem\">");
            for (File a : new FileDB().getFiles(request.getParameter("txtSearch"))) {
                out.println("				<div class=\"item\">");
                out.println("					<div class=\"foto-listagem\">");
                out.println("						<img src=\"" + a.getDirectory() + "/" + a.getName() + "\">");
                out.println("					</div>");
                out.println("					<div class=\"descricao-listagem\">");
                out.println("						<p>File Name:" + a.getName() + "</p>");
                out.println("						<p>Directory: " + a.getDirectory() + "</p>");
                out.println("						<p>User:" + a.getUser().getName() + " </p>");
                out.println("					</div>");
                out.println("				</div>");
                if((boolean)request.getSession().getAttribute("adminSession") == true){
                    out.println("						<p><button class=\"dinamicbutton\" id=\"" + a.getId() + "\">Dynamic Button</button></p>");
                }
            }
            out.println("		</div>");
            out.println("	</div>");
            out.println("<div id=\"overlay\">");
            out.println(" <div id=\"progstat\"></div>");
            out.println("<div id=\"progress\"></div>");
            out.println("</div>");
            out.println("	<script src=\"js/ondemandjs.js\"></script>");
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

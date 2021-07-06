/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author manoj
 */

@MultipartConfig(location="C:/Users/manoj/Desktop/fsproject11/files", fileSizeThreshold=1024*1024,
    maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class compressMethod extends HttpServlet {
   private final static char[] letter = { 'a', 'b', 'c', 'd', 'e', 'f',
						'g', 'h', 'i', 'j', 'k', 'l',
						'm', 'n', 'o', 'p', 'q', 'r',
						's', 't', 'u', 'v', 'w', 'x',
						'y', 'z', '1', '2', '3', '4',
						'5', '6', '7', '8', '9', '0' };
		// Morse code by indexing
   private final static String[] code
			= { ".-", "-...", "-.-.", "-..", ".",
				"..-.", "--.", "....", "..", ".---",
				"-.-", ".-..", "--", "-.", "---",
				".--.", "--.-", ".-.", "...", "-",
				"..-", "...-", ".--", "-..-", "-.--",
				"--..", "|" };
    
    private static String englishToMorse(String englishLang)
	{
            StringBuffer sb =new StringBuffer();
		for (int i = 0; i < englishLang.length(); i++) {
			for (int j = 0; j < letter.length; j++) {
				if (englishLang.charAt(i) == letter[j]) {
					sb.append(code[j] + " ");
					break;
				}
			}
		}
                return sb.toString();
	}
    
    
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         String text=req.getParameter("code");
            String code= englishToMorse(req.getParameter("code").toString());
            req.setAttribute("text", text);
             req.setAttribute("code", code);
        req.setAttribute("flag", "true");
//            Scanner s =new Scanner(req.getParameter("file"));
            
            
        
              RequestDispatcher red = getServletContext()
      .getRequestDispatcher("/compress.jsp");
              red.forward(req, res);
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

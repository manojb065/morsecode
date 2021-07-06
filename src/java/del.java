

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manoj
 */
public class del extends HttpServlet {

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
          String id=request.getParameter("id");
          File file = new File("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\data.txt");
        Scanner s =new Scanner(new File("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\info.txt"));
        String k[]=s.nextLine().split(",");
        int tot=Integer.valueOf(k[1])-1;
       FileWriter fw = new FileWriter(new File("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\info.txt"));
            fw.write(k[0]+","+tot);
            fw.close();
          Scanner  f = new Scanner(file);
          ArrayList<String[]> data = new ArrayList<String[]>();
          while(f.hasNext()){
              String temp[]=f.nextLine().split(",");
              if(!temp[0].equalsIgnoreCase(id))
              data.add(temp);
          }
          f.close();
          
           fw = new FileWriter(file);
          for(String[] i:data){
              fw.write(i[0]+","+i[1]+","+i[2]+","+i[3]+"\n");
          }
          fw.close();
           RequestDispatcher red = getServletContext()
      .getRequestDispatcher("/filemanage");
              red.forward(request, response);
          
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

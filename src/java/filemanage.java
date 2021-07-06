
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author manoj
 */
public class filemanage extends HttpServlet {

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
        Scanner s =new Scanner(new File("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\info.txt"));
        String k[]=s.nextLine().split(",");
        if(request.getAttribute("method")!="post"){
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n" +
"    <title>FS Records</title>\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css\">\n" +
"</head>\n" +
"");
            
            out.println("<body style=\"background-color: rgb(160,160,160);\">\n" +
"   <center> <h1 \">Records</h1>\n" +
"    <p \"><strong>Number of Records ="+k[1]+"</strong></p>\n" +
"    <div class=\"table-responsive\" style=\"padding-left: 100px;padding-right: 100px;padding-top: 39px;\">\n" +
"        <table class=\"table\">");
            out.println(" <thead>\n" +
"                    <td>sl.no</td>\n" +
"                    <td>date</td>\n" +
"                    <td>text</td>\n" +
"                    <td>code</td>\n" +
"                    <td>delete</td>\n" +
"                </thead>");
            Scanner  f = new Scanner(new File("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\data.txt"));
            while(f.hasNext()){
                out.println("<tbody>");
                String t=f.nextLine();
                 String data[]=t.split("(,)");
                 for(String i:data){
                     System.out.println(i);
                 }
                    out.print("<tr><td>"+data[0]+"</td>");
                    out.print("<td>"+data[1]+"</td>");
                    out.print("<td>"+data[2]+"</td>");
                    out.print("<td>"+data[3]+"</td>");
                    out.print("<td><a href='del?id="+data[0]+"'>delete</a></td></tr>");
            }
            out.print("</tbody></table>");
            out.print("<footer></div><a href=\"home.html\" style=\"margin-top:5px;font-size: 24px;\">home</a></footer>");
            out.println("</center></body>");
            out.println("</html>");
        }
        
        
        }else{
            
            FileWriter f = new FileWriter(new File("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\data.txt"),true);
            int index=Integer.valueOf(k[0])+1;
            int tot=Integer.valueOf(k[1])+1;
            s.close();
            f.append(index+","+LocalDate.now()+","+request.getAttribute("text")+","+request.getAttribute("code")+"\n");
            f.close(); 
            f = new FileWriter(new File("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\info.txt"));
            f.write(index+","+tot);
            f.close();
            System.out.println("written into file");
           request.setAttribute("flag", "false");
           request.setAttribute("code",request.getAttribute("code"));
            RequestDispatcher red = getServletContext()
      .getRequestDispatcher("/compress.jsp");
              red.forward(request, response);
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

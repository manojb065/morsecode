
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
public class filemanage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
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
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css\">\n" +"<style>#myInput {\n" +
"  background-image: <i class=\"fas fa-search\"></i>;\n" +
"  background-position: 10px 10px;\n" +
"  background-repeat: no-repeat;\n" +
"  width: 100%;\n" +
"  font-size: 16px;\n" +
"  padding: 12px 20px 12px 40px;\n" +
"  border: 1px solid #ddd;\n" +
"  margin-bottom: 12px;\n" +
"}</style>"+
"</head>\n" +
"");
            
            out.println("<body style=\"background-color: rgb(160,160,160);\">\n" +
"   <center> <h1 \">Records</h1>\n" +
"    <p \"><strong>Number of Records ="+k[1]+"</strong></p>\n" +
"    <div class=\"table-responsive\" style=\"padding-left: 100px;padding-right: 100px;padding-top: 39px;\">\n" +
        "<input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"Search for SL.no\" title=\"Type in a Sl.no\">"+
"        <table class=\"table\" id='myTable'>");
            out.println(" <thead>\n" +
"                    <td>sl.no</td>\n" +
"                    <td>date</td>\n" +
"                    <td>text</td>\n" +
"                    <td>code</td>\n" +
"                    <td>delete</td>\n" +
"                </thead>");
            
            ObjectInputStream op = new ObjectInputStream(new  FileInputStream("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\data1.txt"));
            HashMap<Integer,String> map = (HashMap<Integer,String>) op.readObject();
           
            out.println("<tbody id='data'>");
            for(HashMap.Entry<Integer,String> m : map.entrySet()){
                
                String t=m.getValue().toString();
                
                 String data[]=t.split("(,)");
              
                    out.print("<tr ><td>"+m.getKey()+"</td>");
                    out.print("<td>"+data[0]+"</td>");
                    out.print("<td>"+data[1]+"</td>");
                    out.print("<td>"+data[2]+"</td>");
                    out.print("<td><a href='del?id="+m.getKey()+"'>delete</a></td></tr>");
            }
            out.print("</tbody></table>");
            out.print("<footer></div><a href=\"home.html\" style=\"margin-top:5px;font-size: 24px;\">home</a></footer>");
            out.println("</center><script>\n" 
                    
                    + "function myFunction() {\n" +

"  var input, filter, table, tr, td, i, txtValue;\n"
                    + "console.log('pressed');" +
"  input = document.getElementById(\"myInput\");\n" +
"  filter = input.value;\n" +
"  tr = document.getElementById(\"data\").getElementsByTagName('tr');\n" +
 "console.log(input);" +
 "console.log(tr);" +
"  // Loop through all table rows, and hide those who don't match the search query\n" +
"  for (i = 0; i < tr.length; i++) {\n" +
"    td = tr[i].getElementsByTagName(\"td\")[0].innerText;\n"
                    +
                    
"    if (td) {\n" +
"      if (filter==td.substring(0,filter.length)) {\n" +
"        tr[i].style.display = \"\";\n" +
"      } else {\n" +
"        tr[i].style.display = \"none\";\n" +
"      }\n" +
"    }\n" +
"  }\n" +
"}"+

"</script></body>");
            out.println("</html>");
            op.close();
            
        }
        
        
        }else{
            
            FileWriter f = new FileWriter(new File("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\data.txt"),true);
            int index=Integer.valueOf(k[0])+1;
            int tot=Integer.valueOf(k[1])+1;
            s.close();
            ObjectInputStream op = new ObjectInputStream(new  FileInputStream("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\data1.txt"));
            HashMap<Integer,String> map = (HashMap<Integer,String>) op.readObject();

            StringBuffer sb =new StringBuffer();
            sb.append(LocalDate.now()+",");
            sb.append(request.getAttribute("text")+",");
            sb.append(request.getAttribute("code"));
            map.put(index, sb.toString());
            System.out.println(map);
            op.close();
            ObjectOutputStream ow = new ObjectOutputStream(new FileOutputStream("C:\\Users\\manoj\\Desktop\\fsproject11\\files\\data1.txt"));
            ow.writeObject(map);
            ow.close();
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(filemanage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(filemanage.class.getName()).log(Level.SEVERE, null, ex);
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

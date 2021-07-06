<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Compress</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
</head>


<body style="background-color: rgb(160,160,160);">
    <h1 style="padding-left: 502px;font-size: 30px;padding-top: 35px;">Compression is done here!</h1>
    <form style="padding-left: 590px;padding-right: 270px;padding-top: 36px;" action="compressMethod" method="get">
        <div class="form-group"><textarea class="form-control" name="code" style="height: 68px;width: 212px;margin-left: -21px;"></textarea><br>
            <button class="btn btn-primary" type="submit" style="margin: 6px;height: 34px;width: 78px;background-color: rgb(0,150,200);padding-left: 17px;margin-left: 52px;margin-top: 21px;">submit</button></div>
    </form>
    <!--<p style="padding-left: 643px;">Paragraph</p>-->
<!--    <div></div><a href="/decompress.html" style="padding-left: 580px;">decompress</a><a href="#"></a><a href="/records.html" style="padding-left: 15px;">record</a><a href="/index.html" style="padding-left: 15px;">home</a>-->
    


<!--        <h1>Welcome to compress!</h1>
        <form action="compressMethod" method="get">
            <textarea name="code" rows="5" cols="5" placeholder="enter code here..."></textarea>
            <input type="submit"/>
            
        </form>-->
      
        <%
            if(request.getAttribute("code")!=null){
            
            out.print("<p style='padding-left: 643px;'>"+request.getAttribute("code")+"</p>");
            if(request.getAttribute("flag")=="true"){
            request.setAttribute("code", request.getAttribute("code"));
            request.setAttribute("text", request.getAttribute("text"));
        request.setAttribute("method", "post");
        System.out.println("enterd");
    RequestDispatcher rd = request.getRequestDispatcher("/filemanage");
    
    rd.forward(request, response);
    System.out.println("exited");
            }
            out.print("<div></div><a href='decompress.jsp' style='padding-left: 580px;'>decompress</a><a href='#'></a><a href='filemanage'style='padding-left: 15px;'>record</a><a href='home.html' style='padding-left: 15px;'>home</a>");
   
            }
           
                %>
</body>
    
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Decompress</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<!--        <h1>Welcome to Decompress!</h1>
        <form action="decompressMethod" method="get">
            <textarea name="code" rows="5" cols="5" placeholder="enter code here..."></textarea>
            <input type="submit"/>-->
            
<body style="background-color: rgb(160,160,160);" >
    <h1 style="padding-left: 502px;font-size: 30px;padding-top: 35px;">Decompression is done here!</h1>
    <form style="padding-left: 590px;padding-right: 270px;padding-top: 36px;" action="decompressMethod" method="get">
        <div class="form-group"><textarea class="form-control" name="code" style="height: 68px;width: 212px;margin-left: -21px;"></textarea><br><button class="btn btn-primary" type="submit" style="margin: 6px;height: 34px;width: 78px;background-color: rgb(0,150,200);padding-left: 17px;margin-left: 52px;margin-top: 21px;">submit</button></div>
    </form>
    <!--<p style="padding-left: 643px;">Paragraph</p>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>

       
        <%
            
            if(request.getAttribute("code")!=null){
            out.print("<p style='padding-left: 643px;'>"+request.getAttribute("code")+"</p>");
            out.print("<div></div><a href='compress.jsp' style='padding-left: 580px;'>compress</a><a href='#'></a><a href='filemanage' style='padding-left: 15px;'>record</a><a href='home.html' style='padding-left: 15px;'>home</a>");
            }
        
                %>
                
    </body>
    
</html>

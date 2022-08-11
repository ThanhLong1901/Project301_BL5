<%-- 
    Document   : confirm
    Created on : Aug 10, 2022, 10:26:00 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            var count = 3;
            function counting()
            {
                var span = document.getElementById("timer");
                count--;
                span.innerHTML = count;
                if (count <= 0)
                {
                    //Nơi trang sẽ di chuyển đến
                    window.location.href = "list";
                }
            }
            setInterval(counting, 1000);
        </script>
    </head>
    <body>
        <div>Redirect to Forget Form after <span id="timer">3</span> seconds</div>
    </body>
</html>

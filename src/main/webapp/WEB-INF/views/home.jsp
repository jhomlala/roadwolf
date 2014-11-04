<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery.timepicker.js"></script>
		  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jquery.timepicker.css" />
		

        
		
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" >
        <title>Rozkład jazdy PKS Zielona Góra </title>
    </head>
    <body>
    <center><h1>Rozkład jazdy</h1></center>
    <div class="main">
    <center>
    <h2>Rozkład dla trasy Krosno Odrzańskie -> Zielona Góra</h2><br>
    <h3>Wybierz godzine:</h3>

  
      
    
    
    <form action="/tf2la/course"  method="post">
    <p><input id="timeformatExample1" type="text" class="time" name="time" /> 

            <script>
                $(function() {
                    $('#timeformatExample1').timepicker({ 'timeFormat': 'H:i:s',  'step': 15 });
                });
            </script>
    <br><br><input type="submit">
    </p>
    </form>
	</div> <br><br>

    	
    </body>
    
    
    
    
</html>

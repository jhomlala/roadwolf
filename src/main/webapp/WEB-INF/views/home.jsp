<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"> </script>
       	 <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"> </script>
       	 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
       	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jquery.datetimepicker.css"/ >
       	 <script src="${pageContext.request.contextPath}/resources/jquery.datetimepicker.js"></script>
       	 <script src="${pageContext.request.contextPath}/resources/jquery.autocomplete.js"></script>
       	 <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
		 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
         <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" >
         <script type="text/javascript" src="${pageContext.request.contextPath}/resources/autoComplete.js"></script>
         <title>RoadWolf.pl </title>
	     <script>
			  $(function() {
			    $( "#dialog" ).dialog({
			      autoOpen: false,
			      show: {
			        effect: "blind",
			        duration: 1000
			      },
			      hide: {
			        effect: "explode",
			        duration: 1000
			      }
			    });
			 
			    $( "#opener" ).click(function() {
			      $( "#dialog" ).dialog( "open" );
			    });
			  });
		  </script>
	      <script>
                $(function() {
                	jQuery('#datetimepicker').datetimepicker(
                        	{
                            	mask:true,
                            	lang:'pl',
                            });
                	
                });

           </script>
            <script>
			  $(function() {
			    $( document ).tooltip();
			  });
  
           </script>
    </head>
    <body>
    <center><h1>RoadWolf.pl - Rozkład jazdy</h1></center>
    <div class="main">

    <center>
    <form action="/tf2la/course"  method="post"> 
		<br>
		 <div class="ui-widget">
                <label for="cityFrom">Z:</label>
                <input id="cityFrom" name="cityFrom" />
         		<input id="cityFromHidden" type="hidden" name="cityFromHidden" >
                <label for="cityTo">Do:</label>
                <input id="cityTo" name="cityTo" />
                <input id="cityToHidden" type="hidden" name="cityToHidden">
            </div>
	    <br><br><br>  
        Czas:<input id="datetimepicker" name="datetimepicker" title='Data i czas o ktorej chcesz wyruszyc.' type="text" >

      <br/>


 
    <br><br><input type="submit">
    
    </form>
    
     
    
    </center>
	</div> <br><br>

    	
    </body>
    
    
    

</html>

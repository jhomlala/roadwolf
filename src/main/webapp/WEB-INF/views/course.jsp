<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <table>
    	<tr>
    		<td>Skad</td><td>Dokad</td><td>Odjazd</td><td>Przyjazd</td><td>Oznaczenia</td><td>Przystanki</td><td>Przewoźnik</td>
    	</tr>
    <c:forEach var="element" items="${cslist}">
    	<tr>
   			<td>${element.getDepartureCity().getCityName()}</td>
   			<td>${element.getArrivalCity().getCityName()}</td>
   			<td><c:if test="${element.getDepartureTime().getHour()<10}"><c:out value="0"/></c:if>${element.getDepartureTime().getHour()}:<c:if test="${element.getDepartureTime().getMinute()<10}"><c:out value="0"/></c:if>${element.getDepartureTime().getMinute()}</td>
   			<td><c:if test="${element.getArrivalTime().getHour()<10}"><c:out value="0"/></c:if>${element.getArrivalTime().getHour()}:<c:if test="${element.getArrivalTime().getMinute()<10}"><c:out value="0"/></c:if>${element.getArrivalTime().getMinute()}</td>
   			<td><c:forEach items="${element.getSymbolList()}" var="symbol">

                     <a href="#" class='hastip' title='${symbol.getSymbolDescription()}'>${symbol.getSymbolShort()}</a>
        	
                 </c:forEach>
            </td><td>
            <a href="#" title="
            <c:forEach items="${element.getStopList() }" var="stop">
            	${stop.getCityName() } - ${stop.getArrivalTime().getHour() }:${stop.getArrivalTime().getMinute() } - ${stop.getDepartureTime().getHour() }:${stop.getDepartureTime().getMinute() } 
            </c:forEach>">Zobacz przystanki</a></td>
            <td>${element.getOperatorID() }</td>
   		</tr>
	</c:forEach>
    
    </center>
	</div> <br><br>

    	
    </body>
    
    
    
    <script type="text/javascript">
		$('.hastip').tooltipsy();
	</script>
</html>

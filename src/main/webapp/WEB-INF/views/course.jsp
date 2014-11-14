<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery.timepicker.js"></script>
		  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/tooltipsy.min.js"></script>
		  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jquery.timepicker.css" />
		

        
		
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" >
        <title>RoadWolf.pl </title>
    </head>
    <body>
    <center><h1>RoadWolf.pl - Rozkład jazdy</h1></center>
    <div class="main">
    <center>

    <table>
    	<tr>
    		<td>Skad</td><td>Dokad</td><td>Odjazd</td><td>Przyjazd</td><td>Oznaczenia</td>
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
            </td>
   		</tr>
	</c:forEach>
    
    </center>
	</div> <br><br>

    	
    </body>
    
    
    
    <script type="text/javascript">
		$('.hastip').tooltipsy();
	</script>
</html>

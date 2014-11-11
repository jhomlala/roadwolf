<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
		
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" >
        <title>Rozkład jazdy PKS Zielona Góra </title>
    </head>
    <body>
    <center><h1>Rozkład jazdy</h1></center>
    <div class="main">
    ${timeMapped.getHour()}
    <center>
    <h2>Rozkład dla trasy Krosno Odrzańskie -> Zielona Góra</h2><br>
    <table>
    	<tr>
    		<td>Skad</td><td>Dokad</td><td>Przyjazd</td><td>Odjazd</td><td>Oznaczenia</td>
    	</tr>
    <c:forEach var="element" items="${cslist}">
    	<tr>
   		<td>${element.getDepartureCityID()}</td><td>${element.getArrivalCityID()}</td><td>${element.getArrivalTime()}</td><td>${element.getDepartureTime()}</td><td>symbol</td>
   		</tr>
	</c:forEach>
    
    </center>
	</div> <br><br>

    	
    </body>
    
    
    
    
</html>

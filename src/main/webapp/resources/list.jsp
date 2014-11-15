
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.jhomlala.spring.controller.Startup" %> 
<%@page import="com.jhomlala.spring.model.City" %>
<%@page import="com.jhomlala.spring.controller.CityMapper" %>
<%@page import="java.util.*" %>
<%

//jQuery related start
String query = (String)request.getParameter("q");

List <City> cityList = Startup.getCityMapper().getCityList();

int cnt=1;
for(int j=0;j<cityList.size();j++)
{
    if(cityList.get(j).getCityName().toUpperCase().startsWith(query.toUpperCase()))
    {
       out.print(cityList.get(j).getCityName()+"\n");
       if(cnt>=5)// 5=How many results have to show while we are typing(auto suggestions)
       break;
       cnt++;
     }
}
//jQuery related end
%>
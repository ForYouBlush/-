<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="errorpage.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挑选您的学生</title>
</head>
<jsp:useBean id="deter" scope="page" class="Bean.determine"/>
<body style="background:url(1.jpg); " text="#FFFFFF" link="#FF00">
<%
String tea_id=(String)session.getAttribute("id");
%>
<div align="center">
  <p><font color="#FF00" size="+3" face="方正舒体">您所带的班级及学生 </font></p>
  <p>&nbsp; </p>
  <table width="75%" border="1">
    <tr> 
      <td>班级号</td>
      <td>课程名</td>
      <td>选择</td>
    </tr>
<%
String class_id=null;
String cour_name=null;
ResultSet rs=deter.getClass(tea_id);
while(rs.next()){
class_id=rs.getString("id");
cour_name=rs.getString("name");
%>	
    <tr> 
      <td><%=class_id%></td>
      <td><%=cour_name%></td>
      <td><a href="MarkSvlt?class_id=<%=class_id%>&cour_name=<%=cour_name%>&action=accept ">选择</a></td>
    </tr>
<%
}
%>
  </table>
  <p>&nbsp;</p>
  <p align="left"><a href="teacher.jsp">&lt;&lt;Back</a></p>
</div>
</body>
</html>

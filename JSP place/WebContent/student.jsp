<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="errorpage.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="background:url(1.jpg); " text="#FF00" link="#FF00">  
<p>
<%
String id = (String)session.getAttribute("id");
//if(stu_id==null){response.sendRedirect("login.jsp");}                                 
%>
  <font size="+2" face="华文行楷">您已经成功通过验证! 您可以使用如下服务：</font> </p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="58%"  border="0" align="center">
  <tr> 
    <td><a href="DisplayCourse.jsp">选修课程</a></td>
    <td><a href="StudentLoginSvlt?id=<%=id%>&action=checkmark">查看学分</a></td>
    <td><a href="updateinformation.jsp">更改信息</a></td>
  </tr>
</table>
<p>&nbsp;</p><p>&nbsp;</p><p><a href="login_confirm?action=logout">&lt;&lt;注销 </a></p>
</body>
</html>
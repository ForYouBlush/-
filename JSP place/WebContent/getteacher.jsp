<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
</head>
<jsp:useBean id="teacher" scope="page" class="Bean.teacher"/>
<body style="background:url(1.jpg); " text="#FFFFFF" link="#FF00">
<%
String id="",name="",title="",password="";
%>
<p align="center"><font color="#FF00" size="+3" face="华文行楷">所有教师</font></p>
<p><a href="addteacher.jsp">新增教师</a></p>

  <p>&nbsp;</p>
  <table width="75%"  border="1" align="center">
    <tr> 
      <td>教师号</td>
      <td>姓名</td>
      <td>职称</td>
      <td>密码</td>
      <td>删除</td>
      <td>更改</td>
    </tr>
    <%
ResultSet rs=teacher.getAll();
while(rs.next()) {
id=rs.getString("id");
name=rs.getString("name");
title=rs.getString("title");
password=rs.getString("password");

%>
    <tr>
      <td><%=id%></td>
      <td><%=name%></td>
      <td><%=title%></td>
      <td><%=password%></td>
      <td><a href="TeacherSvlt?action=delete&id=<%=id%>">删除</a></td>
      <td><a href="updatetea.jsp?id=<%=id%>">更新</a></td>
    </tr>
    <%
 }
 %>
  </table>
<p><a href="admin.jsp">&lt;&lt;BackTo Admin</a></p>
</body>
</html>

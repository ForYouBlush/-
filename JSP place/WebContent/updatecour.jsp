<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="errorpage.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确定课程</title>
</head>
<jsp:useBean id="course" scope="page" class="Bean.course"/>
<body style="background:url(1.jpg); " text="#FFFFFF" link="#FF00">
<p>
<%
String id="",name="";
id=request.getParameter("id");
%>
<form  method="post" action="CourseSvlt">
  <input type="hidden" name="action" value="update">
  <input type="hidden" name="id" value="<%=id%>">
</p>
<p align="center"><font color="#FF00" size="+3" face="方正舒体">更新课程</font></p>
<p align="center">&nbsp;</p>
  <table width="37%"  border="1" align="center">
    <tr> 
      <td width="37%">课程名</td>
      <td width="63%"><input name="name" type="text" id="name"></td>
    </tr>
    <tr> 
      <td>学分</td>
      <td><select name="mark" size="1" id="mark">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select></td>
    </tr>
    <tr> 
      <td>系别</td>
      <td><select name="dep" size="1" id="dep">
          <option>public</option>
          <option>计算机</option>
          <option>机械系</option>
          <option>艺术系</option>
          <option>数理系</option>
        </select></td>
    </tr>
    <tr> 
      <td>预修课</td>
      <td><select name="prepare" size="1" id="prepare">
          <option value="0">无预修课</option>
          <%
ResultSet rs=course.getPrepares();
while(rs.next()) {
name=rs.getString("name");
id=rs.getString("id");
%>
          <option value="<%=id%>"><%=name%></option>
          
          <%
}
%>
        </select> </td>
    </tr>
  </table>
  <p align="center"> 
    <input type="submit" name="Submit" value="提交">
  </p>
</form>
<p>&nbsp;</p>
<p><a href="getcourse.jsp">&lt;&lt;Back</a> </p>
</body>
</html>

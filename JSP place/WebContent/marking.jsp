<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="errorpage.jsp" %>
<html>	
<body style="background:url(1.jpg); ">
<%
String stu_id=request.getParameter("stu_id");
String class_id=request.getParameter("class_id");
%>
 <p>&nbsp;</p>
<p align="center"><font color="#FF00" size="+3" face="方正舒体">学生成绩</font></p>
<form method="post" action="MarkSvlt">
  <input type="hidden" name="action" value="marking">
  <input type="hidden" name="id" value="<%=stu_id%>">
  <input type="hidden" name="class_id" value="<%=class_id%>">
  <table width="75%" border="1" align="center">
    <tr> 
      <td width="41%">学生号</td>
      <td width="59%">成绩</td>
    </tr>
    <tr> 
      <td><%=stu_id%></td>
      <td><input name="score" type="text" id="score"></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <div align="center">
    <input type="submit" name="Submit" value="提交">
  </div>
</form>
</body>
</html>

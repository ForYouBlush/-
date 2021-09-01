<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.io.*"  %>


<HTML>
<HEAD><TITLE>Output</TITLE><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></HEAD>

<BODY style="background:url(1.jpg); " text="#FFFFFF" link="#00FF00">
<P align="center"><FONT COLOR="#660000" SIZE=2><B> 
  <%
	if (exception != null) {
		out.print(exception.toString());
	} else if (request.getAttribute("problem") != null) {
		String str =(String) request.getAttribute("problem");
		// byte[] tmpbyte=str.getBytes("ISO8859_1");
// str=new String(tmpbyte);
%>
  <%= str %> 
  <% } else { %>
  (No error code) 
  <% } %>
  </B></P>

<P><B>
<p> <a href="javascript:history.back();"> &lt;&lt;Back</a> </p>
</B></P>
</BODY>
</HTML>

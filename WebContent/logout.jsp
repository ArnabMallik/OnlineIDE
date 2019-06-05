<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=D0D0D0>

<%

HttpSession s=request.getSession();

s.invalidate();


%>

<center>



<font color='#0000FF'><b>You have successfully logged out......Thank you Do visit again</b></font>

<a href='index.html'>Go to login page</a>



</center>

</body>
</html>
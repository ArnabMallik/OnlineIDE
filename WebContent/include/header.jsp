<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%! public int factorial(int n)
    
    {
    
    return n==0?1:n*factorial(n-1);
    

    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is the header</h1>

<%!int n=10;%>
<table border="1">
<tr><th>n</th><th>n!</th></tr>
<% 
for(int i=0;i<=n;i++)
	


{

%>

<tr><td><%=i %></td><Td><%=factorial(i) %></Td></tr>
<%

}

%>

</table>
</body>
</html>
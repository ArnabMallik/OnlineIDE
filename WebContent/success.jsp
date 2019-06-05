<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*"%>
    
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <style>  
    div { border: 3px solid; padding: 5px;  }  
    div.left { text-align: left; background: #ffcccc; }  
    div.right { text-align: right; background: #ccccff; }  
   
  </style>  
    
    
    
    </head>

<body bgcolor=D0D0D0>
<div class="right"><em><%=Currenttime.getdate() %>,<%=Currenttime.getday() %></em></div>
<div class="right"><em><%=Currenttime.gettime() %> <%=Currenttime.getAMPM() %></em></div> 
<div class="left"><em>
<b>Welcome,</b>

<%=((User)session.getAttribute("user")).getFirstname()%>  
<%=((User)session.getAttribute("user")).getLastname() %>



</em></div>








<h2><li><a href="upload.jsp">Click here to upload a source file</a></li></h2>
<h2><li><a href="editcompile.jsp">Click here to view,edit or compile saved files</a></li></h2>
<h2><li><a href="deregister.jsp">Click here to deregister yourself</a></li></h2>
<h2><li><a href="deleteFile.jsp">Click here delete a file</a></li></h2>
<h2><li><a href="logout.jsp">Click here to Log out</a></li></h2>

</body>
</html>
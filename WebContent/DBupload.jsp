<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>

function autofill(f)

{
	f.abc.value=f.filetoupload.value;

	}







</script>
<body>
<form method="post" action="DataBaseUploadServlet" enctype="multipart/form-data">

File name <input type="text" id="abc" name="abc" onclick="autofill(this.form)">

<input type="file" id="filetoupload" name="uploaded">

<input type="submit" value="upload">


</form>

</body>
</html>
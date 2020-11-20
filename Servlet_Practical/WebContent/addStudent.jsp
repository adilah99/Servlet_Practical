<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>add student form</title>
    </head>
    <body>
    <center>

<form action="addStudent" method="POST" >

	<h1>Add new student</h1>
	<p>Enter Student ID: <input type="text" name="id" /></p> 
	<p>Enter password: <input type="text" name="password" /></p>
	<p>Enter name: <input type="text" name="name" /></p>
	<p>Enter department: <input type="text" name="department" /></p>
	<p>Enter science mark: <input type="text" name="science" /></p>
	<p>Enter mathematics mark: <input type="text" name="math" /></p>
	<p>Enter english mark: <input type="text" name="english" /></p>
	
	
	<p><input type="submit" value="Submit" />
        <button type='reset'>Reset</button></p>
</form>
</center>
</body>
</html>

</body>
</html>
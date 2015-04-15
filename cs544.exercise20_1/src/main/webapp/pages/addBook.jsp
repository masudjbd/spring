<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Book</title>
        <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">

</head>
<body>
        <h3>Book Add</h3>

	<form action="books" method="post">
	<table>
		<tr>
			<td>Title :</td>
			<td><input type="text" name="title" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="isbn" /> </td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type="text" name="author" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" /> </td>
		</tr>
	</table>
	<input class="btn btn-primary"  type="submit"/>
	
	</form>
</body>
</html>
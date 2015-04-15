<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
        <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">

</head>
<body>
            <h3>Car Add</h3>

	<form action="cars" method="post">
	<table>
		<tr>
			<td>Make:</td>
			<td><input type="text" name="make" /> </td>
		</tr>
		<tr>
			<td>Model:</td>
			<td><input type="text" name="model" /> </td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><input type="text" name="year" /> </td>
		</tr>
		<tr>
			<td>Color:</td>
			<td><input type="text" name="color" /> </td>
		</tr>
	</table>
	<input class="btn btn-primary"  type="submit"/>
	
	</form>
</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
        <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css" rel="stylesheet">

</head>
<body>
	<form action="../cars/${car.id}" method="post">
	<table>
		<tr>
			<td>Make:</td>
			<td><input type="text" name="make" value="${car.make}" /> </td>
		</tr>
		<tr>
			<td>Model:</td>
			<td><input type="text" name="model" value="${car.model}" /> </td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><input type="text" name="year" value="${car.year}" /> </td>
		</tr>
		<tr>
			<td>Color:</td>
			<td><input type="text" name="color" value="${car.color}" /> </td>
		</tr>
	</table>
                <button  class="btn btn-primary"  ><i class="icon icon-white icon-edit"></i> update</button>
	</form>
	<form action="delete?carId=${car.id}" method="post">
		<button class="btn btn-primary"  type="submit"><i class="icon icon-white icon-trash"></i> Delete</button>
	</form>
</body>
</html>
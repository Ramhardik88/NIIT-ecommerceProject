<%@include file="Header.jsp"%>
<html>
<body>
<h2>Welcome to Supplier Page!</h2>
<form action="addSupplier" method="post">

	<table align="center" class="table-bordered">
		<tr>
			<td colspan ="2">Supplier Detail</td>
		</tr>
		<tr>
			<td>Supplier Name</td>
			<td><input type="text" name="supplierName"/></td>
		</tr>
		<tr>
			<td>Supplier Address</td>
			<td><input type="text" name="supplierAddress"/></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="Enter Supplier"/></td>
		</tr>
	</table>
</form>
<table align="center" class="table">
	<tr>
		<td colspan = "5"><center>Supplier Detail</center></td>
	</tr>
	</tr>
	<tr>
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Address</td>
		<td>Edit Supplier</td>
		<td>Delete Supplier</td>
	</tr>
	<c:forEach items="${supplierList }" var = "supplier">
		<tr>
		
			<td>${supplier.supplierID }</td>
			<td>${supplier.supplierName }</td>
			<td>${supplier.supplierAddress }</td>
			<td><a href="<c:url value="/editSupplier/${supplier.supplierID}"/>">Edit</a></td>
			<td><a href="<c:url value="/deleteSupplier/${supplier.supplierID}" />">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>
<%@include file="Footer.jsp"%>
</html>

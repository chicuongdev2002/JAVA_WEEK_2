<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa thông tin khách hàng</title>
    <link rel="stylesheet" type="text/css" href="css/edit.css">

</head>
<body>
<h1>Sửa thông tin khách hàng</h1>
<form action="customer-severlet?action=update" method="POST">
    <input type="hidden" name="custId" value="<%= request.getAttribute("customerToEdit.custId") %>">
    <label for="custName">Tên khách hàng:</label>
    <input type="text" id="custName" name="custName" value="<%= request.getAttribute("customerToEdit.custName") %>"><br>
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="<%= request.getAttribute("customerToEdit.email") %>"><br>
    <label for="email">Address:</label>
    <input type="text" id="address" name="email" value="<%= request.getAttribute("customerToEdit.address") %>"><br>
    <label for="email">Phone:</label>
    <input type="text" id="phone" name="email" value="<%= request.getAttribute("customerToEdit.phone") %>"><br>
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>

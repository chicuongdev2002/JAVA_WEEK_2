<%--
  Created by IntelliJ IDEA.
  User: Win 11
  Date: 9/25/2023
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Registration</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>

</head>
<body>
<h1>Employee Registration</h1>
<form id="employeeForm">
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" required><br><br>

    <label for="dob">Ngày sinh:</label>
    <input type="date" id="dob" name="dob" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br><br>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" required><br><br>

    <label for="status">Status:</label>
    <select id="status" name="status">
        <option value=1>ACTIVE</option>
        <option value=0>IN_ACTIVE</option>
        <option value=-1>TERMINATED</option>
    </select><br><br>

    <button type="submit">Register</button>
</form>

<script>
    const employeeForm = document.getElementById('employeeForm');

    employeeForm.addEventListener('submit', function (e) {
        e.preventDefault();
        // Lắng nghe sự kiện khi người dùng nhập dữ liệu vào trường "dob"
        document.getElementById('dob').addEventListener('blur', function() {
            // Lấy giá trị ngày tháng từ trường "dob"
            var dobValue = this.value;

            // Kiểm tra nếu giá trị không rỗng
            if (dobValue.trim() !== '') {
                // Chuyển đổi chuỗi thành đối tượng LocalDateTime bằng moment.js
                var dobDate = moment(dobValue, 'YYYY-MM-DD').toDate();

                // Kiểm tra nếu đối tượng LocalDateTime hợp lệ
                if (moment(dobDate).isValid()) {
                    // Làm gì đó với đối tượng LocalDateTime ở đây
                    console.log('Ngày tháng hợp lệ:', dobDate);
                } else {
                    console.log('Ngày tháng không hợp lệ.');
                }
            } else {
                console.log('Trường "dob" không được để trống.');
            }
        });
        const fullName = document.getElementById('fullName').value;
        const email = document.getElementById('email').value;
        const address = document.getElementById('address').value;
        const phone = document.getElementById('phone').value;
        const status = document.getElementById('status').value;
       // const dobDate = document.getElementById('dob').value;
        const employee = {
            fullName: fullName,
            email: email,
            address: address,
            phone: phone,
            status: status,
            dob: dobDate

        }

              console.log(dobDate)
        // Gửi dữ liệu lên máy chủ để thêm nhân viên mới bằng Axios
        axios.post('http://localhost:8080/20020331_NguyenChiCuong/api/employee', employee)
            .then(response => {
                if (response.status === 201) {
                    alert('Employee registered successfully.');
                    // Xóa dữ liệu trong biểu mẫu sau khi đăng ký thành công
                    employeeForm.reset();
                } else {
                    alert('Failed to register employee.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('An error occurred while registering employee.');
            });
    });
</script>
</body>
</html>


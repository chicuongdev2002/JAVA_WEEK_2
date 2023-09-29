
const apiUrl = 'http://localhost:8080/20020331_NguyenChiCuong/api/employee';
axios.get(apiUrl)
    .then(response => {
        const data = response.data;
        console.log(data);
        renderData(data);
    })
    .catch(error => {
        // Xử lý lỗi nếu có
        console.error('Lỗi:', error);
    });
function renderData(data) {
    const tbody = document.querySelector('tbody');
    tbody.innerHTML = '';

    data.forEach((employee, index) => {
        const row = document.createElement('tr'); // Tạo một thẻ <tr> mới

        // Tạo các thẻ <td> cho từng cột dữ liệu
        const sttCell = document.createElement('td');
        sttCell.textContent = index + 1;

        const empIdCell = document.createElement('td');
        empIdCell.textContent = employee.empId;

        const fullNameCell = document.createElement('td');
        fullNameCell.textContent = employee.fullName;

        const emailCell = document.createElement('td');
        emailCell.textContent = employee.email;

        const addressCell = document.createElement('td');
        addressCell.textContent = employee.address;

        const phoneCell = document.createElement('td');
        phoneCell.textContent = employee.phone;

        const statusCell = document.createElement('td');
        statusCell.textContent = employee.status;

        const actionCell = document.createElement('td');
        const editButton = document.createElement('a');
        //Xử lí cho Edit
        editButton.className = 'btn btn-primary btn-sm';
        editButton.href = '#';
        editButton.textContent = 'Edit';
        //Xử lí cho delete
        const deleteButton = document.createElement('a');
        deleteButton.className = 'btn btn-danger btn-sm';
        deleteButton.textContent = 'Del';
        deleteButton.setAttribute('data-id', employee.empId);
        deleteButton.onclick = (event) => deleteEmployee(event);
        //Xử lí cho insert
        const insertbutton = document.createElement('a');
        insertbutton.className = 'btn btn-success btn-sm';
        insertbutton.href = 'addEmployee.jsp';
        insertbutton.textContent = 'Insert';

        actionCell.appendChild(editButton);
        actionCell.appendChild(deleteButton);
        actionCell.appendChild(insertbutton);
        // Thêm các thẻ <td> vào thẻ <tr>
        row.appendChild(sttCell);
        row.appendChild(empIdCell);
        row.appendChild(fullNameCell);
        row.appendChild(emailCell);
        row.appendChild(addressCell);
        row.appendChild(phoneCell);
        row.appendChild(statusCell);
        row.appendChild(actionCell);

        tbody.appendChild(row);
    });
}
function deleteEmployee(event) {
    const empId = event.target.getAttribute('data-id');
    axios.delete(`http://localhost:8080/20020331_NguyenChiCuong/api/employee/${empId}`)
        .then(response => {
            renderData(data);
        })
        .catch(error => {
            console.log(empId)
            console.error('Lỗi:', error);
        });
}
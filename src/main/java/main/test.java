package main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.EmployeeStatus;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.Customer;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.Employee;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8080/20020331_NguyenChiCuong/api/employee");
        ArrayList<Employee> listEmployees = new ArrayList<Employee>();
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String apiData = EntityUtils.toString(httpResponse.getEntity());
        // Chuyển đổi chuỗi JSON thành danh sách đối tượng Employee
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    objectMapper.registerModule(new JavaTimeModule());
//                    ArrayList<Employee> listEmployee = objectMapper.readValue(apiData, new TypeReference<ArrayList<Employee>>() {});
        //listEmployee.forEach(p-> System.out.println(p));
        JSONArray jsonArray = new JSONArray(apiData);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            long empId = obj.getLong("empId");
            String fullName = obj.getString("fullName");
            String email = obj.getString("email");
            String phone = obj.getString("phone");
            String address = obj.getString("address");
//                        String dobString = obj.getString("dob");
//                        LocalDateTime dob = LocalDateTime.parse(dobString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            JSONArray dobArray = obj.getJSONArray("dob");
            int year = dobArray.getInt(0);
            int month = dobArray.getInt(1);
            int day = dobArray.getInt(2);
            int hour = dobArray.getInt(3);
            int minute = dobArray.getInt(4);
            LocalDateTime dob = LocalDateTime.of(year, month, day, hour, minute);
            EmployeeStatus status = EmployeeStatus.valueOf(obj.getString("status"));
            Employee employee = new Employee(empId, fullName, dob, email, phone, address, status);
            listEmployees.add(employee);
            System.out.println(listEmployees);
        }

    }
}

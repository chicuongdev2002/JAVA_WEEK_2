package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.reposities;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.EmployeeStatus;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.Employee;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmployeeRepository {
    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> listEmployees = new ArrayList<>();
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("http://localhost:8080/20020331_NguyenChiCuong/api/employee");

            HttpResponse httpResponse = httpClient.execute(httpGet);
            String apiData = EntityUtils.toString(httpResponse.getEntity());

            JSONArray jsonArray = new JSONArray(apiData);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                long empId = obj.getLong("empId");
                String fullName = obj.getString("fullName");
                String email = obj.getString("email");
                String phone = obj.getString("phone");
                String address = obj.getString("address");
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
                //System.out.println(listEmployees);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listEmployees;
    }
    public static boolean deleteEmployee(long empId) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpDelete httpDelete = new HttpDelete("http://localhost:8080/20020331_NguyenChiCuong/api/employee/" + empId);
            HttpResponse httpResponse = httpClient.execute(httpDelete);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            return statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_NO_CONTENT;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

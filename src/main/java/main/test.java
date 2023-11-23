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
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.ProductStatus;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.*;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.reposities.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
//        CustomerRepository c=new CustomerRepository(Customer.class);
//        System.out.println(c.getAll());
        ProductRepository productRepository =new ProductRepository(Product.class);
        ProductPriceRepository productPriceRepository =new ProductPriceRepository(ProductPrice.class);
        ProductImageRepository productImageRepository =new ProductImageRepository();
        System.out.println(productImageRepository.getImageById(1));
//        System.out.println(productPriceRepository.getPriceById(1));
//        Product product1 = productRepository.getById(1);
//        Product product2 = productRepository.getById(2);
//        Cart cart = new Cart();
//   cart.setProducts(new ArrayList<>());
//        System.out.println(cart.getProducts().add(product1));
//        System.out.println(cart.getProducts().add(product2));
//        System.out.println(cart);

    }
}

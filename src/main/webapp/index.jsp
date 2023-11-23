<%@ page import="vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.ProductStatus" %>
<%@ page import="vn.edu.iuh.fit.lab_week_2_nguyenchicuong.reposities.ProductRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.lab_week_2_nguyenchicuong.reposities.ProductPriceRepository" %>
<%@ page import="vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.ProductPrice" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Shop</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <style>
    body, h1, h2, h3, p, ul, li {
      margin: 0;
      padding: 0;
    }

    /* Thiết lập font chung cho trang */
    body {
      font-family: 'Arial', sans-serif;
    }

    /* Header và menu */
    header {
      background-color: #333; /* Màu nền header */
      padding: 10px 0;
    }

    nav {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 0 20px;
    }

    .logo {
      color: #fff; /* Màu chữ logo */
      font-size: 1.5em;
      text-decoration: none;
    }

    .nav-menu {
      list-style-type: none;
      display: flex;
    }

    .nav-item {
      margin-right: 20px;
    }

    .nav-link {
      color: #fff; /* Màu chữ menu */
      text-decoration: none;
      font-size: 1.1em;
      font-weight: bold;
    }

    .nav-link:hover {
      color: #ff5733; /* Màu chữ menu khi hover */
    }
    body {
      font-family: Arial, sans-serif;
      margin: 0;
    }

    .cart-container {
      display: flex;
      justify-content: flex-end;
      align-items: center;
      padding: 10px;
    }

    .cart-icon {
      position: relative;
      cursor: pointer;
    }

    #cart-count {
      position: absolute;
      top: -10px;
      right: -10px;
      background-color: red;
      color: white;
      border-radius: 50%;
      padding: 5px 8px;
      font-size: 12px;
    }

  </style>



</head>
<body>
<!-- header -->
<header>
  <nav>
    <ul class="nav-menu">
      <li class="nav-item"><a href="#" class="nav-link">Trang chủ</a></li>
      <li class="nav-item"><a href="#" class="nav-link">Sản Phẩm</a></li>
      <li class="nav-item"><a href="admin-severlet" class="nav-link">Admin</a></li>
      <li class="nav-item"><a href="#" class="nav-link">Khác</a></li>
    </ul>
    <div class="cart-container">
      <a href="cart-severlet?action=viewToCart">
        <div class="cart-icon" id="cart-icon">
          🛒
          <%
            Integer count = (Integer) request.getAttribute("count");
            if (count != null) {
              out.print(count.intValue());
            } else {
              count =0;
            }
          %>
          <span id="cart-count"><%=count%></span>
        </div>
      </a>
    </div>
  </nav>
</header>
<!-- content -->
<section class="wrapper">
  <h1 class="text-center mb-3 mt-3"> Danh mục sản phẩm</h1>
  <div class="row" id="product">
    <%
      ProductRepository productRepository=new ProductRepository(Product.class);
      ProductPriceRepository productPriceRepository=new ProductPriceRepository(ProductPrice.class);
      List<Product> list = productRepository.getAll();
      for (Product product : list) {
        if (product.getStatus().equals(ProductStatus.ACTIVE)) {
          System.out.println(product.getImages().get(0).getPath());
    %>
    <div class="col-md-3">
      <div class="card" >
        <img src="<%=product.getImages().get(0).getPath()%>" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title"> <%=product.getName()%></h5>
          <p class="card-text"><%=product.getDescription()%></p>

          <%
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##"); // Định dạng số
            String formattedPrice = decimalFormat.format(productPriceRepository.getPriceById(product.getProduct_id()));
          %>
          <p class="card-text">
            <span class="fw-bold product-price" style="color: #ff5733;">₫<%=formattedPrice%></span>
          </p>
          <a href="cart-severlet?action=addToCart&id=<%=product.getProduct_id()%>" class="btn btn-primary">Thêm vào giỏ hàng</a>
        </div>
      </div>
    </div>
    <%
        }}
    %>
  </div>
</section>
<!-- footer -->
<footer>
  <div class="footer-item">
    <div class="img-footer">
      <img src="img/logo.png" alt="" />
    </div>
    <div class="social-footer">
      <li><a target="_blank" href="">
        <i class="fa fa-facebook-square" aria-hidden="true"></i>
      </a></li>
      <li><a target="_blank" href="">
        <i class="fa fa-github-square" aria-hidden="true"></i>
      </a></li>

    </div>
  </div>
</footer>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Shop</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="view/css/index.css" />
</head>
<body>
<!-- header -->
<header>
  <nav>
    <div class="img-nav">
      <img src="img/logo.png" alt="" />
    </div>
    <div class="content-nav">
      <ul>
        <li><a href="#">Trang chủ</a></li>
        <li><a href="#">Sản Phẩm</a></li>
        <li><a href="view/admin/admin.jsp">Admin</a></li>
        <li><a href="#">Khác</a></li>
      </ul>
      <form>
        <input type="text" name="search" placeholder="Tìm kiếm sản phẩm" />
        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
      </form>
    </div>
    <!-- The Modal -->
    <button id="cart">
      <i class="fa fa-shopping-basket" aria-hidden="true"></i>
    Giỏ hàng
    </button>
    <div id="myModal" class="modal">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Giỏ hàng</h5>
          <span class="close">&times;</span>
        </div>
        <div class="modal-body">
          <div class="cart-row">
            <span class="cart-item cart-header cart-column">Sản phẩm</span>
            <span class="cart-price cart-header cart-column">Giá</span>
            <span class="cart-quantity cart-header cart-column">Số Lượng</span>
          </div>
          <div class="cart-items">

          </div>
          <div class="cart-total">
            <strong class="cart-total-title">Tổng tiền:</strong>
            <span class="cart-total-price">0VN?</span>
          </div>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-secondary close-footer">Đóng</button>
          <button type="button" class="btn btn-primary order">Thanh Toán</button>
        </div>
      </div>
    </div>
  </nav>
</header>
<!-- content -->
<section class="wrapper">
  <div class="products">
    <ul>
      <li class="main-product">
        <div class="img-product">
          <img class="img-prd"
               src="https://hc.com.vn/i/ecommerce/media/GS.008514_FEATURE_93821.jpg"
               alt="">
        </div>
        <div class="content-product">
          <h3 class="content-product-h3">Tên</h3>
          <div class="content-product-deltals">
            <div class="price">
              <span class="money">Giá</span>
            </div>
            <button type="button" class="btn btn-cart">Thêm vào giỏ</button>
          </div>
        </div>
      </li>
      <li class="main-product">
        <div class="img-product">
          <img class="img-prd"
               src="https://techland.com.vn/wp-content/uploads/2019/09/dien-thoai-iphone-11-pro-max-4.jpg"
               alt="">
        </div>
        <div class="content-product">
          <h3 class="content-product-h3">Tên sản phẩm</h3>
          <div class="content-product-deltals">
            <div class="price">
              <span class="money">Giá?</span>
            </div>
            <button type="button" class="btn btn-cart">Thêm vào giỏ</button>
          </div>
        </div>
      </li>
      <li class="main-product">
        <div class="img-product">
          <img class="img-prd"
               src="https://cdn.nguyenkimmall.com/images/detailed/756/dien-thoai-iphone-13-pro-128gb-bac-1.jpg"
               alt="">
        </div>
        <div class="content-product">
          <h3 class="content-product-h3">Tên sản phẩm</h3>
          <div class="content-product-deltals">
            <div class="price">
              <span class="money">Giá</span>
            </div>
            <button type="button" class="btn btn-cart">Thêm vào giỏ</button>
          </div>
        </div>
      </li>
      <li class="main-product no-margin">
        <div class="img-product">
          <img class="img-prd"
               src="https://prices.vn/photos/8/product/dien-thoai-iphone-xs-64gb.jpg"
               alt="">
        </div>
        <div class="content-product">
          <h3 class="content-product-h3">Tên sản phẩm</h3>
          <div class="content-product-deltals">
            <div class="price">
              <span class="money">Giá</span>
            </div>
            <button type="button" class="btn btn-cart">Thêm vào giỏ</button>
          </div>
        </div>
      </li>
    </ul>
  </div>
</section>
<!-- footer -->
<footer>
  <div class="footer-item">
    <div class="img-footer">
      <img src="img/logo.png" alt="" />
    </div>
    <div class="social-footer">
      <li><a target="_blank" href="https://www.facebook.com/thanhlongdev">
        <i class="fa fa-facebook-square" aria-hidden="true"></i>
      </a></li>
      <li><a target="_blank" href="https://github.com/long1211">
        <i class="fa fa-github-square" aria-hidden="true"></i>
      </a></li>

    </div>
  </div>
</footer>
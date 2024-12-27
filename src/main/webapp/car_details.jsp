<%@ page import="com.model.CarRental" %>
<%@ page import="com.service.CarDetailService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.CarMaintenance" %>
<%@ page import="com.service.CarRentalService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Car Details</title>
  <link rel="stylesheet" href="css/backstage.css">
  <!--这里引入的是矢量图标签库-->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</head>

<body>
<div class="wrapper">
  <div class="sidebar">
    <div class="bg_shadow"></div>
    <div class="sidebar_inner">
      <div class="close">
        <i class="fas fa-times"></i>
      </div>
      <div class="profile_info">
        <div class="profile_img">
          <img src="images/logo_logo.png" alt="">
        </div>
        <div class="profile_data">
          <p class="name">懂车王</p>
          <span>
                            <i class="fas fa-map-marker-alt"></i>
                            用户名
                        </span>
        </div>
      </div>

      <ul class="siderbar_menu">
        <li>
          <a href="#" class="menu-item" data-target="page1">
            <div class="icon">
              <i class="fas fa-heart"></i>
            </div>
            <div>主页</div>
          </a>
        </li>
        <li>
          <a href="#" class="menu-item" data-target="page2">
            <div class="icon">
              <i class="fas fa-user"></i>
            </div>
            <div>智能推荐ai</div>
          </a>
        </li>
        <li>
          <a href="#" class="menu-item" data-target="page3">
            <div class="icon">
              <i class="fas fa-receipt"></i>
            </div>
            <div>汽车信息查询</div>
          </a>
        </li>
        <li>
          <a href="#" class="menu-item" data-target="page4">
            <div class="icon">
              <i class="fas fa-credit-card"></i>
            </div>
            <div>汽车排行</div>
          </a>
        </li>
        <li>
          <a href="#" class="menu-item" data-target="page5">
            <div class="icon">
              <i class="fas fa-unlock"></i>
            </div>
            <div>汽车资讯</div>
          </a>
        </li>
        <li>
          <a href="#" class="menu-item" data-target="page6">
            <div class="icon">
              <i class="fas fa-unlock"></i>
            </div>
            <div>二手车出租</div>
          </a>
        </li>
      </ul>
      <div class="logout_btn">
        <a href="#">退出登陆</a>
      </div>
    </div>
  </div>
  <div class="main_container">
    <div class="navbar">
      <div class="hamburger">
        <i class="fas fa-bars"></i>
      </div>
      <div class="logo">
        <a href="header.jsp">主页logo</a>
      </div>
    </div>
    <div class="content">
      <div id="page1" class="page" style="display: none;">
        介绍用户系统主要功能
      </div>
      <div id="page2" class="page" style="display: none;">
        <iframe
                src="https://bisheng.dataelem.com/chat/assistant/3a2b7843-54b2-40a5-980e-5aecdb07ac12"
                style="width: 100%; height: 100%; min-height: 700px"
                frameborder="0"
                allow="fullscreen;clipboard-write">
        </iframe>
      </div>
      <div id="page3" class="page" style="display: none;">汽车信息查询</div>
      <div id="page4" class="page" style="display: none;">汽车排行</div>
      <div id="page5" class="page" style="display: none;">汽车资讯</div>
      <div id="page6" class="page">
        <%
          // 获取传递过来的汽车 ID
          String carIdStr = request.getParameter("id");
          int carId = Integer.parseInt(carIdStr);

          // 获取汽车信息
          CarRental car = (CarRental) request.getAttribute("car");
          if (car == null) {
            // 获取汽车信息
            CarRentalService carRentalService = new CarRentalService();
            car = carRentalService.getCarById(carId);
            request.setAttribute("car", car);
          }

          // 获取维护记录
          CarDetailService carDetailService = new CarDetailService();
          List<CarMaintenance> maintenances = carDetailService.getMaintenanceByCarId(carId);
          request.setAttribute("maintenances", maintenances);
        %>
        <h2>汽车详细信息</h2>
        <p>ID: <%= car.getId() %></p>
        <p>品牌: <%= car.getBrand() %></p>
        <p>里程: <%= car.getMileage() %></p>
        <p>年龄: <%= car.getAge() %></p>
        <p>价格: <%= car.getPrice() %></p>
        <p>联系方式: <%= car.getContactWay() %></p>
        <p>照片: <img src="<%= car.getCarPhoto() %>" alt="Car Photo" style="width: 200px;"></p>
        <h3>维护记录</h3>
        <table border="1">
          <thead>
          <tr>
            <th>ID</th>
            <th>维护日期</th>
            <th>维护类型</th>
            <th>描述</th>
            <th>费用</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="maintenance" items="${maintenances}">
            <tr>
              <td>${maintenance.id}</td>
              <td>${maintenance.maintenanceDate}</td>
              <td>${maintenance.maintenanceType}</td>
              <td>${maintenance.description}</td>
              <td>${maintenance.cost}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        <a href="zhuye.jsp">返回汽车列表</a>
      </div>
    </div>
  </div>
</div>

<script src="js/backstage.js"></script>
</body>

</html>

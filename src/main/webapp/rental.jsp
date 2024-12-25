<!-- rental.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rental Page</title>
    <link rel="stylesheet" href="css/backstage.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
            <div id="page6" class="page" style="display: block;">
                <h2>Add Rental</h2>
                <form action="rental?action=add" method="post">
                    <label for="car_id">Car ID:</label>
                    <input type="number" id="car_id" name="car_id" required><br><br>
                    <label for="user_id">User ID:</label>
                    <input type="number" id="user_id" name="user_id" required><br><br>
                    <label for="start_date">Start Date:</label>
                    <input type="date" id="start_date" name="start_date" required><br><br>
                    <label for="end_date">End Date:</label>
                    <input type="date" id="end_date" name="end_date" required><br><br>
                    <label for="status_id">Status ID:</label>
                    <select id="status_id" name="status_id" required>
                        <option value="1">PENDING</option>
                        <option value="2">RENTED</option>
                        <option value="3">RETURNED</option>
                    </select><br><br>
                    <button type="submit">Add Rental</button>
                </form>

                <h2>Update Rental</h2>
                <form action="rental?action=update" method="post">
                    <label for="rental_id">Rental ID:</label>
                    <input type="number" id="rental_id" name="rental_id" required><br><br>
                    <label for="car_id_update">Car ID:</label>
                    <input type="number" id="car_id_update" name="car_id" required><br><br>
                    <label for="user_id_update">User ID:</label>
                    <input type="number" id="user_id_update" name="user_id" required><br><br>
                    <label for="start_date_update">Start Date:</label>
                    <input type="date" id="start_date_update" name="start_date" required><br><br>
                    <label for="end_date_update">End Date:</label>
                    <input type="date" id="end_date_update" name="end_date" required><br><br>
                    <label for="status_id_update">Status ID:</label>
                    <select id="status_id_update" name="status_id" required>
                        <option value="1">PENDING</option>
                        <option value="2">RENTED</option>
                        <option value="3">RETURNED</option>
                    </select><br><br>
                    <button type="submit">Update Rental</button>
                </form>

                <h2>Delete Rental</h2>
                <form action="rental?action=delete" method="post">
                    <label for="rental_id_delete">Rental ID:</label>
                    <input type="number" id="rental_id_delete" name="rental_id" required><br><br>
                    <button type="submit">Delete Rental</button>
                </form>

                <h2>Query Rentals</h2>
                <form action="rental?action=query" method="get">
                    <label for="query_car_id">Car ID:</label>
                    <input type="number" id="query_car_id" name="car_id"><br><br>
                    <label for="query_user_id">User ID:</label>
                    <input type="number" id="query_user_id" name="user_id"><br><br>
                    <label for="query_start_date">Start Date:</label>
                    <input type="date" id="query_start_date" name="start_date"><br><br>
                    <label for="query_end_date">End Date:</label>
                    <input type="date" id="query_end_date" name="end_date"><br><br>
                    <button type="submit">Query Rentals</button>
                </form>

                <h2>All Rentals</h2>
                <table border="1">
                    <tr>
                        <th>Rental ID</th>
                        <th>Car ID</th>
                        <th>User ID</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Total Price</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach var="rental" items="${rentals}">
                        <tr>
                            <td>${rental.rentalId}</td>
                            <td>${rental.carId}</td>
                            <td>${rental.userId}</td>
                            <td>${rental.startDate}</td>
                            <td>${rental.endDate}</td>
                            <td>${rental.totalPrice}</td>
                            <td>${rental.statusName}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="js/backstage.js"></script>
</body>
</html>
